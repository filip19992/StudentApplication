package pl.filipwlodarczyk.StudentApplication.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Filip",
                        "filipwlodarczyk99@gmail.com",
                        LocalDate.of(1999, Month.JANUARY, 4),
                        22
                )
        );
    }
}
