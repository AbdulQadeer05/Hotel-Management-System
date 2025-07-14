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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Room;
import com.model.Servicess;
import com.model.Staff;

/**
 * Servlet implementation class UpdateHK
 */
@WebServlet("/UpdateHK")
public class UpdateHK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHK() {
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

            List<Room> rooms = session.createQuery("from Room", Room.class).list();
            request.setAttribute("roomList", rooms);

           
            List<Staff> staffs = session.createQuery("from Staff", Staff.class).list();
            request.setAttribute("staff", staffs);

            request.getRequestDispatcher("UpdateHK.jsp").forward(request, response);

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
	
		int id = Integer.parseInt(request.getParameter("id"));
		int roomId = Integer.parseInt(request.getParameter("roomId"));
        int staffId = Integer.parseInt(request.getParameter("staffId"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String status = request.getParameter("status");
        String note = request.getParameter("note");
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Servicess.class).buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction transaction=null;
		PrintWriter out= response.getWriter();
		
		Room room = session.get(Room.class,roomId);
        Staff staff = session.get(Staff.class, staffId);
        
        try {
        	transaction =  session.beginTransaction();
        	
        	String hql = "UPDATE Housekeeping SET roomId = :room, staffId = :staff, dateCleaned = :date, status = :status, notes = :note WHERE housekeepingId = :id";
        	
        	int result = session.createQuery(hql)
        			.setParameter("id", id)
        			.setParameter("room", room)
        			.setParameter("staff", staff)
        			.setParameter("date", date)
        			.setParameter("status", status)
        			.setParameter("note", note)
        			.executeUpdate();
        	
        	transaction.commit();
        	
        	if(result>0) {
        		out.print("Record Update");	
        	}else {
        		out.print("Not Update Record");
        	}
        	
        	
        	
        }catch(Exception e) {
        	out.print("Error");
        	e.printStackTrace();
        }
        
	}

}
