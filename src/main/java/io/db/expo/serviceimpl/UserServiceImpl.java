package io.db.expo.serviceimpl;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.db.expo.entity.Role;
import io.db.expo.entity.User;
import io.db.expo.repository.RoleRepository;
import io.db.expo.repository.UserRepository;
import io.db.expo.service.UserService;

@Service ("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    
    public void saveUser(User user) {
    	LOG.info("**INSIDE saveUser**");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));       
        Role role = roleRepository.findByName("USER");        
        HashSet<Role> roles = new HashSet<Role>();
        roles.add(role);        
        user.setRoles(roles);
        user.setStatus(1);
        userRepository.save(user);
    }

    
    public User findByUsername(String username) {
    	LOG.info("**INSIDE findByUsername**");
        return userRepository.findUserByUserName(username);
    }


	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}


	@Override
	public void addDefaultRoles() {
		// TODO Auto-generated method stub
		if(roleRepository.findByName("ADMIN")==null) {
			LOG.info("SAVING ADMIN ROLE");
			Role adminRole = new Role();
			adminRole.setName("ADMIN");
			roleRepository.save(adminRole);
					
		}
		if(roleRepository.findByName("USER")==null) {
				LOG.info("SAVING USER ROLE");
				Role userRole = new Role();
				userRole.setName("USER");
				roleRepository.save(userRole);		
		}
			
	
	}
	

	
}

