package com.revature.ERSProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_USERS")
public class ErsUser {

	@Id
	@Column(name = "U_ID")
	int id;

	@Column(name = "U_USERNAME")
	String username;

	@Column(name = "U_PASSWORD")
	private String password;

	@Column(name = "U_FIRSTNAME")
	String firstname;

	@Column(name = "U_LASTNAME")
	String lastname;

	@Column(name = "U_EMAIL")
	String email;

	@Column(name = "UR_ID")
	int userRoleId;

//	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="UR_ID")
//	UserRole role;

	public ErsUser() {
		super();
	}

	public ErsUser(int id, String username, String password, String firstname, String lastname, String email,
			int userRoleId/* , UserRole role */) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.userRoleId = userRoleId;
		// this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

//	public UserRole getRole() {
//		return role;
//	}
//
//
//	public void setRole(UserRole role) {
//		this.role = role;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", email=");
		builder.append(email);
		builder.append(", userRoleId=");
		builder.append(userRoleId);
		builder.append("]");
		return builder.toString();
	}

}
