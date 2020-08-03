package io.db.expo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.db.expo.entity.DBConnection;
import io.db.expo.entity.DBEngine;
import io.db.expo.entity.QueryManager;
import io.db.expo.entity.User;

public interface QueryManagerRepository extends JpaRepository<QueryManager, Long>{

	@Query("SELECT q FROM QueryManager q WHERE q.connection IN :connections")
	List<QueryManager> findAllByConnections(@Param("connections") List<DBConnection> connections);


}
