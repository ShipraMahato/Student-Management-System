package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class StudentData {
	static Connection sconn = null;
	static ResultSet rs=null;
	static Statement st=null;
	
	static Scanner sc=new Scanner(System.in);
	static int Id;
	static String Name;
	static int SClass;
	static String FName;
	static long MobileNo;
	static String Address;


	public static void displayStudentInfo() {

		try {
			sconn=DataBaseConnect.getConnection();
			st=sconn.createStatement();
			System.out.println("My connection"+sconn);
				
		String sql="select * from detail";
		rs=st.executeQuery(sql);
		while(rs.next()){
           
            System.out.print(" Id: " + rs.getInt(1));
            System.out.print(", Name: " + rs.getString(2));
            System.out.print(", Class: " + rs.getInt(3));
            System.out.print(", FName: " + rs.getString(4));
            System.out.print(", MobileNo: " + rs.getString(5));
            System.out.println(", Address: " + rs.getString(6));
         }
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	public static void InsertStudentInfo() {

		try {
			sconn=DataBaseConnect.getConnection();
			st=sconn.createStatement();
			System.out.println("My connection"+sconn);
			
			//Input data from user
			System.out.println("Enter id of student");
			Id=sc.nextInt();
			//Check id exists
			String sql="select * from detail where id="+Id;
			rs=st.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.println("Enter student name");
				Name=sc.next();
				System.out.println("Enter student Class ");
				SClass=sc.nextInt();
				System.out.println("Enter student Father's name");
				FName=sc.next();
				System.out.println("Enter student Mobile Number ");
				MobileNo=sc.nextLong();
				System.out.println("Enter Address of student");
				Address=sc.next();
				
		String ins="insert into detail values("+Id+",'"+Name+"',"+SClass+",'"+FName+"',"+MobileNo+",'"+Address+"')";
				int  i =st.executeUpdate(ins);
				if(i>0) {
					System.out.println("Student information is registered");
				}
			}else {
				System.out.println("Id already exists Choose another id");
			}
} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	

	public static void updateStudentInfo() {
		try {
			sconn=DataBaseConnect.getConnection();
			st=sconn.createStatement();
			System.out.println("My connection"+sconn);
			
			System.out.println("Enter name of student");
			Id=sc.nextInt();
		 
		  String sql = "select * from detail where id="+Id;
		rs=st.executeQuery(sql);
		  if(rs.next()) { 
			  System.out.println("Enter the name to be update :");
				String name = sc.next();
			  String update="update detail set name = '"+name+"' where id ="+Id ;
			  
			int  i=st.executeUpdate(update);
			if(i>0) {
				System.out.println("Record is updated");
			}
			}
			//if
		  else {
			  System.out.println("Record not exists");
		  }
		  
	}catch(Exception e) {
		e.printStackTrace();
	}

	}


	public static void deleteStudentInfo() {
		try {
			sconn=DataBaseConnect.getConnection();
			st=sconn.createStatement();
			System.out.println("My connection"+sconn);

			System.out.println("Enter id of student");
			Id=sc.nextInt();
			String sql="select * from detail where id="+Id; 
			//get only one row
			  //check id exists
			  rs=st.executeQuery(sql);
			  if(rs.next()) { //if true record exists
				  //delete operation when record exists
				  
				String del = "delete from detail where id="+Id;
				int  i=st.executeUpdate(del);
				
				if(i>0) {
					System.out.println("Record is deleted");
				}
				}//if
			  else {
				  System.out.println("Record not exists");
			  }
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectStudentInfo() {
		try {
			sconn=DataBaseConnect.getConnection();
			st=sconn.createStatement();
			System.out.println("Enter Class to display Information");
			SClass =sc.nextInt();
						
			String sql="select name from detail where class ="+SClass;
			rs=st.executeQuery(sql);
			while(rs.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			System.out.println(rs.getString("name"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
}


