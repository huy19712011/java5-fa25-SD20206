package org.example.java5fa25sd20206.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java5fa25sd20206.entity.Student;
import org.example.java5fa25sd20206.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {

/*        // get students from db
        List<Student> students = studentService.getAllStudents();

        // send data to view
        model.addAttribute("students", students);

        return "views/students"; // students.html
*/
        return findPaginated(1, "name", "asc", model);


    }

    @GetMapping("/students/showNewStudentForm")
    public String showNewStudentForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);

        return "views/new_student";
    }

    @PostMapping("/students/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "views/new_student";
        }

        // save data to DB
        studentService.saveStudent(student);

        // return view
        return "redirect:/students";
    }

    @GetMapping("/students/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") long id) {

        // delete student by id
        studentService.deleteStudentById(id);

        // return view
        return "redirect:/students";

    }

    @GetMapping("/students/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") long id, Model model) {

        // get student
        Student student = studentService.getStudentById(id);

        // send data to view
        model.addAttribute("student", student);
        return "views/update_student";
    }

    @PostMapping("/students/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student) {

        // update to DB
        studentService.updateStudent(student);

        // return view
        return "redirect:/students";
    }

    @GetMapping("students/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 1;

        Page<Student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Student> students = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("students", students);
        return "views/students";
    }


}
