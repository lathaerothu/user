package com.mss.jpacrud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface Schooldetailsjpa extends JpaRepository<SchoolDetails, Integer> {

	List<SchoolDetails> findAllById(int id);



	

}
