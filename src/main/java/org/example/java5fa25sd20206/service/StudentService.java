package org.example.java5fa25sd20206.service;

import lombok.RequiredArgsConstructor;
import org.example.java5fa25sd20206.entity.Student;
import org.example.java5fa25sd20206.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {

        return studentRepository.getAllStudents();
    }
}
