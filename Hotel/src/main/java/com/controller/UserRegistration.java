package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserRegistration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phoneno"));
		String password = request.getParameter("password");
		
		User user=new User(fName,lName,email,phone,password);
		
		Transaction transaction = null;
		
		try(Session session = hibernate.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(user);
			transaction.commit();
			
			PrintWriter out = response.getWriter();
            out.print("<h1>Record added successfully</h1>");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		
			PrintWriter out = response.getWriter();
            out.print("<h1>Record added Failed</h1>");
			
		}
		
		
	}

}
