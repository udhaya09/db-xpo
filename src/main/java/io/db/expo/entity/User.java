package io.db.expo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;






@Entity (name="User")
@Table (name = "dbx_user")
public class User {

	
private static final long serialVersionUID = 1L;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id	
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column(name="user_id")
	private Long id;
	
	//@Size(min=3, message="Name must be atleast 3 characters")
	@Column(name="full_name")
	private String fullName;
	
	//@Size(min=3, message="Username must be atleast 3 characters")
	@Column(name ="user_name",unique = true)
	//@UniqueUserName(message = "Such username already exists. Please try something different.")
	private String userName;
	
	//@Size(min=4, message="Invalid Email Address!!")
	//@Email(message="Invalid Email Address!!")
	@Column(name ="email_address")
	//@UniqueEmailAddress(message = "Such email address already exists. Please provide the different one.")
	private String emailAddress;
	
	//@Size(min=8, message="Password must be atleast 8 characters")
	private String password;
	
		
	
@Column (name = "status")
	private Integer status;
	
	 @Transient
	 private String passwordConfirm;
	
	 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	private Set<Role> roles;
	
	@OneToMany	(mappedBy = "user", cascade = CascadeType.ALL)	 
	private List<DBConnection> dbConnections;

	
	

	public List<DBConnection> getDbConnections() {
		return dbConnections;
	}

	public void setDbConnections(List<DBConnection> dbConnections) {
		this.dbConnections = dbConnections;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}



	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	

	
	

}