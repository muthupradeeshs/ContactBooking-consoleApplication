package com.muthupradeesh.contactbooking.editcontact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class EditContactView {
	EditContactViewModel editContactViewModel;
	private Scanner scanner = new Scanner(System.in);

	public EditContactView() {
		editContactViewModel = new EditContactViewModel(this);
	}
	public void editContact() {
		String name,contactNumber,mailId;
		boolean flag;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter Existing Name");
			name = scanner.nextLine();
			flag = editContactViewModel.nameValidation(name);
			if(flag == false) {
				System.err.println("***Invalid String***");
			}
		} while(flag != true);

		do {
			System.out.println("Enter Contact Number(10 Digit Number)");
			contactNumber = scanner.nextLine();
			flag = editContactViewModel.contactNumberValidation(contactNumber);
			if(flag == false) {
				System.err.println("***Invalid Contact Number***");
			}
		} while(flag != true);

		do {
			System.out.println("Enter Email");
			mailId = scanner.nextLine();
			flag = editContactViewModel.mailIdValidation(mailId);
			if(flag == false) {
				System.err.println("***Invalid Mail Id***");
			}
		} while(flag != true);
		editContactViewModel.editContact(name,contactNumber,mailId);
	}
	
}
