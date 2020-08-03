package io.db.expo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.db.expo.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String string);

}
