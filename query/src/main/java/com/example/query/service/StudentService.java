package com.example.query.service;

import com.example.query.dao.QueryRepo;
import com.example.query.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    QueryRepo repo;
    public void saveStudent(Student student){
        repo.save(student);
    }
    public List<Student> getByfirstname(String firstname){
        return repo.findByFirstname(firstname);
    }
    public List<Student> getAll(){
        return repo.findAll();
    }

    public List<Student> findByAge(int age) {
        return repo.findByAge(age);
    }

    public List<Student> findGreaterThenAge(int age) {
        return repo.findStudentGreaterThanAge(age);
    }

    public List<Student> getByFirstnameOrLastName(String firstname, String lastname) {
       return repo.findByFirstnameOrLastname(firstname,lastname);
    }
}
