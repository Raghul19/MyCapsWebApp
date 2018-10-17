package StudentApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Driver;

@WebServlet("/viewstudents")
public class ViewStudents extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			String sql = "select * from students_info";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			/*
			 * 4. Process the results
			 */
			
			out.println("<html><body>");
			out.println("<table border='2px'>");
		
			HttpSession session = req.getSession(false);
			if(session != null) {
				
			
			
			out.println("<tr><th>sid</th><th>firstname</th><th>lastname</th><th>gender</th><th>password</th><th>type</th></tr>");
			while(rs.next()){
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");
				
				out.print("<tr>");
				out.print("<td>"+regno+"</td>");
				out.print("<td>"+firstname+"</td>");
				out.print("<td>"+lastname+"</td>");
				out.print("<td>"+gender+"</td>");
				out.print("<td>"+passwd+"</td>");
				out.print("<td>"+type+"</td>");
				out.print("</tr>");
			}
			}else {
				out.println("please login...");
				out.println("<a href='http://localhost:8080/MyCapsWebApp/LogStudents.html'>login page</a>");
			}
			out.println("</table>");
			out.println("<a href='http://localhost:8080/MyCapsWebApp/logout'>Logout</a>");
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
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
	}
}
}
