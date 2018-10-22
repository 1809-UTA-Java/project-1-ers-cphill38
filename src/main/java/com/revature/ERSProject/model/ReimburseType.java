package com.revature.ERSProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENT_TYPE")
public class ReimburseType {

	@Id
	@Column(name="RT_ID")
	int id;
	
	@Column(name="RT_TYPE")
	String type;
	
	public ReimburseType() {
		super();
	}

	public ReimburseType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReimburseType [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
	

}
