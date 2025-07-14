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

import com.model.Hotel;

/**
 * Servlet implementation class UpdateHotel
 */
@WebServlet("/Updatehotel")
public class UpdateHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHotel() {
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
	
		int id=Integer.parseInt(request.getParameter("no"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String email=request.getParameter("email");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Hotel.class).buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction transaction=null;
		PrintWriter out= response.getWriter();
		
		try {
			transaction = session.beginTransaction();
			String hql = "UPDATE Hotel SET hotelName = :name, phoneNo = :phone, fullAddress = :address, "
				    + "city = :city, state = :state, country = :country, email = :email WHERE hotelId = :id";

			int result=session.createQuery(hql)
					.setParameter("id", id)
					.setParameter("name", name)
					.setParameter("phone", phone)
					.setParameter("address", address)
					.setParameter("city", city)
					.setParameter("state", state)
					.setParameter("country", country)
					.setParameter("email", email)
					.executeUpdate();
			
			transaction.commit();
			
			
			if(result>0) {
				out.print("<h1>Record Update Successfully</h1>");
			}else {
				out.print("<h1>Not maching record Found</h1>");
			}
		
		}catch(Exception e) {
			
			out.print("<h1>Error<h1/>");
			e.printStackTrace();
		}
				
				
	
	}

}
