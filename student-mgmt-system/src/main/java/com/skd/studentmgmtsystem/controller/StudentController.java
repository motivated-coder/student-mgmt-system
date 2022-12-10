package com.skd.studentmgmtsystem.controller;

import com.skd.studentmgmtsystem.entity.Student;
import com.skd.studentmgmtsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/register")
    public String register(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "createStudent";
    }

    @GetMapping("/registerStudent")
    public String registerStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/student/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute Student student) {
        Student oldStudent = studentService.getStudentById(id);
        oldStudent.setFname(student.getFname());
        oldStudent.setLname(student.getLname());
        oldStudent.setEmail(student.getEmail());
        studentService.saveStudent(oldStudent);
        return "redirect:/students";
    }
}
