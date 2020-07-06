package com.cloudxpert;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StreamsTestCase {

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
		//eList.clear();
	}

	@Test
	public void findAllEmployeesInMumbai() {
		List<Employee> mumbaiEmployees = eList.stream().filter(e -> e.getCity().equals("Mumbai")).collect(Collectors.toList());
		assertTrue(mumbaiEmployees.size() == 3);
	}

	@Test
	public void testIfAnyEmployeesInDelhi() {
		boolean employeesInDelhi = eList.parallelStream().anyMatch(e -> e.getCity().equals("Delhi"));
		assertTrue(employeesInDelhi == false);
	}
	
	@Test
	public void testIfAllEmployeesHaveSalaryGreaterThanZero() {
		boolean nonZeroSalary = eList.stream().allMatch(e -> e.getSalary() > 0);
		assertTrue (nonZeroSalary == true);
	}
	
	@Test 
	public void testRemoveDuplicates() {
		List<Employee> uniqueEmployees = eList.stream().distinct().collect(Collectors.toList());
		assertTrue(uniqueEmployees.size() == 5);
	}
	
	@Test
	public void testFindEmployeesInMumbaiWithSalaryGreateThan100() {
		List<Employee> mumbaiEmployees = eList.stream().filter(e -> e.getCity().equals("Mumbai") && e.getSalary() > 100).collect(Collectors.toList());
		assertEquals(3, mumbaiEmployees.size());
		//assertTrue(2,mumbaiEmployees.size());
		
	}
	
	@Test
	public void testIncrementAllSalaryBy100() {
		eList.stream().forEach(e -> e.setSalary(e.getSalary()+100));
	}
	
	@Test
	public void testGetFirstNamesOfAllEmployees() {
		List<String> firstNames = eList.stream().map( e -> e.getFirstName()).collect(Collectors.toList());
		assertTrue( firstNames.contains("Phani"));
		
	}
	
	@Test
	public void testTotalSalary() {
		
	}
}
