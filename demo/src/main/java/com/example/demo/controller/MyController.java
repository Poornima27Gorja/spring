package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

@RestController
public class MyController {
	
	@GetMapping("/hi")
	public String takeReq() {
		return "Byee";
	}
	
	//MT - GET
	//URL - http://localhost:8080/college?id=19&name=udaya
	@GetMapping("/takeData")
	public String takeData(@RequestParam int id, @RequestParam String name) {
		return "ID = " + id + "   Name = " + name;
	}
	
	//URL - http://localhost:8080/college?id=19&name=udaya&loc=hyd
	@GetMapping("/college")
	public String college(@RequestParam int id, 
			@RequestParam String name, @RequestParam String loc) {
		return "ID = " + id + "   Name = " + name + "   Loc = " + loc;
	}
	
	//URL - http://localhost:8080/takeData2/12
	@GetMapping("/takeData2/{id}")
	public String takeData2(@PathVariable int id) {
		return "ID = " + id;
	}
	
	//URL - http://localhost:8080/takeData3/12/veda
	@GetMapping("/takeData3/{id}/{name}")
	public String takeData3(@PathVariable int id, @PathVariable String name) {
		return "ID = " + id + "   NAME = " + name;
	}
	
	//URL - http://localhost:8080/student/12/college/34
	@GetMapping("/student/{sid}/college/{cid}")
	public String studentCollege(@PathVariable int sid, @PathVariable int cid) {
		return "SID = " + sid + "   CID = " + cid;
	}
	
	//URL - http://localhost:8080/takeData4
	//Header -> 
	//id - 10  name - "abc"
	@GetMapping("/takeData4")
	public String takeData4(@RequestHeader int id, @RequestHeader String name) {
		return "ID : " + id + "   NAME : " + name;
	}
	
	//URL - http://localhost:8080/takeData4
	//Body -> Raw -> JSON 
	//{"id":23,    "name":"abc",   "phone":98765432}
	@GetMapping("/student")
	public String getStudent(@RequestBody Student s) {
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getPhone());
		return s.getName() + " is received";
	}
	
	@GetMapping("/student2")
	public Student getStudent2(@RequestBody Student s) {
		return s;
	}
}