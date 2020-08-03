package io.db.expo.service;

import java.util.List;

import io.db.expo.entity.DBConnection;
import io.db.expo.entity.DBEngine;
import io.db.expo.entity.QueryManager;
import io.db.expo.entity.User;

public interface DBConnectionService {

	void addDefaultDBEngines();

	List<DBEngine> findAllDBEngines();

	void saveConnection(DBConnection connection);

	List<DBConnection> findAllDBConnections(User currentLoggedInUser);

	DBConnection getConnectionById(Long connectionId);

	void saveQuery(QueryManager qManager);

	QueryManager findQueryById(Long parameter);




	

	
}
