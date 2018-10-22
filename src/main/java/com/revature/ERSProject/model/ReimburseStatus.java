package com.revature.ERSProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENT_STATUS")
public class ReimburseStatus {

	@Id
	@Column(name="RS_ID")
	int id;
	
	@Column(name="RS_STATUS")
	String status;
	
	public ReimburseStatus() {
		super();
	}

	public ReimburseStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReimburseStatus [id=");
		builder.append(id);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	

}
