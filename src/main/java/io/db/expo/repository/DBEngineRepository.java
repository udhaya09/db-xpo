package io.db.expo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.db.expo.entity.DBEngine;
import io.db.expo.entity.User;

public interface DBEngineRepository extends JpaRepository<DBEngine, Integer>{

	DBEngine findByDbEngineName(String dbEngineName);



}
