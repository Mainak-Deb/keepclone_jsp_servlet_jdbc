package com.autenticate;

import java.sql.*; 
import java.io.IOException;
import java.io.PrintWriter;

import com.autenticate.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String email=request.getParameter("email");
//		String psw=request.getParameter("psw");
//		
//		PrintWriter out = response.getWriter();
//		out.println(email+"\n"+psw);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String psw=request.getParameter("psw");
		System.out.println(email);
		PrintWriter out = response.getWriter();
		
		try {
			Connection con=DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("select * from userinfo where email=?",ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			st.setString(1, email);
			
			ResultSet rs=st.executeQuery();
			rs.first();
			
			
			//out.println("<html><body><b>Password matched "+psw+", "+rs.getString("password")+"  </b></body></html>");
			
			if(rs.getString("password").equals(psw)) {
				 out.println("<html><body><b>Password matched"+ "</b></body></html>");
				 HttpSession session=request.getSession();
				 session.setAttribute("uname",rs.getString("uname"));
				 response.sendRedirect("welcome.jsp");
			}else {
				 out.println("<html><body><b>Password incorrect"+ "</b></body></html>");
			}
			st.close();
            con.close();
		} catch (Exception e) {
			 e.printStackTrace();
            out.println("<html><body><b>Error occured"+ "</b></body></html>");
	}
		
	}

}
