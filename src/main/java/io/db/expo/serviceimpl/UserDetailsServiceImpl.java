package io.db.expo.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.db.expo.core.CommonUtils;
import io.db.expo.entity.Role;
import io.db.expo.entity.User;
import io.db.expo.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    
  
    
	@Autowired
	private CommonUtils UTILS;

    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
    	
    	LOG.info("**INSIDE loadUserByUsername**");
    	
        User user = userRepository.findUserByUserName(username);
        LOG.debug("**DEBUGGING: userName: " +username);
        
        if (user == null) {
        	LOG.error("**ERR: USER NOT FOUND**");
        	throw new UsernameNotFoundException(username);
        }
        
        

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        
        
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}