package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.College;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/studentt")
	public Student saveS(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@PostMapping("/studentts")
	public List<Student> saveAllS(@RequestBody List<Student> students){
		return service.saveAllStudents(students);
	}
	
	@GetMapping("/studentt/{id}")
	public Student findSById(@PathVariable int id) {
		return service.findStudentById(id);
	}
	
	@GetMapping("/studentt")
	public List<Student> findAllS(){
		return service.findAllStudents();
	}
	
	@DeleteMapping("/studentt/{id}")
	public String deleteSById(@PathVariable int id){
		service.deleteStudentById(id);
		return "Student with id " + id +  " deleted";
	}
	
	@DeleteMapping("/studentt")
	public String deleteS(@RequestBody Student student){
		service.deleteStudent(student);
		return "All students deleted";
	}
	
	@GetMapping("/studentts")
	public List<Student> getAll(){
		return service.getStudentsAll();
	}
	
	@PostMapping("/studentt/{id}/clg")
	public Student addClgToS(@PathVariable int id, @RequestBody College college) {
		service.addClgToStudentById(id, college);
		return service.findStudentById(id);
	}
}
