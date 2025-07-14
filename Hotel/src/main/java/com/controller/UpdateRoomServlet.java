package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.model.Room;
import com.model.RoomType;

/**
 * Servlet implementation class UpdateRoomServlet
 */
@WebServlet("/UpdateRoomServlet")
public class UpdateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoomServlet() {
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

            request.getRequestDispatcher("UpdateRoom.jsp").forward(request, response);

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
		
		int id=Integer.parseInt(request.getParameter("id"));
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		int roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));
		
		String roomNo = request.getParameter("roomNo");
		String floor = request.getParameter("floor");
		int ratePerNight = Integer.parseInt(request.getParameter("ratePerNight"));
		String status = request.getParameter("status");
		String desc = request.getParameter("desc");
		
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(Hotel.class)
				.addAnnotatedClass(RoomType.class)
				.buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction transaction=null;
		PrintWriter out= response.getWriter();
		
		
		Hotel hotel = session.get(Hotel.class, hotelId);
        RoomType roomType= session.get(RoomType.class, roomTypeId);
        
        
		try {
			transaction = session.beginTransaction();
			
			String hql = "UPDATE Room SET hotelId = :hotel, roomTypeId = :roomType, roomNo = :roomNo, floor = :floor, ratePerNight = :ratePerNight, status = :status, description = :desc WHERE roomId = :id";
			
			int result=session.createQuery(hql)
					.setParameter("id", id)
					.setParameter("hotel", hotel)
					.setParameter("roomType", roomType)
					.setParameter("roomNo", roomNo)
					.setParameter("floor", floor)
					.setParameter("ratePerNight", ratePerNight)
					.setParameter("status", status)
					.setParameter("desc", desc)
					.executeUpdate();
			
			transaction.commit();
			if(result>0) {
				out.print("Record Update Successfully");
			}else {
				out.print("Not maching record Found");
			}
		}catch(Exception e) {
			out.print("Error");
			e.printStackTrace();
		}
		
		
	}

}
