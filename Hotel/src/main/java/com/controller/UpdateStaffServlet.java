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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Hotel;
import com.model.Staff;

/**
 * Servlet implementation class UpdateStaffServlet
 */
@WebServlet("/UpdateStaffServlet")
public class UpdateStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Session session = hibernate.getSessionFactory().openSession();
		Transaction transaction=null;
		
		try {
			transaction = session.beginTransaction();
			
			List<Hotel> h =session.createQuery("from Hotel", Hotel.class).list();
			request.setAttribute("hotels", h);
			
			request.getRequestDispatcher("UpdateStaff.jsp").forward(request, response);
	
			
		}catch(Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
			 response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}finally {
			session.close();
		}
		
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("no"));
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cnic = request.getParameter("cnic");
		String phone = request.getParameter("phone");
		String position = request.getParameter("position");
		LocalDate hireDate = LocalDate.parse(request.getParameter("hireDate"));
		String salary = request.getParameter("salary");
		String shift = request.getParameter("shift");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Staff.class)
				.addAnnotatedClass(Hotel.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tz=null;
		PrintWriter out = response.getWriter();
				
		Hotel hotel = session.get(Hotel.class,hotelId);
		
		try {
			
			tz = session.beginTransaction();
			
			String hql = "UPDATE Staff SET hotel = :hotel, firstName = :firstName, lastName = :lastName, " +
		             "cnic = :cnic, phone = :phone, position = :position, hireDate = :hireDate, " +
		             "salary = :salary, shift = :shift WHERE staffId = :no";

			int result = session.createQuery(hql)
					.setParameter("no",no)
					.setParameter("hotel", hotel)
					.setParameter("firstName", firstName)
					.setParameter("lastName", lastName)
					.setParameter("cnic", cnic)
					.setParameter("phone", phone)
					.setParameter("position", position)
					.setParameter("hireDate", hireDate)
					.setParameter("salary", salary)
					.setParameter("shift", shift)
					.executeUpdate();
			
			tz.commit();
			if(result>0) {
				out.print("Record Update Successfully");
			}else {
				out.print("No Maching Record Found");
			}
			
		}catch(Exception e) {
			out.print("Error");
			e.printStackTrace();
		}
		
		
	}

}
