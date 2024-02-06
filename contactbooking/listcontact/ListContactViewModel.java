package com.muthupradeesh.contactbooking.listcontact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.muthupradeesh.contactbooking.dto.Contact;
import com.muthupradeesh.contactbooking.repository.DatabaseConnection;


public class ListContactViewModel {
	private ListContactView listContactView;
	public ListContactViewModel(ListContactView listContactView) {
		this.listContactView=listContactView;
	}

	public void listContact() {
		try {
			DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
			String query = "SELECT id,name,contactNumber,mailId FROM contacttable Order By name Asc";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();
			if (DatabaseConnection.getInstance().getArrayList().size() == 0) {
				while (resultset.next()) {
					DatabaseConnection.getInstance().setArrayList((new Contact(resultset.getString("name"),resultset.getString("contactNumber"),resultset.getString("mailId"))));
				}
			} else {
				DatabaseConnection.getInstance().getArrayList().removeAll(DatabaseConnection.getInstance().getArrayList());
				while (resultset.next()) {
					DatabaseConnection.getInstance().setArrayList(new Contact(resultset.getString("name"),resultset.getString("contactNumber"),resultset.getString("mailId")));
				}
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
	}
}
