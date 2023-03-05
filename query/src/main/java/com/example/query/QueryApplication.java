package com.example.query;

import com.example.query.dao.QueryRepo;
import com.example.query.model.Student;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
@OpenAPIDefinition
public class QueryApplication implements CommandLineRunner {
  @Autowired
	QueryRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student=new Student();
		student.setStatus(true);
		student.setAge(20);
		student.setAdmissionDate(Date.valueOf(LocalDate.now()));
		student.setFirstName("Sonu");
		student.setLastName("Kumar");
		repo.save(student);
	}
}
