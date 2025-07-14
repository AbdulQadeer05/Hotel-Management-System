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

import com.model.Housekeeping;
import com.model.Room;
import com.model.Staff;


/**
 * Servlet implementation class AddHK
 */
@WebServlet("/AddHK")
public class AddHK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHK() {
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

            request.getRequestDispatcher("AddHK.jsp").forward(request, response);

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
		        
		        int roomId = Integer.parseInt(request.getParameter("roomId"));
		        int staffId = Integer.parseInt(request.getParameter("staffId"));
		        LocalDate date = LocalDate.parse(request.getParameter("date"));
		        String status = request.getParameter("status");
		        String note = request.getParameter("note");
		        
		        Room room = session.get(Room.class,roomId);
		        Staff staff = session.get(Staff.class, staffId);
		        
		        Housekeeping hk = new Housekeeping(room, staff,date, status, note );
		        session.save(hk);
		        tx.commit();
		        out.print("Record Added Successfully");
		        
		        
		    }catch(Exception e) {
		    	out.print("Error");
		    	e.printStackTrace();
		    }
	}
	

}
