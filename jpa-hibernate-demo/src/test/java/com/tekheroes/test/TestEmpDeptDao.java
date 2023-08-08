package com.tekheroes.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tekheroes.dao.EmpDeptDao;
import com.tekheroes.entity.Department;
import com.tekheroes.entity.Employee;

public class TestEmpDeptDao {
	private static EmpDeptDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new EmpDeptDao();
	}
	
	@Test
	public void testAddDept() {
		Department dept = new Department(20, "Sales");
		assertTrue(dao.addDept(dept) != 0);
	}
	
	@Test
	public void testAddEmp() {
		Employee emp = new Employee("Eric", 1600);
		assertTrue(dao.addEmp(emp, 20) != 0);
	}
	
	@Test
	public void testFetchDept() {
		Department dept = dao.fetchDept(10);
		assertNotNull(dept);
		System.out.println(dept);
		List<Employee> emps = dept.getEmps();
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testFetchEmp() {
		Employee emp = dao.fetchEmp(1);
		assertNotNull(emp);
		System.out.println(emp);
	}
	
	@Test
	public void testRemoveDept() {
		dao.removeDept(20);
	}
}
