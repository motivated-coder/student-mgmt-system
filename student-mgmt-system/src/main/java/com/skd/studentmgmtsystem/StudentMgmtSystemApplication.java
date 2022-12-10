package com.skd.studentmgmtsystem;

import com.skd.studentmgmtsystem.entity.Student;
import com.skd.studentmgmtsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMgmtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtSystemApplication.class, args);
	}
}
