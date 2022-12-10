package com.skd.studentmgmtsystem.repository;

import com.skd.studentmgmtsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
