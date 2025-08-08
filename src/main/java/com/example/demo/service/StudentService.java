package com.example.demo.service;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    public Student getStudentByUUID(String uuid) {
        String sql = "SELECT * FROM demo.student s WHERE s.id = :id";
        return (Student) entityManager
                .createNativeQuery(sql, Student.class)
                .setParameter("id", uuid)
                .getSingleResult();
    }
}
