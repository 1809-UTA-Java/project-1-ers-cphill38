package com.revature.ERSProject.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.revature.ERSProject.model.ErsUser;
import com.revature.ERSProject.model.ReimburseStatus;
import com.revature.ERSProject.model.ReimburseType;
import com.revature.ERSProject.model.Reimbursements;
import com.revature.ERSProject.util.HibernateUtil;

public class ReimbursementsDao {
	
	private static final DateFormat sdf = new SimpleDateFormat("dd-MMM-yy HH-mm-ss aaa");

	@SuppressWarnings("unchecked")
	public List<Reimbursements> getPendingReimbursments() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = HibernateUtil.getSession();

		reimbursements = session.createQuery("from Reimbursements").list();

		Iterator<Reimbursements> i = reimbursements.iterator();
		
		while (i.hasNext()) {
			Reimbursements r = (Reimbursements) i.next();
			if (r.getDateRes() != null)
				i.remove();
		}

		return reimbursements;
	}

	@SuppressWarnings("unchecked")
	public List<Reimbursements> getPendingReimbursmentByUserId(int uId) {
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = HibernateUtil.getSession();

		reimbursements = session.createQuery("from Reimbursements where idAuthor = :idVar").setInteger("idVar", uId)
				.list();

		Iterator<Reimbursements> i = reimbursements.iterator();

		while (i.hasNext()) {
			Reimbursements r = (Reimbursements) i.next();
			if (r.getDateRes() != null)
				i.remove();
		}

		return reimbursements;
	}

	@SuppressWarnings("unchecked")
	public List<Reimbursements> getResolvedReimbursments() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = HibernateUtil.getSession();

		reimbursements = session.createQuery("from Reimbursements").list();

		Iterator<Reimbursements> i = reimbursements.iterator();

		while (i.hasNext()) {
			Reimbursements r = (Reimbursements) i.next();
			if (r.getDateRes() == null)
				i.remove();
		}

		return reimbursements;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reimbursements> getResolvedReimbursmentByUserId(int uId) {
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = HibernateUtil.getSession();

		reimbursements = session.createQuery("from Reimbursements where idAuthor = :idVar").setInteger("idVar", uId)
				.list();

		Iterator<Reimbursements> i = reimbursements.iterator();

		while (i.hasNext()) {
			Reimbursements r = (Reimbursements) i.next();
			if (r.getDateRes() == null)
				i.remove();
		}

		return reimbursements;
	}
	
	public void insertReimbursementRequest(ErsUser user, int amount, String desc) {
				
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		Reimbursements request = new Reimbursements();
		ReimburseStatus status = new ReimburseStatus();
		ReimburseType type = new ReimburseType();

		
		status.setId(4263);
		status.setStatus("pending");	
		type.setId(4263);
		type.setType("general");
		
		request.setId(4263);
		request.setAmount(amount);
		request.setDes(desc);
		request.setDateSub(new Date());
		request.setIdAuthor(user.getId());
		request.setIdStatus(4263);
		request.setIdType(4263);
		
		session.save(status);
		session.save(type);
		session.save(request);
		
		session.getTransaction().commit();
	}
	
	public void approveReimbursementRequest(ErsUser user, int requestId) {
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		Reimbursements request = (Reimbursements) session.load(Reimbursements.class, requestId);
		ReimburseStatus status = (ReimburseStatus) session.load(ReimburseStatus.class, requestId);		
		
		status.setStatus("approved");
		request.setDateRes(new Date());
		request.setIdResolver(user.getId());
		
		session.update(status);
		session.update(request);
		
		session.getTransaction().commit();	
	}
	
	public void denyReimbursementRequest(ErsUser user, int requestId) {
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		Reimbursements request = (Reimbursements) session.load(Reimbursements.class, requestId);
		ReimburseStatus status = (ReimburseStatus) session.load(ReimburseStatus.class, requestId);		
		
		status.setStatus("denied");
		request.setDateRes(new Date());
		request.setIdResolver(user.getId());
		
		session.update(status);
		session.update(request);
		
		session.getTransaction().commit();	
	}

}
