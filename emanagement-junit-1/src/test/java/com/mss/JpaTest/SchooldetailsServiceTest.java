package com.mss.JpaTest;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mss.jpacrud.SchoolDetails;
import com.mss.jpacrud.SchooldetailsService;
import com.mss.jpacrud.Schooldetailsjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class SchooldetailsServiceTest {

	@Autowired
	SchooldetailsService schoolser;
	@MockBean
	Schooldetailsjpa schooljpa1;

	@Test
	public void insertData() {
		SchoolDetails school = new SchoolDetails(1,"latha");
		Mockito.when(schooljpa1.save(school)).thenReturn(school);
		assertEquals(school,schoolser.insertSchooldetails(school));
	}
	@Test
	public void getData() {
		Mockito.when(schooljpa1.findAll()).thenReturn(Stream.of(new SchoolDetails(2,"usha")).collect(Collectors.toList()));
		assertEquals(1, schoolser.getSchooldetails().size() );
	}
	@Test
	public void deleteData() {
		SchoolDetails school = new SchoolDetails(1,"latha");
		schoolser.deteleSchooldetails(school.getId());
		verify(schooljpa1,times(1)).deleteById(school.getId());
		
	}

}