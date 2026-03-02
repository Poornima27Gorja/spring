package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.College;
import com.example.demo.entity.Student;
import com.example.demo.repository.CollegeRepository;

@Repository
public class CollegeService {

	@Autowired
	private CollegeRepository repository;
	
	public College saveCollege(College college) {
		return repository.save(college);
	}
	
	public List<College> saveAllColleges(List<College> colleges){
		return repository.saveAll(colleges);
	}
	
	public College findCollegeById(int clg_id) {
		return repository.findById(clg_id).orElse(null);
	}
	
	public List<College> findAllColleges(){
		return repository.findAll();
	}
	
	public void deleteCollegeById(int clg_id) {
		repository.deleteById(clg_id);
	}
	
	public void deleteCollege(College college) {
		repository.delete(college);
	}
	
	public void addStudentsToClgById(int clg_id, List<Student> students) {
		College clg = repository.findById(clg_id).orElse(null);
		clg.getStudents().addAll(students);
	}
	
	public void addStudentToClgById(int clg_id, Student student) {
		College clg = repository.findById(clg_id).orElse(null);
		clg.getStudents().add(student);
	}
}
