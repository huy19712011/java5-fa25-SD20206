package org.example.java5fa25sd20206.controller;

import lombok.RequiredArgsConstructor;
import org.example.java5fa25sd20206.entity.Student;
import org.example.java5fa25sd20206.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {

        // get students from db
        List<Student> students = studentService.getAllStudents();

        // send data to view
        model.addAttribute("students", students);

        return "views/students"; // students.html

    }

    @GetMapping("/students/showNewStudentForm")
    public String showNewStudentForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);

        return "views/new_student";
    }

    @PostMapping("/students/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {

        // save data to DB
        studentService.saveStudent(student);

        // return view
        return "redirect:/students";
    }
}
