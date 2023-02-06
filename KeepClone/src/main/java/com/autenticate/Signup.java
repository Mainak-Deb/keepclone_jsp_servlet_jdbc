package com.autenticate;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import com.autenticate.DatabaseConnection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String psw=request.getParameter("psw");
		
//		PrintWriter out = response.getWriter();
//		out.println(name+"\n"+email+"\n"+psw);
		
		try {
			Connection con=DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("insert into userinfo values(?, ?,?)");
			
			 st.setString(1, name);
			 st.setString(2, email);
			 st.setString(3, psw);
			 
			 st.executeUpdate();
			  	           
            st.close();
            con.close();
        
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"+ "</b></body></html>");
            response.sendRedirect("login");
                        
	                   
		}
		 catch (Exception e) {
	            e.printStackTrace();
	            PrintWriter out = response.getWriter();
	            out.println("<html><body><b>fAILED"+ "</b></body></html>");
	    }
		
		
		
	}

}
