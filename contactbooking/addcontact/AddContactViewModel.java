package com.muthupradeesh.contactbooking.addcontact;

import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import com.muthupradeesh.contactbooking.dto.Contact;
import com.muthupradeesh.contactbooking.repository.DatabaseConnection;

public class AddContactViewModel {
	private AddContactView contactView;

	public AddContactViewModel(AddContactView contactView) {
		this.contactView = contactView;
	}

	public void addContact(String contactNumber, String name, String mailId) {
		DatabaseConnection.getInstance().setArrayList(new Contact(contactNumber, name, mailId));
		try {
			DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
			String sql = "insert into contacttable(contactNumber,name,mailId)values(?,?,?)";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			statement.setString(1, contactNumber);
			statement.setString(2, name);
			statement.setString(3, mailId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean contactNumberValidation(String contactNumber) {
		Pattern pattern = Pattern.compile("^\\d{10}$");
		if (pattern.matcher(contactNumber).matches()) {
			return true;
		}
		return false;
	}

	public boolean nameValidation(String name) {
		 Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if (!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}

	public boolean mailIdValidation(String mailId) {
		Pattern mailIdPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		if (!mailIdPattern.matcher(mailId).matches()) {
			return false;
		}
		return true;
	}
}
