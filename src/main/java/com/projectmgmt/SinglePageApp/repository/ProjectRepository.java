package com.projectmgmt.SinglePageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmgmt.SinglePageApp.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
