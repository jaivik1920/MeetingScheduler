package com.meetingscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meetingscheduler.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	@Query("select u from User u where u.userEmail=:email")
	public User findByUserEmail(@Param("email") String email);
	
	@Query("select u from User u where u.userAuthid=:userauthid")
	public User findByUserAuthId(@Param("userauthid") String userauthid);
}
