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

import com.model.Guest;

/**
 * Servlet implementation class AddGuest
 */
@WebServlet("/AddGuest")
public class AddGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGuest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String nationality = request.getParameter("nationality");
		
		Guest guest = new Guest(firstName,lastName,email,phone,address,nationality );
		
		Transaction transaction=null;
		PrintWriter out= response.getWriter();
		
		try(Session session = hibernate.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.persist(guest);
			transaction.commit();
			
			out.print("Record Added Successfully");
		}catch(Exception e){
			out.print("Error");
			e.printStackTrace();
		}
		
		
	
	}

}
