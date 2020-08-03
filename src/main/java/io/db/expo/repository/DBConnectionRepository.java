package io.db.expo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.db.expo.entity.DBConnection;
import io.db.expo.entity.User;


public interface DBConnectionRepository extends JpaRepository<DBConnection, Long>{

	List<DBConnection> findAllByUser(User currentLoggedInUser);



}
