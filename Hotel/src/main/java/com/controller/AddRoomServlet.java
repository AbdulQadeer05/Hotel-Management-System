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

import com.model.Hotel;
import com.model.Room;
import com.model.RoomType;

/**
 * Servlet implementation class AddRoomServlet
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Session session = hibernate.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List<Hotel> hotels = session.createQuery("from Hotel", Hotel.class).list();
            request.setAttribute("hotelList", hotels);

           
            List<RoomType> types = session.createQuery("from RoomType", RoomType.class).list();
            request.setAttribute("roomTypes", types);

            request.getRequestDispatcher("AddRoom.jsp").forward(request, response);

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            session.close();
        }
	
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

	        
	        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
	        int roomTypeId =Integer.parseInt(request.getParameter("roomTypeId"));
	        String roomNo = request.getParameter("roomNo");
	        String floor = request.getParameter("floor");
	        int ratePerNight = Integer.parseInt(request.getParameter("ratePerNight"));
	        String des=request.getParameter("desc");
	        String status=request.getParameter("status");
	       

	       
	        Hotel hotel = session.get(Hotel.class, hotelId);
	        RoomType roomType= session.get(RoomType.class, roomTypeId);
	        
	        
	        Room room = new Room();
	        room.setHotelId(hotel);
	        room.setRoomTypeId(roomType);
	        room.setRoomNo(roomNo);
	        room.setFloor(floor);
	        room.setRatePerNight(ratePerNight);
	        room.setDescription(des);
	        room.setStatus(status);
	       
	        session.save(room);
	        tx.commit();

	       
	        out.print("Room Added Successfully");
	        
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	        
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    } finally {
	        session.close();
	    }
	}


}