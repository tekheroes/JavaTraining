package com.tekheroes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tekheroes.entity.Department;
import com.tekheroes.entity.Employee;

public class EmpDeptDao {

	private EntityManagerFactory factory;
	
	public EmpDeptDao() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public int addDept(Department d) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(d);
		txn.commit();
		em.close();
		return d.getDeptNo();
	}
	
	public int addEmp(Employee e, int deptNo) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Department d = em.find(Department.class, deptNo);
		e.setDept(d);
		em.persist(e);
		txn.commit();
		em.close();
		return e.getEmpNo();
	}
	
	public Department fetchDept(int dno) {
		EntityManager em = factory.createEntityManager();
		Department d = em.find(Department.class, dno);
		return d;
	}
	
	public Employee fetchEmp(int eno) {
		EntityManager em = factory.createEntityManager();
		Employee e = em.find(Employee.class, eno);
		return e;
	}
	
	public void removeDept(int deptNo) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Department d = em.find(Department.class, deptNo);
		em.remove(d);
		txn.commit();
		em.close();
	}
}
