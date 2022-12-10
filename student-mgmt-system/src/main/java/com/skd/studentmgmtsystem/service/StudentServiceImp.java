package com.skd.studentmgmtsystem.service;

import com.skd.studentmgmtsystem.exception.StudentNotFoundException;
import com.skd.studentmgmtsystem.entity.Student;
import com.skd.studentmgmtsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student s){
        return studentRepository.save(s);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student doen't exist with ID" + id));
    }

    @Override
    public void delete(int id) {
        Student s = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student doesn't exist for ID "+id));
        studentRepository.delete(s);
    }
}
