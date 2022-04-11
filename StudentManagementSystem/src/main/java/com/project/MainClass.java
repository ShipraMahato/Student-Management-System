package com.project;

import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		

		Scanner sc= new Scanner(System.in);
		while(true) {
		System.out.println("Database operations");
		System.out.println("Enter your choice ");
		System.out.println("1. To display student info");
		System.out.println("2. Insert Student record");
		System.out.println("3. Update Student info based on ID");
		System.out.println("4. Delete Student info based on ID");
		System.out.println("5. SelectStudent info based on Class");
		int ch = sc.nextInt();
		
		switch(ch) {
		case 1:  StudentData.displayStudentInfo();
		break;
		case 2:  StudentData.InsertStudentInfo();
		break;
		case 3:  StudentData.updateStudentInfo();
		break;
		case 4:  StudentData.deleteStudentInfo();
		break;
		case 5:  StudentData.selectStudentInfo();
		break;
		}
		System.out.println("Do you want to continue yes/no ");
		String choice = sc.next();
		if(choice.equals("yes")) {
			System.out.println("");
		}
		else
		{System.out.println("program is terminated ");
			break;
		}
	}
	System.out.println("program is terminated ");
sc.close();
	}

}
