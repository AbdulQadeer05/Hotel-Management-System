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

import com.model.Housekeeping;
import com.model.Room;

/**
 * Servlet implementation class DeleteHK
 */
@WebServlet("/DeleteHK")
public class DeleteHK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Housekeeping.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction=null;
		PrintWriter a = response.getWriter();
		
		try {
			transaction = session.beginTransaction();
			
			String hql = "DELETE From Housekeeping Where housekeepingId = :id";
			
			session.createQuery(hql)
			.setParameter("id", id)
			.executeUpdate();
			transaction.commit();
			a.print("Record Delete Successfully");
		}catch(Exception e) {
			a.print("Errror");
			e.printStackTrace();
		}
	}

}
