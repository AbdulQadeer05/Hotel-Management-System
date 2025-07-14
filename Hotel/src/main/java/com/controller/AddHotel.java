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

import com.model.Hotel;

/**
 * Servlet implementation class AddHotel
 */
@WebServlet("/Addhotel")
public class AddHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHotel() {
        super();
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
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address =  request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String email = request.getParameter("email");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String description = request.getParameter("description");
		
		
		Hotel hotel = new Hotel (name,phone,address,city,state,country,email,rating,description);
		
		Transaction transaction=null;
		
		try (Session session = hibernate.getSessionFactory().openSession() ) {
			transaction = session.beginTransaction();
			
			session.persist(hotel);
			transaction.commit();
			
			PrintWriter out = response.getWriter();
			out.print("<h1>Record Added Successfully</h1>");
			
			
		}catch(Exception e) {
			PrintWriter out = response.getWriter();
			out.print("<h1>Record Added Failed</h1>");
			
			
			e.printStackTrace();
		}
		
	}

}
