package io.db.expo.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import io.db.expo.entity.User;
import io.db.expo.serviceimpl.UserServiceImpl;


@Component
public class CommonUtils {
	
	
private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
	
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//getting timestamp
	public Timestamp currentTimestamp() {		
		
		LOG.info("**INFO GETTING TIMESTAMP");
		Date date = new Date();  
		Timestamp ts=new Timestamp(date.getTime());
		return ts;
	}
	
	public Date currentDate() {
		LOG.info("info: currentDate");
		Date date = new Date();  		
		return date;
	}
	
	
	
	public User currentLoggedInUser() {
		
		LOG.info("**INFO GETTING CURRENT USER - TESTER" + this.environment.getActiveProfiles().toString());
		
		//LOG.debug("**DEBUG filelocation: " + serviceTyping.getFileLocatioEditServiceFormn());
				
				 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				  User user = userServiceImpl.findByUsername(auth.getName());
				 
				//setting user
		
				//User user = userService.findByUsername("tester");
		return user;
	}


	
	public Date getDateOf(String value) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(value);
		LOG.debug("debugging: string value: " + value + " date value: " + date);
		return date;
	}


	
	
	
	
	

}
