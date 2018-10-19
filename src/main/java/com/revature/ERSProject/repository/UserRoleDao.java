package com.revature.ERSProject.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.ERSProject.model.ErsUser;
import com.revature.ERSProject.model.UserRole;
import com.revature.ERSProject.util.HibernateUtil;

public class UserRoleDao {

	
	@SuppressWarnings("unchecked")
	public boolean isManager(int userRoleId) {
		boolean manager = false;
		UserRole found = null;
		List<UserRole> user = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		user = session.createQuery(
				"from UserRole where id = :idVar")
				.setInteger("idVar", userRoleId).list();
		if (!user.isEmpty()) {
			found = user.get(0);
			String role = found.getRole();
			if(role.equalsIgnoreCase("manager"))
				manager = true;
		}
		
		return manager;
	}
}
