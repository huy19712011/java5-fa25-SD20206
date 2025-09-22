package org.example.java5fa25sd20206.service;

import lombok.RequiredArgsConstructor;
import org.example.java5fa25sd20206.entity.Student;
import org.example.java5fa25sd20206.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {

        return studentRepository.getAllStudents();
    }

    public void saveStudent(Student student) {

        this.studentRepository.saveStudent(student);
    }
}
