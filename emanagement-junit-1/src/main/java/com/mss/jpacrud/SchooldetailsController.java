package com.mss.jpacrud;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SchooldetailsController {

	@Autowired
	SchooldetailsService schoolser;

	@PostMapping("/schooldetails")

	public SchoolDetails insertSchooldetails(@RequestBody SchoolDetails school) {
		return schoolser.insertSchooldetails(school);
	}

	@PutMapping("/schooldetails")
	public SchoolDetails updateSchooldetails(@RequestBody SchoolDetails school) {
		return schoolser.updateSchooldetails(school);
	}

	@DeleteMapping("/schooldetails/{id}")
	public void deleteSchooldetails(@PathVariable int id) {
	 schoolser.deteleSchooldetails(id);
	}

/*	@GetMapping("/schooldetails")
	public List<SchoolDetails> getSchooldetails(@RequestParam int id) {
		return schoolser.getSchooldetails(id);
	}
	/*@GetMapping("/schooldetails")
	public List<Schooldetails> getSchooldetails() {
		return schoolser.getSchooldetails();
	}*/
}
