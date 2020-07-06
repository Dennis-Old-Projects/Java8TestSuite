package com.cloudxpert;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StreamsTestCase {

	private List<Employee> eList= null;
	
	@Before
	public void setUp() throws Exception {
		Employee e1 = new Employee("Phani","Rayadu",1,100.0,"Mumbai");
		Employee e2 = new Employee("Bill","Budd",2,100.0,"Mumbai");
		Employee e3 = new Employee("Vamsi","Rao",3,100.0,"Surat");
		Employee e4 = new Employee("Sowba","Madhavan",4,100.0,"Surat");
		eList = new ArrayList<Employee>(Arrays.asList(e1,e2,e3,e4));
	}

	@After
	public void tearDown() throws Exception {
		eList.clear();
	}

	@Test
	public void test() {
		List<Employee> mumbaiEmployees = eList.stream().filter(e -> e.getCity().equals("Mumbai")).collect(Collectors.toList());
		assertTrue(mumbaiEmployees.size() == 2);
	}

}
