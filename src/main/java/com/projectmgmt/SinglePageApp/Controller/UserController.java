package com.projectmgmt.SinglePageApp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmgmt.SinglePageApp.model.UserDetails;
import com.projectmgmt.SinglePageApp.repository.UserRepository;

@RestController
@RequestMapping("/singlepageapp")
public class UserController {
	 @Autowired
	 UserRepository userRepository;
	
	// Get All Users
	 @GetMapping("/user")
	 public List<UserDetails> getAllUsers() {
	     return userRepository.findAll();
	 }
	 
	 @GetMapping("/user/{id}")
	 public UserDetails getUser(@PathVariable(value = "id") Long userId) {
		 UserDetails user = userRepository.findOne(userId);
		 return user;
	 }
	// Create a new User
	 @PostMapping("/user")
	 public UserDetails createUser(@Valid @RequestBody UserDetails user) {
	     return userRepository.save(user);
	 }
	 
	// Update a User
	 @PutMapping("/user/{id}")
	 public ResponseEntity<UserDetails> updateUser(@PathVariable(value = "id") Long userId, 
	                                        @Valid @RequestBody UserDetails userDetails) {
	     UserDetails user = userRepository.findOne(userId);
	     if(user == null) {
	         return ResponseEntity.notFound().build();
	     }
	     user.setFirstName(userDetails.getFirstName());
	     user.setLastName(userDetails.getLastName());

	     UserDetails updatedUser = userRepository.save(user);
	     return ResponseEntity.ok(updatedUser);
	 }
	 // Delete a User
	 @DeleteMapping("/user/{id}")
	 public ResponseEntity<UserDetails> deleteUser(@PathVariable(value = "id") Long userId) {
	     UserDetails user = userRepository.findOne(userId);
	     if(user == null) {
	         return ResponseEntity.notFound().build();
	     }

	     userRepository.delete(userId);
	     return ResponseEntity.ok().build();
	 }
}
