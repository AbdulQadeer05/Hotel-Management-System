package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Guest;

/**
 * Servlet implementation class UpdateGuest
 */
@WebServlet("/UpdateGuest")
public class UpdateGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGuest() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phone");
		String address = request.getParameter("address");
		String nationality = request.getParameter("nationality");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Guest.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = null;
		PrintWriter out= response.getWriter();
		
		try {
			transaction = session.beginTransaction();
			
			String hql = "UPDATE Guest SET firstName = :firstName, lastName = :lastName, email = :email, phoneNo = :phoneNo, address = :address, nationality = :nationality WHERE guestId = :id";
			int result = session.createQuery(hql)
					.setParameter("id", id)
					.setParameter("firstName",firstName)
					.setParameter("lastName",lastName)
					.setParameter("email",email)
					.setParameter("phoneNo",phoneNo)
					.setParameter("address",address)
					.setParameter("nationality",nationality)
					.executeUpdate();
			
			transaction.commit();
			
			if(result>0) {
				out.print("Record Update Successfully");
			}else {
				out.print(" No Record Update Successfully");
			}
			
		}catch(Exception e) {
			out.print("Error");
			e.printStackTrace();
		}
		
		
	}

}
