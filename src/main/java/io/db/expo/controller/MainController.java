package io.db.expo.controller;


import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import io.db.expo.core.CommonUtils;
import io.db.expo.entity.DBConnection;
import io.db.expo.entity.DBEngine;
import io.db.expo.service.DBConnectionService;
import io.db.expo.service.UserService;


@Controller
public class MainController {
	
private static final Logger LOG = LoggerFactory.getLogger(MainController.class);	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DBConnectionService connectionService;
	
	@Autowired
	private CommonUtils UTILS;	
	
	@GetMapping(value= {"/home","/index"})
	public String displayHomePage(HttpServletRequest req) {
		List<DBEngine> dbEngines = connectionService.findAllDBEngines();
		List<DBConnection> dbConnections = connectionService.findAllDBConnections(UTILS.currentLoggedInUser());
		req.setAttribute("dbconnections", dbConnections);
		req.setAttribute("dbengines", dbEngines);
			return ".Index";
		
	}
	
	@GetMapping(value= {"/welcome","/"})
	public String displayIndexPage(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if(UTILS.currentLoggedInUser()!=null) {
			res.sendRedirect("/home");
			return ".Index";
		}else {
			return ".Welcome";
		}
	}
	
	@PostConstruct
	public void addDefaultValues() {
		userService.addDefaultRoles();
		connectionService.addDefaultDBEngines();
	}

}
