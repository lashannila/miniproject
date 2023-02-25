package com.student.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentManagementSystem {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
		System.out.println("<>                                                                                  <>");
		System.out.println("<><><><><><><><><><><><>     STUDENT MANAGEMENT SYSTEM    <><><><><><><><><><><><><><>");
		System.out.println("<>                                                                                  <>");
		System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
		System.out.println();

		System.out.println("Enter 1 to Login.");
		System.out.println();
		System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
		System.out.println();
		System.out.print("\t\t Enter your choice:");
		int choice = Integer.parseInt(br.readLine());
		System.out.println();
		if (choice == 1) {
			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
			System.out.println("<>                                                                                  <>");
			System.out.println("<>                                  LOGIN DETAILS                                   <>");
			System.out.println("<>                                                                                  <>");
			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
			System.out.println();
			//First enter the login details to the database and then enter here.
			System.out.print("\t\t Enter your username:");
			String userID = br.readLine();
			System.out.print("\t\t Enter your password:");
			String studentPassword = br.readLine();   
			System.out.println();
			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
			
			Connection conn = StudentSqlConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from login where userID=?");
			ps.setString(1, userID);
			ResultSet result = ps.executeQuery();
			String password = null;

			while (result.next()) {
				password = result.getString("studentPassword");
			}

			if (studentPassword.equals(password)) {
				System.out.println();
				System.out.println("You have successfully logged in!!");
				System.out.println();
				boolean login = true;
				do {

					System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
					System.out.println();
					System.out.println("               <> WELCOME " + userID.toUpperCase()+ " TO SHINE CENTER <>             ");
					System.out.println();
					System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
					System.out.println();
					System.out.println("1  --->   Enrollment");
					System.out.println("2  --->   Payment");
					System.out.println("3  --->   Exit / Logout");
					System.out.println();
					System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
					System.out.println();
					System.out.print("\t\t Enter your choice:");
					int operationNumber = Integer.parseInt(br.readLine());
					System.out.println();
					System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
					System.out.println();

					String status = null;
					switch (operationNumber) {
					case 1:
						System.out.println("Enter your ID:");
						int id = Integer.parseInt(br.readLine());

						System.out.println("Enter your name:");
						String name = br.readLine();

						System.out.println("Enter user name:");
						String uname = br.readLine();

						System.out.println("Enter your password:");
						String passwords = br.readLine();

						System.out.println("Enter gender:");
						String gender = br.readLine();

						System.out.println("Enter date of birth:(dd/MM/YYYY)");
						String dob = br.readLine();

						System.out.println("Enter phone number:");
						long phone = Long.parseLong(br.readLine());

						System.out.println("Enter email:");
						String email = br.readLine();

						System.out.println("Enter Qualification:");
						String qualification = br.readLine();

						System.out.println("Enter Domain:");
						String domain = br.readLine();

						System.out.println("Enter passed out year:");
						long passedYear = Long.parseLong(br.readLine());

						System.out.println("Course:");
						String course = br.readLine();

						ps = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)");
						ps.setInt(1, id);
						ps.setString(2, name);
						ps.setString(3, uname);
						ps.setString(4, password);
						ps.setString(5, gender);

						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
						java.util.Date utilDate = formatter.parse(dob);
						java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

						ps.setDate(6, sqlDate);
						ps.setDouble(7, phone);
						ps.setString(8, email);
						ps.setString(9, qualification);
						ps.setString(10, domain);
						ps.setLong(11, passedYear);
						ps.setString(12, course);
						System.out.println();

						if (ps.executeUpdate() > 0) {
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							System.out.println();
							System.out.println("Enrolled successfully!!");
							System.out.println();
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							

						} else {
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							System.out.println();
							System.out.println("Something went wrong!!");
							System.out.println();
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

						}
						System.out.println();
						System.out.println("Do you want to continue??(Y/N)");
						status = br.readLine();

						if (status.equals("n") || status.equals("N")) {
							login = false;
						}

						break;

					case 2:
						System.out.println();
						System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
						System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
						System.out.println("<> 2000/- for Java Full Stack Development <>");
						System.out.println("<> 2000/- for Java Full Web Development   <>");
						System.out.println("<> 1000/- for Java Script                 <>");
						System.out.println("<> 2000/- for Python                      <>");
						System.out.println("<> 1000/- for C Language                  <>");
						System.out.println("<> 1000/- for C++                         <>");
						System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
						System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
						System.out.println();
						//Enter the course name as it is in the menu don't change the upper case and lower case also..
						System.out.println("Enter the course Name:");
						String courses = br.readLine();
						String a = "Java Full Stack Development";
						String b = "Java Full Web Development";
						String c = "Java Script";
						String d = "Python";
						String e = "C Language";
						String f = "C++";
						System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
						System.out.println();
						if (courses.equals(a)) {
							System.out.println("!Please pay rupees 2000!");
							System.out.println();
							
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							
						} else if (courses.equals(b)) {
							System.out.println("!Please pay rupees 2000!");
							System.out.println();
							
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							
						} else if (courses.equals(c)) {
							System.out.println("!Please pay rupees 1000!");
							System.out.println();
							
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							
						} else if (courses.equals(d)) {
							System.out.println("!Please pay rupees 2000!");
							System.out.println();
							
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							
						} else if (courses.equals(e)) {
							System.out.println("!Please pay rupees 1000!");
							System.out.println();
							
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							
						} else if (courses.equals(f)) {
							System.out.println("!Please pay rupees 1000!");
							System.out.println();
							
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							
						}
						
						else {
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							System.out.println();
							
							System.out.println("Something went wrong!!");
							System.out.println();
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							
						}

						System.out.println("Enter your ID:");
						int id1 = Integer.parseInt(br.readLine());

						System.out.println("Enter your name:");
						String name1 = br.readLine();

						System.out.println("Enter the fee to be paid:");
						double fees = Double.parseDouble(br.readLine());


						ps = conn.prepareStatement("insert into payment values(?,?,?)");
						ps.setInt(1, id1);
						ps.setString(2, name1);
						ps.setDouble(3, fees);

						if (ps.executeUpdate() > 0 && fees==1000 || fees==2000) {
							System.out.println();
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							System.out.println();
							System.out.println("Payment successful!!");
							System.out.println();
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
						}
						else if (ps.executeUpdate() > 0 && fees!=1000 && fees!=2000) {
							System.out.println();
								System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
								System.out.println();
								System.out.println("Payment not successful!!");
								System.out.println();
								System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

						} else {
							System.out.println();
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							System.out.println();
							System.out.println("Something went wrong!!");
							System.out.println();
							System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
						
						}

						System.out.println("Do you want to continue??(Y/N)");
						status = br.readLine();
						if (status.equals("n") || status.equals("N")) {
							login = false;
						}

						break;

					case 3:
						login = false;
						break;

					default:
						System.out.println("Something went wrong");

					}

				} while (login);
				System.out.println();
				System.out.println("!!Thank You!!");
                System.out.println("!!Have a nice day!!");

			} else {
				System.out.println("Wrong username/password!!");
			}

		}

	}
}
