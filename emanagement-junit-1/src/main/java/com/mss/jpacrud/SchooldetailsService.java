package com.mss.jpacrud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SchooldetailsService {
	@Autowired
	Schooldetailsjpa schooljpa1;

	public SchoolDetails insertSchooldetails(SchoolDetails school) {
		return schooljpa1.save(school);
		
	}

	public SchoolDetails updateSchooldetails(SchoolDetails school) {
		return schooljpa1.save(school);
	}

	public void deteleSchooldetails(int id) {
		 schooljpa1.deleteById(id);
		
	}

	

	/*public List<SchoolDetails> getSchooldetails(int id) {
		
		return schooljpa1.findAllById(id);
	}*/
	
	public List<SchoolDetails> getSchooldetails() {

		return schooljpa1.findAll();
	}

}
