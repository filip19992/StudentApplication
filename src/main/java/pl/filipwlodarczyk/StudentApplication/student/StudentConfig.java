package pl.filipwlodarczyk.StudentApplication.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student filip = new Student(
                    "Filip",
                    "filipwlodarczyk99@gmail.com",
                    LocalDate.of(1999, Month.JANUARY, 5),
                    22);

            Student maciek = new Student(
                    "Maciek",
                    "maciekswieca9@gmail.com",
                    LocalDate.of(1979, Month.SEPTEMBER, 10),
                    42);

            studentRepository.saveAll(List.of(filip, maciek));
        };

    }
}
