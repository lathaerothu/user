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
	SchooldetailsService solser;

	@PostMapping("/schooldetails")

	public String insertSchooldetails(@RequestBody Schooldetails solserv) {
		return solser.insertSchooldetails(solserv);
	}

	@PutMapping("/schooldetails")
	public String updateSchooldetails(@RequestBody Schooldetails solserv) {
		return solser.updateSchooldetails(solserv);
	}

	@DeleteMapping("/schooldetails/{id}")
	public String deleteSchooldetails(@PathVariable int id) {
		return solser.deteleSchooldetails(id);
	}

	@GetMapping("/schooldetails")
	public List<Schooldetails> getSchooldetails(@RequestParam int id) {
		return solser.getSchooldetails(id);
	}
	/*@GetMapping("/schooldetails")
	public List<Schooldetails> getSchooldetails() {
		return solser.getSchooldetails();
	}*/
}
