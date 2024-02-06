package com.muthupradeesh.contactbooking.repository;

import java.sql.Connection;
import java.util.ArrayList;

import com.muthupradeesh.contactbooking.dto.Contact;


public class DatabaseConnection {
	private static DatabaseConnection databaseConnection;
	public static Connection connection;
	private ArrayList<Contact> arrayList;

	public static Connection getConnection() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "123456");
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return connection;
	}

	private DatabaseConnection() {
		arrayList = new ArrayList<Contact>();
	}

	public static DatabaseConnection getInstance() {
		if (databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
		}
		return databaseConnection;
	}

	public ArrayList<Contact> getArrayList() {
		return arrayList;
	}

	public void setArrayList(Contact contact) {
		this.arrayList.add(contact);
	}

}
