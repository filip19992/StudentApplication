package pl.filipwlodarczyk.StudentApplication.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentService {



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
