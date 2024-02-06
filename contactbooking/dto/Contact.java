package com.muthupradeesh.contactbooking.dto;

public class Contact {
	private String name,contactNumber,mailId;

	public Contact(String name, String contactNumber, String mailId) {
		this.name = name;
		this.contactNumber = contactNumber;
		this.mailId = mailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

}
