package com.revature.ERSProject.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.revature.ERSProject.model.*;

public class HibernateUtil {

	private static SessionFactory sf = sessionFactory("hibernate.cfg.xml");
	
	private static SessionFactory sessionFactory(String filename) {
			Configuration config = new Configuration().configure(filename);
			config.addAnnotatedClass(ErsUser.class);
			config.addAnnotatedClass(UserRole.class);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			return config.buildSessionFactory(sr);
	}
	
	public static Session getSession() {
		return sf.openSession();
	}
	
	public static void shutdown() {
		sf.close();
	}
}