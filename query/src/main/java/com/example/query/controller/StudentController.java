package com.example.query.controller;

import com.example.query.model.Student;
import com.example.query.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentService service;
    @PostMapping
    public void addStudent(@RequestBody Student student){
       service.saveStudent(student);
    }
    @GetMapping("/firstname")
    public List<Student> getStudentByFirstName(@RequestParam String firstname){
       return service.getByfirstname(firstname);
    }
    @GetMapping("/all")
    public List<Student> getStudent(){
        return service.getAll();
    }
    @GetMapping("/age")
    public List<Student> findByAge(@RequestParam int age){
        return service.findByAge(age);
    }
    @GetMapping("/greaterthan/age")
    public List<Student> findGreaterthenage(@RequestParam int age){
        return  service.findGreaterThenAge(age);
    }
    @GetMapping("/find")
    public List<Student> getByFirstnameOrLastName(@Nullable @RequestParam String firstname,@Nullable @RequestParam String lastname){

        return service.getByFirstnameOrLastName(firstname,lastname);
    }
}
