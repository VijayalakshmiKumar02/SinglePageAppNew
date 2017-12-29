package com.projectmgmt.SinglePageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmgmt.SinglePageApp.model.ParentTask;

public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

}
