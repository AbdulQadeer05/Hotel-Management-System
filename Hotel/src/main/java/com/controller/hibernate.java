package com.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate {

	public static SessionFactory sessionFactory;
	
	
		static {
			System.out.print("Loading hibernate Configuration");
		
			try {
				
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				System.out.print("Hibernate SessionFactoy Created");
				
			}catch(Exception e) {
				System.out.print("hibernate SessionFactory Field");
				e.printStackTrace();
			}
		
		
		}
		
		public static SessionFactory getSessionFactory(){
			return sessionFactory;
		}
}
