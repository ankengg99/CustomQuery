package com.example.query.dao;

import com.example.query.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepo extends JpaRepository<Student,Integer> {
@Query(value ="select * from student where first_name=:firstname and status=true",nativeQuery = true)
    public List<Student> findByFirstname(String firstname);

    @Query(value ="select * from student where status=true",nativeQuery = true)
    public List<Student> findAll();

@Query(value="select * from student age=:age",nativeQuery = true)
    public List<Student> findByAge(int age);

@Query(value="select * from student where first_name=:firstname or last_name=:lastname",nativeQuery = true)
    public List<Student> findByFirstnameOrLastname(String firstname,String lastname);

    @Query(value="select * from student where age>:age",nativeQuery = true)
    public List<Student> findStudentGreaterThanAge(int age);
}
