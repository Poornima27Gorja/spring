package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.College;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

//	public StudentService() {
//
//	}
//
//	@Autowired
//	public StudentService(StudentRepository repository) {
//		this.repository = repository;
//	}
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public List<Student> saveAllStudents(List<Student> students){
		return repository.saveAll(students);
	}
	
	public Student findStudentById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Student> findAllStudents() {
		return repository.findAll();
	}
	
	public void deleteStudentById(int id) {
		repository.deleteById(id);;
	}
	
	public void deleteStudent(Student student) {
		repository.delete(student);
	}
	
	public List<Student> getStudentsAll() {
		return repository.getAllStudents();
	}
	
	public void addClgToStudentById(int id, College college) {
		Student student = repository.findById(id).orElse(null);
		student.setCollege(college);
	}
}
