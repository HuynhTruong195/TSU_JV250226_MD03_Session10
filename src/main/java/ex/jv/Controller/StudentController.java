package ex.jv.Controller;

import ex.jv.Model.DTO.StudentDTO;
import ex.jv.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/students")
    public String findAllStudents(Model model) {
        List<StudentDTO> dtoList = studentService.findAll();
        model.addAttribute("studentList", dtoList);
        return "studentList";
    }

    @GetMapping("/initCreat")
    public String initCreate(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "newStudentForm";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "newStudentForm";
        } else {
            studentService.save(studentDTO);
            return "redirect:students";
        }
    }

    @GetMapping("/initUpdate")
    public String initUpdate(Model model, long id) {
        StudentDTO studentDTO = studentService.findById(id);
        model.addAttribute("studentDTO", studentDTO);
        return "updateStudentForm";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "updateStudentForm";
        } else {
            studentService.update(studentDTO);
            return "redirect:students";
        }
    }

    @GetMapping("/delete")
    public String delete(long id) {
        studentService.delete(id);
        return "redirect:students";
    }

    @GetMapping("/search")
    public String search(Model model ,@RequestParam("keyword") String keyword) {
      List<StudentDTO> student;
      if (keyword != null && !keyword.trim().equals("")) {
        student = studentService.findByName(keyword);
      }else {
          student = studentService.findAll();
      }
      model.addAttribute("studentList", student);
      model.addAttribute("keyword", keyword);
//        System.out.println("Kết quả tìm kiếm: " + student.size());
//        student.forEach(s -> System.out.println(s.getStudentName()));
      return "studentList";

    }

}
