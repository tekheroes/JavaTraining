package com.tekheroes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tekheroes.bean.Person;
import com.tekheroes.util.JdbcFactory;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void save(Person p) {
		String sql = "INSERT INTO person VALUES (?,?,?)";
		try {
			Connection conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getAge());
			stmt.setString(3, p.getCity());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Person fetch(String name) {
		String sql = "SELECT * FROM person WHERE name='" + name + "'";
		try {
			Connection conn = JdbcFactory.getConnection();
			
			Person p = new Person();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if(rs.next()) {
				p.setName(rs.getString(1));
				p.setAge(rs.getInt(2));
				p.setCity(rs.getString(3));
				return p;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Person> list() {
		String sql = "SELECT * FROM person";
		List<Person> persons = new ArrayList<>();
		
		try {
			Connection conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Person p = new Person();
				p.setName(rs.getString(1));
				p.setAge(rs.getInt(2));
				p.setCity(rs.getString(3));
				persons.add(p);
			}
			return persons;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void remove(String name) {
		String sql = "DELETE FROM person WHERE name='" + name + "'";
		
		try {
			Connection conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
