package io.db.expo.serviceimpl;

import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.db.expo.entity.DBConnection;
import io.db.expo.entity.DBEngine;
import io.db.expo.entity.QueryManager;
import io.db.expo.entity.Role;
import io.db.expo.entity.User;
import io.db.expo.repository.DBConnectionRepository;
import io.db.expo.repository.DBEngineRepository;
import io.db.expo.repository.QueryManagerRepository;
import io.db.expo.repository.RoleRepository;
import io.db.expo.repository.UserRepository;
import io.db.expo.service.DBConnectionService;
import io.db.expo.service.UserService;

@Service ("DBConnectionService")
public class DBConnectionServiceImpl implements DBConnectionService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private QueryManagerRepository qmRepository;
    
    @Autowired
    private DBEngineRepository dbEngineRepository;
    

    @Autowired
    private DBConnectionRepository dbConnectionRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private static final Logger LOG = LoggerFactory.getLogger(DBConnectionServiceImpl.class);

	@Override
	public void addDefaultDBEngines() {
		// TODO Auto-generated method stub
		if(dbEngineRepository.findByDbEngineName("PostgreSQL")==null) {
			DBEngine postgresDb = new DBEngine();
			postgresDb.setDbEngineName("PostgreSQL");
			postgresDb.setClassDriver("org.postgresql.Driver");
			dbEngineRepository.save(postgresDb);
		}
		if(dbEngineRepository.findByDbEngineName("MySQL")==null) {
			DBEngine mySqlDb = new DBEngine();
			mySqlDb.setDbEngineName("MySQL");
			mySqlDb.setClassDriver("com.mysql.jdbc.Driver");
			dbEngineRepository.save(mySqlDb);
		}
		
		
		
	}

	@Override
	public List<DBEngine> findAllDBEngines() {
		// TODO Auto-generated method stub
		
		return dbEngineRepository.findAll();
	}

	public void saveConnection(DBConnection connection) {
		// TODO Auto-generated method stub
		dbConnectionRepository.save(connection);
	}

	
	public List<DBConnection> findAllDBConnections(User currentLoggedInUser) {
		// TODO Auto-generated method stub
		return dbConnectionRepository.findAllByUser(currentLoggedInUser);
	}


	public DBConnection getConnectionById(Long connectionId) {
		// TODO Auto-generated method stub
		return dbConnectionRepository.findById(connectionId).get();
	}


	public void saveQuery(QueryManager qManager) {
		// TODO Auto-generated method stub
		qmRepository.save(qManager);
	}

	@Override
	public QueryManager findQueryById(Long parameter) {
		// TODO Auto-generated method stub
		return qmRepository.findById(parameter).get();
	}

   

	
}

