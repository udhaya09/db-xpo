package io.db.expo.forms;

import java.math.BigDecimal;

public class ExportQueryForm {

	
	private static final long serialVersionUID = 1L;
	
	private Long connectionId;
	
	private String query;
	
	private String reportName;
	
	

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
