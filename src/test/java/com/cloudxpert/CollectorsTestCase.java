package com.cloudxpert;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollectorsTestCase {

	private static List<Employee> eList= null;
	
	@BeforeClass
	public static void setUp() throws Exception {

		Employee e1 = new Employee("Phani","Rayadu",1,100.0,"Mumbai");
		Employee e2 = new Employee("Bill","Budd",2,200.0,"Mumbai");
		Employee e3 = new Employee("Vamsi","Rao",3,100.0,"Surat");
		Employee e4 = new Employee("Sowba","Madhavan",4,100.0,"Surat");
		Employee e5 = new Employee("John","Lennon",5,300.0,"Mumbai");
		eList = Arrays.asList(e1,e2,e3,e4,e4,e5);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGroupByCity() {
		Map<String, List<Employee>> groupedByCity = eList.stream().collect(Collectors.groupingBy(e -> e.getCity()));
		List<String> firstNames = groupedByCity.get("Mumbai").stream().map(e -> e.getFirstName()).collect(Collectors.toList());
		assertTrue(firstNames.contains("Phani"));
	}

}
