package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Payment;
import com.model.RoomBooking;

/**
 * Servlet implementation class AddPayment
 */
@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Session session = hibernate.getSessionFactory().openSession();
		
		List<RoomBooking> bookings = session.createQuery("from RoomBooking", RoomBooking.class).list();
		request.setAttribute("bookings", bookings);
		request.getRequestDispatcher("AddPayment.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Session session = hibernate.getSessionFactory().openSession();
	    Transaction tx = null;

	    PrintWriter out = response.getWriter();
	    try {
	        tx = session.beginTransaction();
	    

			int reservationId= Integer.parseInt(request.getParameter("reservationId"));
			LocalDate date = LocalDate.parse(request.getParameter("paymentDate"));
			String amount = request.getParameter("amount");
			String paymentMethod = request.getParameter("paymentMethod");
			String paymentStatus = request.getParameter("paymentStatus");
			
			RoomBooking roombooking = session.get(RoomBooking.class,reservationId);
			
			Payment payment = new Payment(roombooking, date, amount, paymentMethod, paymentStatus);
			
			session.persist(payment);
			tx.commit();
	        
	        out.print("Successfully");
	    }catch(Exception e) {
	    	out.print("Error");
	    	e.printStackTrace();
	    }
		
		
		
		
		
		
	}

}
