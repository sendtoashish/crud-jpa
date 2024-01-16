package com.g2it.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2it.crud.model.onetoone.Address;
import com.g2it.crud.model.onetoone.User;
import com.g2it.crud.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	UserRepo userRepo;

	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PostMapping("/findAll")
	public List<User> findAll() {
		List<User> userList =  userRepo.findAllUser();
		List<User> userData = null;
	   if(userList != null) {
		   userData = new ArrayList<>();
		   User uDTO = null;
		   Address aDTO = null;
		   for(User u: userList) {
			   uDTO = new User();
			   aDTO = new Address();
			   uDTO.setId(u.getId());
			   uDTO.setName(u.getName());
			   uDTO.setAge(u.getAge());
			   aDTO.setId(u.getAddress().getId());
			   aDTO.setCity(u.getAddress().getCity());
			   aDTO.setCountry(u.getAddress().getCountry());
			   aDTO.setState(u.getAddress().getState());
			   uDTO.setAddress(aDTO);
			   userData.add(uDTO);
		   }
	   }
		return userData;
	}

	@GetMapping("/get/{userId}")
	public User getUserById(@PathVariable Long userId) {

		User repoUser = userRepo.findByIdUser(userId);
		Address address = new Address();
		address.setCity(repoUser.getAddress().getCity());
		address.setCountry(repoUser.getAddress().getCountry());
		address.setState(repoUser.getAddress().getState());
		address.setId(repoUser.getAddress().getId());
		User user = new User();
		user.setAge(repoUser.getAge());
		user.setName(repoUser.getName());
		user.setId(repoUser.getId());
		user.setAddress(address);
		return user;

	}

}
