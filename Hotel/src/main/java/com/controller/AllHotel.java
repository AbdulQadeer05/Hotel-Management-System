package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.model.Hotel;
import com.model.User;

/**
 * Servlet implementation class AllHotel
 */
@WebServlet("/AllHotel")
public class AllHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllHotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 Session session = hibernate.getSessionFactory().openSession();
	        List<Hotel> HotelsList = session.createQuery("from Hotel", Hotel.class).list();
	        session.close();

	        request.setAttribute("hotels", HotelsList);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("GetAllHotel.jsp");
	        dispatcher.forward(request, response);
	        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
