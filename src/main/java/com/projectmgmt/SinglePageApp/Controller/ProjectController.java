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

import com.projectmgmt.SinglePageApp.model.Project;
import com.projectmgmt.SinglePageApp.model.UserDetails;
import com.projectmgmt.SinglePageApp.repository.ProjectRepository;

@RestController
@RequestMapping("/singlepageapp")
public class ProjectController {




	 @Autowired
	 ProjectRepository projectrepository;
	
	// Get All projects
	 @GetMapping("/project")
	 public List<Project> getAllProjects() {
	     return projectrepository.findAll();
	 }
	// Create a new project
	 @PostMapping("/project")
	 public Project createProject(@Valid @RequestBody Project project) {
		 UserDetails user = new UserDetails();
		 user.setProject(project);
		 
	     return projectrepository.save(project);
	 }
	 
	// Update a project
		 @PutMapping("/project/{id}")
		 public ResponseEntity<Project> updateUser(@PathVariable(value = "projectId") Long projectId, 
		                                        @Valid @RequestBody Project projectjson) {
			 Project project = projectrepository.findOne(projectId);
		     if(project == null) {
		         return ResponseEntity.notFound().build();
		     }
		     project.setProjectName(project.getProjectName());
		     project.setCreateDate(project.getCreateDate());
		     project.setEndDate(project.getEndDate());
		     project.setPriority(project.getPriority());
		     Project updatedproject = projectrepository.save(project);
		     return ResponseEntity.ok(updatedproject);
		 }
		 // Delete a project
		 @DeleteMapping("/project/{id}")
		 public ResponseEntity<Project> deleteUser(@PathVariable(value = "id") Long projectId) {
			 Project project = projectrepository.findOne(projectId);
		     if(project == null) {
		         return ResponseEntity.notFound().build();
		     }

		     projectrepository.delete(project);
		     return ResponseEntity.ok().build();
		 }
}
