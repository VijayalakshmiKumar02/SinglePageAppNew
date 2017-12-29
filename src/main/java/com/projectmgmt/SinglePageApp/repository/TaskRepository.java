package com.projectmgmt.SinglePageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmgmt.SinglePageApp.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
