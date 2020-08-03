package io.db.expo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.db.expo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findUserByUserName(String userName);

	User findUserByEmailAddress(String emailAddress);


}
