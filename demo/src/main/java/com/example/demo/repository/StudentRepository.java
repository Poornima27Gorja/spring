package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	//custom method
	List<Student> findByName(String name);
	Student findByNameAndPhone(String name, long phone);
	
	//custom query
	@Query("select s from Student s where s.name=:name")
	List<Student> getStudentByName(String name);
	
	//passing SQL query directly
	@Query(nativeQuery = true, value = "select * from student")
	List<Student> getAllStudents();
}
