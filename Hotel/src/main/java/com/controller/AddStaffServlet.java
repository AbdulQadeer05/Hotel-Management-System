package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Hotel;
import com.model.Staff;

/**
 * Servlet implementation class AddStaffServlet
 */
@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Session session = hibernate.getSessionFactory().openSession();
		List<Hotel> h =session.createQuery("from Hotel", Hotel.class).list();
		session.close();
		
		request.setAttribute("hotels", h);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddStaff.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Session session = hibernate.getSessionFactory().openSession();
		Transaction tx=null ;
			PrintWriter out = response.getWriter();
		
		try {
			tx = session.beginTransaction();
			
			int hotelId = Integer.parseInt(request.getParameter("hotelId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String cnic = request.getParameter("cnic");
			String phone = request.getParameter("phone");
			String position = request.getParameter("position");
			LocalDate hireDate = LocalDate.parse(request.getParameter("hireDate"));
			String salary = request.getParameter("salary");
			String shift = request.getParameter("shift");
			
			Hotel hotel = session.get(Hotel.class,hotelId);
			
			Staff staff = new Staff(hotel, firstName, lastName, cnic, phone, position, hireDate, salary, shift);
		
			session.persist(staff);
			tx.commit();
			out.print("<h1>Record Added Successfully</h1>");
			
		}catch(Exception e) {
			out.print("Error");
			e.printStackTrace();
		}
			
	
	}

}
