package org.example.java5fa25sd20206.service;

import lombok.RequiredArgsConstructor;
import org.example.java5fa25sd20206.entity.Student;
import org.example.java5fa25sd20206.repository.StudentRepository;
import org.example.java5fa25sd20206.repository.StudentRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class StudentService {

    /*
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

    public void deleteStudentById(long id) {

        studentRepository.deleteStudentById(id);
    }

    public Student getStudentById(long id) {

        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Student student) {

        studentRepository.updateStudent(student);
    }
    */

    final
    StudentRepositoryV2 studentRepositoryV2;

    public StudentService(StudentRepositoryV2 studentRepositoryV2) {
        this.studentRepositoryV2 = studentRepositoryV2;
    }

    public List<Student> getAllStudents() {

        return studentRepositoryV2.findAll();
    }

    public void saveStudent(Student student) {

        this.studentRepositoryV2.save(student);
    }

    public void deleteStudentById(long id) {

        studentRepositoryV2.deleteById(id);
    }

    public Student getStudentById(long id) {

        return studentRepositoryV2.findById(id).get();
    }

    public void updateStudent(Student student) {

        studentRepositoryV2.save(student);
    }
}
