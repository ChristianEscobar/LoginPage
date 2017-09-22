package org.web.login.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity()
@Table(name="USERS")
@NamedQueries({@NamedQuery(name="User.byName", query="from User where firstName = :firstName and lastName = :lastName"),
				@NamedQuery(name="User.byUserName", query="from User where userName = :userName"),
				@NamedQuery(name="User.byUserNameAndPassword", query="from User where userName = :userName and password = :password")})
public class User {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
