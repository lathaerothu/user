package com.mss.jpacrud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SchooldetailsService {
	@Autowired
	Schooldetailsjpa soljpa;

	public String insertSchooldetails(Schooldetails solserv) {
		soljpa.save(solserv);
		return "insert sucessfully";
	}

	public String updateSchooldetails(Schooldetails solserv) {
		soljpa.save(solserv);
		return "updated sucessfully";
	}

	public String deteleSchooldetails(int id) {
		soljpa.deleteById(id);
		return "deleted sucessfully";
	}

	public List<Schooldetails> getSchooldetails(int id) {

		return soljpa.findAllById(id);
	}
	/*public List<Schooldetails> getSchooldetails() {

		return soljpa.findAll();
	}*/

}
