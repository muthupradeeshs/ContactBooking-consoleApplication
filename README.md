# ContactBooking-consoleApplication

The Contact Management System is a Java application that allows users to manage their contacts efficiently. This system provides features such as adding new contacts, editing existing ones, deleting contacts, listing all contacts, and searching for contacts by name. The contact information is stored in a MySQL database.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [Application Configuration](#application-configuration)
- [Usage](#usage)
- [Contribution](#contribution)
- [License](#license)

## Features

1. **Add New Contacts:** Users can add new contacts with proper validation for contact number, name, and email.

2. **Edit Contacts:** Contacts' information, including contact number and email, can be edited.

3. **Delete Contacts:** Existing contacts can be deleted by specifying the contact name.

4. **List Contacts:** Display a list of all contacts stored in the database.

5. **Search Contacts:** Users can search for contacts by specifying the contact name.

## Prerequisites

Ensure you have the following installed on your machine:

1. Java Development Kit (JDK)
2. MySQL Database Server

## Database Setup

1. Create a MySQL database named `contact`.

    ```sql
    CREATE DATABASE IF NOT EXISTS contact;
    ```

2. Create a table named `contacttable` within the `contact` database to store contact information.

    ```sql
    USE contact;

    CREATE TABLE IF NOT EXISTS contacttable (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        contactNumber VARCHAR(10) NOT NULL,
        mailId VARCHAR(255) NOT NULL
    );
    ```

## Application Configuration

1. Open `DatabaseConnection.java` located in the `com.muthupradeesh.contactbooking.repository` package.
2. Update the connection details in the `getConnection()` method with your MySQL server details.

   ```java
   connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "your_username", "your_password");
