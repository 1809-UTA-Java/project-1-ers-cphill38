package com.revature.ERSProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENTS")
public class Reimbursements {
	
	@Id
	@Column(name="R_ID")
	int id;
	
	@Column(name="R_AMOUNT")
	double amount;
	
	@Column(name="R_DESCRIPTION")
	String des;

	//@Column(name="R_RECEIPT")
	//

	@Column(name="R_SUBMITTED")
	Date dateSub;

	@Column(name="R_RESOLVED")
	Date dateRes;

	@Column(name="U_ID_AUTHOR")
	int idAuthor;

	@Column(name="U_ID_RESOLVER")
	Integer idResolver;

	@Column(name="R_TYPE_ID")
	int idType;

	@Column(name="R_STATUS_ID")
	int idStatus;

	
	public Reimbursements() {
		super();	
	}


	public Reimbursements(int id, double amount, String des, Date dateSub, Date dateRes, int idAuthor, int idResolver,
			int idType, int idStatus) {
		super();
		this.id = id;
		this.amount = amount;
		this.des = des;
		this.dateSub = dateSub;
		this.dateRes = dateRes;
		this.idAuthor = idAuthor;
		this.idResolver = idResolver;
		this.idType = idType;
		this.idStatus = idStatus;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}


	public Date getDateSub() {
		return dateSub;
	}


	public void setDateSub(Date dateSub) {
		this.dateSub = dateSub;
	}


	public Date getDateRes() {
		return dateRes;
	}


	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}


	public int getIdAuthor() {
		return idAuthor;
	}


	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}


	public int getIdResolver() {
		return idResolver;
	}


	public void setIdResolver(int idResolver) {
		this.idResolver = idResolver;
	}


	public int getIdType() {
		return idType;
	}


	public void setIdType(int idType) {
		this.idType = idType;
	}


	public int getIdStatus() {
		return idStatus;
	}


	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reimbursements [id=");
		builder.append(id);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", des=");
		builder.append(des);
		builder.append(", dateSub=");
		builder.append(dateSub);
		builder.append(", dateRes=");
		builder.append(dateRes);
		builder.append(", idAuthor=");
		builder.append(idAuthor);
		builder.append(", idResolver=");
		builder.append(idResolver);
		builder.append(", idType=");
		builder.append(idType);
		builder.append(", idStatus=");
		builder.append(idStatus);
		builder.append("]");
		return builder.toString();
	}
	
	

}
