package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Servicess;

/**
 * Servlet implementation class UpdateService
 */
@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String des = request.getParameter("des");
		String price = request.getParameter("price");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Servicess.class).buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction transaction=null;
		PrintWriter out= response.getWriter();
		
		try {
			transaction = session.beginTransaction();
			String hql ="UPDATE Servicess SET name = :name, description = :des, price = :price WHERE serviceId = :id";
			
			int result = session.createQuery(hql)
					.setParameter("id",id)
					.setParameter("name", name)
					.setParameter("des", des)
					.setParameter("price", price)
					.executeUpdate();
			
			transaction.commit();
			
			if(result>0) {
				out.print("Record Update Successfully");
			}else {
				out.print("Not record Update");
			}
		}catch(Exception e) {
			out.print("Error");
			e.printStackTrace();
		}
		
	}

}
