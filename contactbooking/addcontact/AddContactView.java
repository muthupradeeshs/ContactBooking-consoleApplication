package com.muthupradeesh.contactbooking.addcontact;

import java.util.Scanner;


public class AddContactView {
	
	AddContactViewModel addContactViewModel;
	private Scanner scanner = new Scanner(System.in);

	public AddContactView() {
		addContactViewModel = new AddContactViewModel(this);
	}
	
	public void addContact() {
		while (true) {
			String contactNumber,name,mailId;
			boolean flag;
			do {
				System.out.println("Enter Contact Number(10 Digit Number)");
				contactNumber = scanner.nextLine();
				flag = addContactViewModel.contactNumberValidation(contactNumber);
				if(flag == false) {
					System.err.println("***Invalid Contact Number***");
				}
			} while(flag != true);

			do {
				System.out.println("Enter Name");
				name = scanner.nextLine();
				flag = addContactViewModel.nameValidation(name);
				if(flag == false) {
					System.err.println("***Invalid String***");
				}
			} while(flag != true);
			
			do {
				System.out.println("Enter Email");
				mailId = scanner.nextLine();
				flag = addContactViewModel.mailIdValidation(mailId);
				if(flag == false) {
					System.err.println("***Invalid Mail Id***");
				}
			} while(flag != true);
			addContactViewModel.addContact(contactNumber,name,mailId);
			break;
		}
	}
}
