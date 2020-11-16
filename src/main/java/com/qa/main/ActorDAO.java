package com.qa.main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorDAO {
	
	private static JDBCConnection DbInstance; 
	
	public ActorDAO() {
		DbInstance = JDBCConnection.connect("root","root");
	}
	
	// CRUD 
	// create
	public void create(Actor actor) {
		String firstname = actor.getFirst_name(); 
		String lastname = actor.getLast_name(); 
		String query = String.format("INSERT INTO actor(`first_name`, `last_name`) VALUES ('%s','%s');", firstname, lastname);
		try {
			DbInstance.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Read by id
	public ResultSet read(int id) {
		String query = "SELECT * FROM actor WHERE actor_id = " +id + ";";
		ResultSet rs = null; 
		try {
			rs = DbInstance.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Oh no couldn't read");
			e.printStackTrace();
		}
		return rs; 
	}
	
	// update by id 
	public void update(int id, Actor act) {
		String query = String.format("UPDATE actor set first_name = '%s', last_name = '%s' WHERE actor_id = '%d'", act.getFirst_name(), act.getLast_name(), id);
		try {
			DbInstance.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Couldn't update... ");
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String query = String.format("DELETE FROM actor WHERE actor_id = '%d'", id);
		try {
			DbInstance.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
