package com.projectmgmt.SinglePageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmgmt.SinglePageApp.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

}
