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

import com.model.RoomType;

/**
 * Servlet implementation class AddRoomTypeServlet
 */
@WebServlet("/AddRoomTypeServlet")
public class AddRoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomTypeServlet() {
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
		String typeName=request.getParameter("typeName");
		String description=request.getParameter("description");
		int maxOccupancy=Integer.parseInt(request.getParameter("maxOccupancy"));
		int night = Integer.parseInt(request.getParameter("night"));
		
		RoomType roomtype=new RoomType(typeName,description,maxOccupancy,night);
		
		
		Transaction transaction=null;
		PrintWriter out = response.getWriter();
		
		try (Session session = hibernate.getSessionFactory().openSession() ) {
			transaction =session.beginTransaction();
			
			session.persist(roomtype);
			transaction.commit();
			
			out.print("<h1>Record Added Successfully</h1>");
			
		}catch(Exception e) {
			out.print("<h1>Error </h1>");
			e.printStackTrace();
		}
		
	}

}
