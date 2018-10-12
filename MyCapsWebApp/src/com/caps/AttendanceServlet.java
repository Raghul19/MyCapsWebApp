package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;

@WebServlet("/Attendance")
public class AttendanceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid1 = req.getParameter("sid");
		String first = req.getParameter("firstname");
		String last = req.getParameter("lastname");
		String gender = req.getParameter("gender");
		String password = req.getParameter("passsword");
		String type = req.getParameter("type");
		
		PrintWriter out = resp.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");
			
			/*
			 * 2. Get the DB Connection via Driver
			 */
						String dbUrl="jdbc:mysql://localhost:3306/capsv4_db"
								+ "?user=root&password=1100";
			con = DriverManager.getConnection(dbUrl); //1st version of getConnection

			System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "insert into students_info values(?,?,?,?,?,?);";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sid1));
			pstmt.setString(2, first);
			pstmt.setString(3, last);
			pstmt.setString(4, gender);
			pstmt.setString(5, password);
			pstmt.setString(6, type);
			int count = pstmt.executeUpdate();

			/*
			 * 4. Process the results
			 */
			
			if(count > 0) {
				System.out.println("Profile Created");
			}else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/*
			 * 5. Close all the JDBC Objects
			 */

			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
}
