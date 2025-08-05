package ex.jv.Model.DTO;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {

    private long id;

    @NotBlank(message = "Tên không được trống")
    private String studentName;

    @NotBlank(message = "Email không được trống")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Email không hợp lệ theo định dạng chuẩn"
    )
    private String email;

    @NotNull(message = "Điểm không được để trống")
    @Min(value = 0, message = "Điểm phải lớn hơn 0")
    private Float ageMark;


    private Boolean isStudying;
}
