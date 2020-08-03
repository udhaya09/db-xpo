package io.db.expo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity (name="Role")
@Table(name="dbx_role")
public class Role {

	
private static final long serialVersionUID = 1L;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="role_id")
	private Integer id;
	
	@Column(name ="role_name")
	private String name;
	
	 
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
	


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<User> getUsers() {
		return users;
	}


	

	

}
