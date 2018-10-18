package com.revature.ERSProject.repository;

import java.util.List;

import org.hibernate.Session;

import com.revature.ERSProject.model.ErsUser;
import com.revature.ERSProject.util.HibernateUtil;

public class UserDao {

	@SuppressWarnings("unchecked")
	public List<ErsUser> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from ErsUser").list();
	}
}
