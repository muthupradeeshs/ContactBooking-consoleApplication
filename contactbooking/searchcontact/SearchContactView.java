package com.muthupradeesh.contactbooking.searchcontact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SearchContactView {
	private SearchContactViewModel searchContactViewModel;
	public SearchContactView() {
		searchContactViewModel = new SearchContactViewModel(this);
	}

	public void searchContact() {
		Scanner scanner = new Scanner(System.in);
		boolean flag;
		String name="";
		try {
			do {
				System.out.println("Enter Name");
				name = scanner.nextLine();
				flag = nameValidation(name);
				if (flag == false) {
					System.err.println("***Invalid String***");
				}
			} while (flag != true);
		} catch (Exception e) {
			System.err.println("***Please Enter Valid Number***");
			searchContact();
		}
		searchContactViewModel.searchContact(name);
	}

	private boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if (!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}
}
