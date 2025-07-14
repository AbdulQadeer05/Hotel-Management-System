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

import com.model.RoomType;

/**
 * Servlet implementation class UpdateRoomType
 */
@WebServlet("/UpdateRoomType")
public class UpdateRoomType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoomType() {
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
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String Name=request.getParameter("Name");
		String description=request.getParameter("description");
		int maxOccupancy=Integer.parseInt(request.getParameter("maxOccupancy"));
	
			
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(RoomType.class).buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction=null;
		PrintWriter out = response.getWriter();
		
		
		try {
			transaction = session.beginTransaction();
			
			String hql="UPDATE RoomType SET typename = :Name, description = :description, maxOccupancy = :maxOccupancy WHERE roomTypeId = :id ";
			
			int result = session.createQuery(hql)
					.setParameter("id", id)
					.setParameter("Name", Name)
					.setParameter("description", description)
					.setParameter("maxOccupancy", maxOccupancy)
					.executeUpdate();
			
			transaction.commit();
			
			if(result>0) {
				out.print("<h1>Record Update Successfully</h1>");
			}
			else{
				out.print("<h1>Error</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
