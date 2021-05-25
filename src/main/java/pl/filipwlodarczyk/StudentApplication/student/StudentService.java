package pl.filipwlodarczyk.StudentApplication.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student addNewStudent(Student student) {
        System.out.println(student);
        return repository.save(student);
    }

    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }
}
