package io.db.expo.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import io.db.expo.core.CommonUtils;
import io.db.expo.entity.DBConnection;
import io.db.expo.entity.DBEngine;
import io.db.expo.entity.QueryManager;
import io.db.expo.forms.ExportQueryForm;
import io.db.expo.service.DBConnectionService;
import io.db.expo.service.ExportService;

@RequestMapping("/export")
@Controller
public class ExportController {

	
	@Autowired
	private CommonUtils UTILS;
	
	@Autowired
	private DBConnectionService connectionService;
	
	@Autowired
	private ExportService exportService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExportController.class);
	
	

	@PostMapping("/download-excel")
	public void downloadExcel(@ModelAttribute ExportQueryForm form, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res) throws IOException, ParseException {
		
		LOG.info("info: downloadExcel");
		
		DBConnection connection = connectionService.getConnectionById(form.getConnectionId());
		String fileName = form.getReportName().toUpperCase().replace(" ", "_") + ".xlsx";
		
		if(exportService.getReportInExcel(connection.getDbEngine().getClassDriver(), connection.getUserName(), connection.getPassword(), connection.getDbUrl(), fileName, form.getQuery())) {
			
			LOG.info("info: excel generated and saved");
			
			QueryManager qManager = new QueryManager();
			
			qManager.setConnection(connection);
			qManager.setQuery(form.getQuery());
			qManager.setReportName(form.getReportName());
			connectionService.saveQuery(qManager);
			
			LOG.info("info: query saved");
			res.sendRedirect("/rest/download/"+fileName);
						
		}
		
	}
	
	@PostMapping("/download-exist-excel")
	public void downloadExistExcel(@ModelAttribute QueryManager qm, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res) throws IOException, ParseException {
		
		QueryManager queryManager = connectionService.findQueryById(qm.getId());
		
		LOG.info("info: downloadExistExcel" + queryManager.getId());
		
		DBConnection connection = queryManager.getConnection();
		String fileName = queryManager.getReportName().toUpperCase().replace(" ", "_") + ".xlsx";
		
		if(exportService.getReportInExcel(connection.getDbEngine().getClassDriver(), connection.getUserName(), connection.getPassword(), connection.getDbUrl(), fileName, queryManager.getQuery())) {
			
			LOG.info("info: excel generated and saved");
			queryManager.setTimestamp(UTILS.currentTimestamp());
			connectionService.saveQuery(queryManager);
			res.sendRedirect("/rest/download/"+fileName);
						
		}
		
	}
	
	
	@GetMapping(value= {"/recentreports"})
	public String recentReports(HttpServletRequest req) {
		List<QueryManager> reports = exportService.findAllReports(UTILS.currentLoggedInUser());
		req.setAttribute("reports", reports);		
			return ".RecentReports";
		
	}


	
}
