package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {
	@Id
	private int clg_id;
	private String clg_name;
	private String loc;
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	private List<Student> students;
	
	public College() {
		
	}

	public int getClg_id() {
		return clg_id;
	}

	public void setClg_id(int clg_id) {
		this.clg_id = clg_id;
	}

	public String getClg_name() {
		return clg_name;
	}

	public void setClg_name(String clg_name) {
		this.clg_name = clg_name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student s) {
		students.add(s);
		s.setCollege(this);
	}
	public void addStudents(List<Student> s) {
		students.addAll(s);
		for(Student st: s) {
			st.setCollege(this);
		}
	}
}