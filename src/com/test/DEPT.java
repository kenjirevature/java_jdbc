package com.test;

public class DEPT {
	private int deptno;
	private String dname;
	private String loc;
	public DEPT(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public String getDname() {
		return dname;				
	}
	public String getLoc() {
		return loc;
	}
	public boolean setDeptno(int n) {
		try {
			deptno = n;
			return true;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean setDname(String n) {
		try {
			dname = n;
			return true;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean setLoc(String l) {
		try {
			loc = l;
			return true;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
