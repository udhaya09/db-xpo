package io.db.expo.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.db.expo.core.CommonUtils;
import io.db.expo.entity.DBConnection;
import io.db.expo.service.DBConnectionService;

@RequestMapping ("/connections")
@Controller 
public class DBConnectionController {
	@Autowired
	private CommonUtils UTILS;
	
	@Autowired
	private DBConnectionService connectionService;
	
	private static final Logger LOG = LoggerFactory.getLogger(DBConnectionController.class);
	
	@PostMapping("/save-new-connection")
	public void saveNewConnection(@ModelAttribute DBConnection connection, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res) throws IOException, ParseException {
		
		LOG.info("info: saveNewConnection");
		
		connection.setUser(UTILS.currentLoggedInUser());
		connectionService.saveConnection(connection);
		LOG.info("info: connection saved");
		res.sendRedirect("/home");
	}

}
