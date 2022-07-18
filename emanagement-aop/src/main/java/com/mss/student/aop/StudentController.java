package com.mss.student.aop;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentdataService stu;
	

	@PostMapping("/studentdata")
	public Map<String, Object> insertStudentdata(@RequestBody Studentdata st) {
		return stu.insertStudentdata(st);

	}
	@PutMapping("/studentdata")
	public Map<String, Object> updateStudentdata(@RequestBody Studentdata st) {
		return stu.updateStudentdata(st);

	}
}
