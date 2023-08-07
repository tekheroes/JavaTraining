package com.tekheroes.dao;

import java.util.List;

import com.tekheroes.bean.Person;

public interface PersonDao {

	void save(Person p);
	
	Person fetch(String name);
	
	List<Person> list();
}
