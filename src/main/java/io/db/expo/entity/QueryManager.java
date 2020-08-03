package io.db.expo.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity (name = "QueryManager")
@Table (name = "dbx_query_manager")
public class QueryManager {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column(name="qm_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn (name = "connection")
	private DBConnection connection;
	
	@Column (name = "report_name")
	private String reportName;
	
	@Column (name = "query", length = 25000, columnDefinition = "TEXT")
	private String query;
	
	@Column (name = "time_statmp")
	private Timestamp timestamp;
	
	
	

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DBConnection getConnection() {
		return connection;
	}

	public void setConnection(DBConnection connection) {
		this.connection = connection;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
	
	
}
