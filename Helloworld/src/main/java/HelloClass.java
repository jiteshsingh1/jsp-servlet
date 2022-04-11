

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloClass")
public class HelloClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String url = "jdbc:mysql://localhost:3306/register";
		String Uname = "root";
		String Password ="User@684";
		String query ="insert into Student_details values(?,?)";
		
	
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("Name");
		String job = request.getParameter("Job");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,Uname,Password);

			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setString(2, job);
			int i = pstmt.executeUpdate();
			if(i>0) {
				out.print("you are successfully registered");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}

}
