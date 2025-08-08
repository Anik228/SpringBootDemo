package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;
    @Autowired
    private StudentService studentService;
    //get all the students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

    //localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();

        return student;

    }

    @PostMapping("/student/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = repo.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);

    }

    @PutMapping("/student/update/{id}")
    public Student updateStudents(@PathVariable int id) {
        Student student = repo.findById(id).get();
        student.setName("poonam");
        student.setPercentage(92);
        repo.save(student);
        return student;

    }
    @DeleteMapping("/student/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        repo.delete(student);
    }

//    @GetMapping("/students/uuid/{uuid}")
//    public Student getStudentByUUID(@PathVariable String uuid) {
//        return studentService.getStudentByUUID(uuid);
//    }

    @GetMapping("/get-a-student")
    public Student getStudentById(@RequestParam(required = true) String id) {
        return studentService.getStudentByUUID(id);
    }

/* mvn clean spring-boot:run
*  mvn spring-boot:run
*http://localhost:8080/swagger-ui/index.html*/
}