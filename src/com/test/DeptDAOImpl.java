package com.test;
import java.sql.*;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DeptDAOImpl implements DeptDAO{
	
	@Override
	public void getAllDept() {
		// TODO Auto-generated method stub
		String QUERY = "select * from dept_jdbc_k";
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY))
		    {	
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
				while(rs.next()){
				int no = rs.getInt("deptno");
				String name = rs.getString("dbname");
				String location = rs.getString("loc");
//				System.out.println("Connection");
				System.out.println(no + "," +name+ "," +location );
				}//try
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		} catch (SQLException e) {e.printStackTrace(); }
	}

	@Override
	public void getDeptByLocation(String loc) {
		// TODO Auto-generated method stub
		String QUERY = "select * from dept_jdbc_k where loc = "+"\'"+ loc + "\' ";
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY))
		    {	
				while(rs.next()){
				int no = rs.getInt("deptno");
				String name = rs.getString("dbname");
				String location = rs.getString("loc");
				System.out.println("Connection");
				System.out.println(no + "," +name+ "," +location );
			}//try
		} catch (SQLException e) {e.printStackTrace(); }
	}

	@Override
	public void updateDeptById(int row) {
		// TODO Auto-generated method stub
		String QUERY = "UPDATE dept_jdbc_k SET dbname='IT80' WHERE deptno=?";
		 try (Connection conn = ConnectionUtil.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {	preparedStatement.setInt(1, row);
	        row = preparedStatement.executeUpdate();
	         // rows affected
	         System.out.println(row);
	    	 
	     }catch( SQLException e)
	     {
	    	 System.out.print(e);
	    	 System.out.println(" Row cannot be updated");
	     }
	}

	@Override
	public void deleteDeptById(int row) {
		// TODO Auto-generated method stub
		String QUERY = "Delete from dept_jdbc_k where deptno = ?";
	     try (Connection conn = ConnectionUtil.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {		
	    	 preparedStatement.setInt(1, row);
	        row = preparedStatement.executeUpdate();
	         // rows affected
	         System.out.println(row);
	    	 
	     }catch( SQLException e)
	     {
	    	 System.out.println(" Row cannot be deleted");
	     }
	}

	@Override
	public void addDept(DEPT d) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection();
				 CallableStatement stmt=conn.prepareCall("{call create_JDBC_K(?,?,?)}"))
			     {	 stmt.setInt(1,d.getDeptno());  
					 stmt.setString(2,d.getDname());  
					 stmt.setString(3,d.getLoc());
					 stmt.execute();
			     } catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	
	
}
