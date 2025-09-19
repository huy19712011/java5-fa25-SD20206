package org.example.java5fa25sd20206.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.java5fa25sd20206.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final EntityManager em;

    public List<Student> getAllStudents() {

        return em.createQuery("from Student", Student.class).getResultList();
    }
}
