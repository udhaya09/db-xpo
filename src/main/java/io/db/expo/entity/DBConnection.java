package io.db.expo.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "DBConnection")
@Table (name = "dbx_db_connection")
public class DBConnection {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column(name="connection_id")
	private Long id;
	
	@Column (name = "connection_name")
	private String connectionName;
	
	@ManyToOne
	@JoinColumn (name = "db_engine")
	private DBEngine dbEngine;
	
	@Column (name = "username")
	private String userName;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "db_url")
	private String dbUrl;

	@ManyToOne
	@JoinColumn (name = "user")
	private User user;
	
	@Column (name = "time_stamp")
	private Timestamp timestamp;
	
	@OneToMany (mappedBy = "connection", cascade = CascadeType.ALL)	
	private List<QueryManager> queries;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public DBEngine getDbEngine() {
		return dbEngine;
	}

	public void setDbEngine(DBEngine dbEngine) {
		this.dbEngine = dbEngine;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
}
