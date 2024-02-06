package com.muthupradeesh.contactbooking;

import java.util.Scanner;

import com.muthupradeesh.contactbooking.addcontact.AddContactView;
import com.muthupradeesh.contactbooking.deletecontact.DeleteContactView;
import com.muthupradeesh.contactbooking.editcontact.EditContactView;
import com.muthupradeesh.contactbooking.listcontact.ListContactView;
import com.muthupradeesh.contactbooking.searchcontact.SearchContactView;

public class ContactBooking {
	public static void main(String[] args) {
		ContactBooking contactBooking = new ContactBooking();
		contactBooking.displayInfo();
	}

	private void menu() {
		System.out.println("------------Contact Application------------");
		System.out.println("Press 1 to Add a New Contact");
		System.out.println("Press 2 to List all Contacts");
		System.out.println("Press 3 to Edit a Contact");
		System.out.println("Press 4 to Delete a Contact");
		System.out.println("Press 5 to Search a Contact");
		System.out.println("Press 6 to Exit");
	}

	public void displayInfo() {
		Scanner scanner = new Scanner(System.in);
		int input;
		try {
			do {
				menu();
				System.out.println("Please Select One Option : ");
				input = scanner.nextInt();
				switch (input) {
				case 1:
					AddContactView addContactView=new AddContactView();
					addContactView.addContact();
					break;
				case 2:
					ListContactView listContactView=new ListContactView();
					listContactView.listContacts();
					break;
				case 3:
					EditContactView editContactView=new EditContactView();
					editContactView.editContact();
					break;
				case 4:
					DeleteContactView deleteContactView=new DeleteContactView();
					deleteContactView.deleteContact();
					break;
				case 5:
					SearchContactView searchContactView=new SearchContactView();
					searchContactView.searchContact();
					break;
				case 6:
					System.out.println("Exitted Successfully...");
					break;
				default:
					System.err.println("***Please Enter Valid Number***");
				}
			} while (input != 6);
		} catch (Exception e) {
			System.err.println("***Please Enter Valid Number***");
			displayInfo();
		}
	}
}
