package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class TestJDBCOracleOnAWS {
	public static void main(String[] args) {
		int choice=0;
		DeptDAOImpl deptDAOImpl = new DeptDAOImpl();
		do {
			printBorder();
			System.out.println("Choose an Option");
			System.out.println("1. List departments");
			System.out.println("2. Add a department");
			System.out.println("3. Update a deprtment");
			System.out.println("4. Delete a deprtment");
			
			Scanner sc=new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
				case 1:
				{  
					deptDAOImpl.getAllDept();
					break;
				}
				case 2: 
				{
					print("No.: ");
					int deptno = getInt(sc);
					print("Name: ");
					String name = getString(sc);
					print("Location: ");
					
					String loc = getString(sc);
					
					deptDAOImpl.addDept(new DEPT(deptno,name,loc) );
					break;
				}
				case 3:
				{	
					print("No.: ");
					int deptno = getInt(sc);
					printBorder();
					deptDAOImpl.updateDeptById(deptno);;
					System.out.println("Row updated");
					break;
				}
				case 4: 
				{
					print("No.: ");
					int deptno = getInt(sc);
					printBorder();
					deptDAOImpl.deleteDeptById(deptno);
					 System.out.println("Row deleted : "+80);
					break;
				}
			}	
		}while(choice!=6);

	}
	public static String getString (Scanner sc) {
		return sc.next();
	}
	public static int getInt (Scanner sc) {
		return sc.nextInt();
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	public static void printBorder() {
		int wide = 80;
		for (int i=0; i<wide;i++) {
			print("*");
		}
		println("");
	}
	public static void printBorder(int w) {
		int wide = w;
		for (int i=0; i<wide;i++) {
			print("*");
		}
		println("");
	}

}

		

