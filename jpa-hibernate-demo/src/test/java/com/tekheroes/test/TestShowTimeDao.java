package com.tekheroes.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tekheroes.dao.ShowTimeDao;
import com.tekheroes.entity.Movie;
import com.tekheroes.entity.Multiplex;

public class TestShowTimeDao {
	private static ShowTimeDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new ShowTimeDao();
	}
	
	@Test
	public void testAddMovie() {
		Movie m = new Movie();
		m.setMovId(21);
		m.setTitle("Avatar");
		dao.addMovie(m);
	}
	
	@Test
	public void testAddMultiplex() { 
		Multiplex m = new Multiplex();
		m.setMpexId(2);
		m.setName("Inox");
		dao.addMultiplex(m);
	}
	
	@Test
	public void testAddMovieToMultiplex() {
		dao.addMovieToMultiplex(21, 2);
	}
	
	@Test
	public void testRemoveMovie() {
		dao.removeMovie(21);
	}
}
