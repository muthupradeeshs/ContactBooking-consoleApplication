package com.muthupradeesh.contactbooking.deletecontact;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DeleteContactView {
	public void deleteContact() {
		delete();
	}

	private DeleteContactViewModel deleteContactViewModel;

	public DeleteContactView() {
		deleteContactViewModel = new DeleteContactViewModel(this);
	}

	private void delete() {
		Scanner scanner = new Scanner(System.in);
		String name;
		boolean flag;
		do {
			System.out.println("Enter Existing Name");
			name = scanner.nextLine();
			flag = deleteContactViewModel.nameValidation(name);
			if (flag == false) {
				System.err.println("***Invalid String***");
			}
		} while (flag != true);
		deleteContactViewModel.deleteContact(name);
	}
}
