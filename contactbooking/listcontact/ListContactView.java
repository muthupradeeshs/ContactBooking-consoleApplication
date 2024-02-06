package com.muthupradeesh.contactbooking.listcontact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.muthupradeesh.contactbooking.dto.Contact;
import com.muthupradeesh.contactbooking.repository.DatabaseConnection;



public class ListContactView {
	private ListContactViewModel listContactViewModel;
	public ListContactView() {
		listContactViewModel=new ListContactViewModel(this);
	}
	public void listContacts() {
		try {
			listContactViewModel.listContact();
			for(int index=0;index<DatabaseConnection.getInstance().getArrayList().size();index++) {
				Contact object=DatabaseConnection.getInstance().getArrayList().get(index);
				System.out.println("Contact Name :" + object.getName());
				System.out.println("Contact Number:" + object.getContactNumber());
				System.out.println("Mail Id :" + object.getMailId());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
