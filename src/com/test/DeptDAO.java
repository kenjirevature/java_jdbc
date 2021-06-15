package com.test;
import java.util.*;

public interface DeptDAO {
	public void getAllDept();
	public void getDeptByLocation (String loc);
	public void updateDeptById (int id);
	public void deleteDeptById (int id);
	public void addDept (DEPT d);
}
