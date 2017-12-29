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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectmgmt.SinglePageApp.model.Task;
import com.projectmgmt.SinglePageApp.model.Project;
import com.projectmgmt.SinglePageApp.repository.TaskRepository;

@RestController
@RequestMapping("/singlepageapp")
public class TaskController {




	 @Autowired
	 TaskRepository taskrepository;
	
	// Get All Tasks
	 @GetMapping("/task")
	 public List<Task> getAllTasks() {
	     return taskrepository.findAll();
	 }
	// Create a new Task
	 @PostMapping("/task")
	 public Task createTask(@Valid @RequestBody Task task) {
	     return taskrepository.save(task);
	 }
	 
	// Update a Task
		 @PutMapping("/task/{id}")
		 @ResponseBody
		 public ResponseEntity<Task> updateUser(@PathVariable(value = "taskId") Long taskId, 
		                                        @Valid @RequestBody Task taskjson) {
			 Task task = taskrepository.findOne(taskId);
		     if(task == null) {
		         return ResponseEntity.notFound().build();
		     }
		     task.setTask(task.getTask());
		     task.setCreatedAt(task.getCreatedAt());
		     task.setEndDate(task.getEndDate());
		     task.setPriority(task.getPriority());
		     task.setStatus(task.getStatus());
		     
		     Task updatedtask = taskrepository.save(task);
		     return ResponseEntity.ok(updatedtask);
		 }
		 // Delete a Task
		 @DeleteMapping("/task/{id}")
		 public ResponseEntity<Task> deleteUser(@PathVariable(value = "taskId") Long taskId) {
			 Task task = taskrepository.findOne(taskId);
		     if(task == null) {
		         return ResponseEntity.notFound().build();
		     }

		     taskrepository.delete(task);
		     return ResponseEntity.ok().build();
		 }
}
