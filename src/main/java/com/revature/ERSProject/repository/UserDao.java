package com.revature.ERSProject.repository;

import java.util.ArrayList;
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
	
	@SuppressWarnings("unchecked")
	public ErsUser getEmployeeByUsername(String uName) {
		ErsUser found = null;
		List<ErsUser> user = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		user = session.createQuery(
				"from ErsUser where username = :nameVar")
				.setString("nameVar", uName).list();
		if (!user.isEmpty()) {
			found = user.get(0);
		}
		return found;
	}
}
