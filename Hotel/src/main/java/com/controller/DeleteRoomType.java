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
 * Servlet implementation class DeleteRoomType
 */
@WebServlet("/DeleteRoomType")
public class DeleteRoomType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoomType() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(RoomType.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		
		PrintWriter out = response.getWriter();
		
		try {
			
			transaction= session.beginTransaction();
			
			String hql="Delete From RoomType Where roomTypeId =:id";
			session.createQuery(hql)
			.setParameter("id", id)
			.executeUpdate();
			
			transaction.commit();
			out.print("<h1>Record Delete Successfully</h1>");
		}catch(Exception e) {
			out.print("<h1>Error</h1>");
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
