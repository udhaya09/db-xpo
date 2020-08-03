package io.db.expo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "DBEngine")
@Table (name = "dbx_db_engine")
public class DBEngine {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column(name="db_engine_id")
	private Integer id;
	
	@Column (name = "db_engine_name")
	private String dbEngineName;
	
	@Column (name = "class_driver")
	private String classDriver;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDbEngineName() {
		return dbEngineName;
	}

	public void setDbEngineName(String dbEngineName) {
		this.dbEngineName = dbEngineName;
	}

	public String getClassDriver() {
		return classDriver;
	}

	public void setClassDriver(String classDriver) {
		this.classDriver = classDriver;
	}
	
	
	
	
	
}
