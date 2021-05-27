package pl.filipwlodarczyk.StudentApplication.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = repository.findStudentByEmail(student.getEmail());
        if ((studentByEmail.isPresent()) && (student.getAge() < 16)) {
            throw new IllegalStateException("Email taken");
        }
        repository.save(student);
    }


    public void deleteStudentById(Long studentId) {
        boolean existsById = repository.existsById(studentId);
        if (existsById) {
            repository.deleteById(studentId);
        } else {
            throw new IllegalArgumentException("Student with this Id doesnt exsist");
        }

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = repository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("This student doesnt exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(name, student.getName())) {
            student.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(email, student.getEmail())) {
            student.setEmail(email);
        }


    }
}
