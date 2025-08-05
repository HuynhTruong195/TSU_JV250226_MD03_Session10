package ex.jv.Model.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "studentName", nullable = false)
    private String studentName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ageMark", nullable = false, columnDefinition = "float check(ageMark>0)")
    private Float ageMark;

    private Boolean isStudying = true;


}
