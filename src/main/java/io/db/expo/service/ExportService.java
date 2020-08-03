package io.db.expo.service;

import java.util.List;

import io.db.expo.entity.QueryManager;
import io.db.expo.entity.User;

public interface ExportService {
	
	Boolean getReportInExcel(String dBDriver, String userName, String password, String dbURL,
			String fileName, String query);

	List<QueryManager> findAllReports(User currentLoggedInUser);

}
