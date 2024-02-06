package com.muthupradeesh.contactbooking.editcontact;

import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import com.muthupradeesh.contactbooking.dto.Contact;
import com.muthupradeesh.contactbooking.repository.DatabaseConnection;



public class EditContactViewModel {
	private EditContactView editContactView;
	public EditContactViewModel(EditContactView editContactView) {
		this.editContactView=editContactView;
	}
	
	public void editContact(String name, String contactNumber, String mailId) {
		DatabaseConnection.getInstance().setArrayList(new Contact(contactNumber,name,mailId));
		try {
			DatabaseConnection.connection = DatabaseConnection.getConnection();
			String sql = "Update contacttable set contactNumber=?,name=?,mailId=? where name='" + name + "' ";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			statement.setString(1, contactNumber);
			statement.setString(2, name);
			statement.setString(3, mailId);
			statement.executeUpdate();
		} catch (Exception e1) {
			System.out.println("Entered Name is Not Found");
			System.out.println(e1);
		}
	}
	
	public boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if (!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}

	public boolean contactNumberValidation(String contactNumber) {
		Pattern contactPattern = Pattern.compile("^\\d{10}$");
		if (!contactPattern.matcher(contactNumber).matches()) {
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
