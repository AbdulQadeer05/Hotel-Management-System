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
import org.hibernate.query.Query;

import com.model.Guest;
import com.model.Room;
import com.model.RoomBooking;

/**
 * Servlet implementation class RoomBookingServlet
 */
@WebServlet("/RoomBookingServlet")
public class RoomBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomBookingServlet() {
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

            List<Guest> guests = session.createQuery("from Guest", Guest.class).list();
            request.setAttribute("guestlist", guests);

           
            List<Room> rooms = session.createQuery("from Room", Room.class).list();
            request.setAttribute("rooms", rooms);

            
            request.getRequestDispatcher("RoomBooking.jsp").forward(request, response);

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
		
		int guestId= Integer.parseInt(request.getParameter("guestId"));
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		LocalDate issueDate = LocalDate.parse(request.getParameter("issueDate"));
		LocalDate returnDate = LocalDate.parse(request.getParameter("returnDate"));
		int gn = Integer.parseInt(request.getParameter("gn"));
		String sr = request.getParameter("sr");
		
		
		Transaction transaction = null;
		PrintWriter out = response.getWriter();
		
		try(Session session = hibernate.getSessionFactory().openSession() ){
			transaction = session.beginTransaction();
			
			String hql = "FROM RoomBooking r WHERE r.room.roomId = :roomId AND " +
		             "((:issueDate BETWEEN r.issue_date AND r.return_date) OR " +
		             "(:returnDate BETWEEN r.issue_date AND r.return_date) OR " +
		             "(r.issue_date BETWEEN :issueDate AND :returnDate))";

		Query<RoomBooking>query = session.createQuery(hql,RoomBooking.class);
		query.setParameter("roomId", roomId);
		query.setParameter("issueDate", issueDate);
		query.setParameter("returnDate", returnDate);
		
		List<RoomBooking> ex=query.getResultList();
		
			if(!ex.isEmpty()) {
				out.print("<h2>Room is already booked for selected dates</h2>");
				return;
			}
			Guest guest = session.get(Guest.class,guestId);
			Room room = session.get(Room.class,roomId);
			
			RoomBooking rb=new RoomBooking(guest, room, issueDate, returnDate, gn, sr );
			
			session.persist(rb);
			transaction.commit();
			out.print("<h1>Room Booked Successfully</h1>");
			
			
		}catch(Exception e) {
			out.print("<h1>Error</h1>");
			e.printStackTrace();
		}

	}

}
