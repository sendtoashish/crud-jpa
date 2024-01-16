package com.g2it.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g2it.crud.model.onetoone.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.id = ?1")
	User findByIdUser(Long userId);
	
	@Query("SELECT u FROM User u")
	List<User> findAllUser();

}
