package com.revature.ERSProject.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.revature.ERSProject.model.Reimbursements;
import com.revature.ERSProject.util.HibernateUtil;

public class ReimbursementsDao {

	@SuppressWarnings("unchecked")
	public List<Reimbursements> getPendingReimbursmentByUserId(int uId) {
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		reimbursements = session.createQuery(
				"from Reimbursements where idAuthor = :idVar")
				.setInteger("idVar", uId).list();
						
		Iterator<Reimbursements> i = reimbursements.iterator();
		
		while(i.hasNext()) {
			Reimbursements r = (Reimbursements)i.next();
			if(r.getDateRes()!=null)
				i.remove();	
		}
		
		return reimbursements;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reimbursements> getResolvedReimbursmentByUserId(int uId) {
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		reimbursements = session.createQuery(
				"from Reimbursements where idAuthor = :idVar")
				.setInteger("idVar", uId).list();
						
		Iterator<Reimbursements> i = reimbursements.iterator();
		
		while(i.hasNext()) {
			Reimbursements r = (Reimbursements)i.next();
			if(r.getDateRes()==null)
				i.remove();	
		}
		
		return reimbursements;
	}

}
