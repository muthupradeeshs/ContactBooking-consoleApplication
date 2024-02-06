package com.muthupradeesh.contactbooking.searchcontact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.muthupradeesh.contactbooking.repository.DatabaseConnection;

public class SearchContactViewModel {
	private SearchContactView searchContactView;

	public SearchContactViewModel(SearchContactView searchContactView) {
		this.searchContactView = searchContactView;
	}

	public void searchContact(String name) {
		try {
			DatabaseConnection.getInstance().connection = DatabaseConnection.getInstance().getConnection();
			String sql = "SELECT name,contactNumber,mailId  FROM contacttable";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (true) {
				if (resultSet.next()) {
					if (resultSet.getString("name").startsWith(name)) {
						System.out.println("-------------------------------------");
						System.out.println("Contact Name :" + resultSet.getString("name"));
						System.out.println("Contact Number :" + resultSet.getString("contactNumber"));
						System.out.println("Mail Id :" + resultSet.getString("mailId"));
						System.out.println("======================================");
					}
				} else {
					break;
				}
			}
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
