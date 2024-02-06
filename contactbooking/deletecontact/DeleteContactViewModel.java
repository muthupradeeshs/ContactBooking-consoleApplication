package com.muthupradeesh.contactbooking.deletecontact;


import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import com.muthupradeesh.contactbooking.repository.DatabaseConnection;


public class DeleteContactViewModel {
	private DeleteContactView deleteContactView;
	public DeleteContactViewModel(DeleteContactView deleteContactView) {
		this.deleteContactView=deleteContactView;
	}
	
	public void deleteContact(String name) {
		try {
			DatabaseConnection.connection = DatabaseConnection.getConnection();
			String sql = "delete from contacttable where name = '"+name+"'";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println("Deleted Successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if(!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}

}
