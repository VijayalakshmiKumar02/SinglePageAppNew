package com.projectmgmt.SinglePageApp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="ParentTask")
public class ParentTask {
@Id
  private Long parentId;
  @NotBlank
  private String parentTitle;
  private Set<Task> tasks;	
  public ParentTask()
  {
	  
  }
  public ParentTask(Long parentId)
  {
	  this.parentId=parentId;
  }
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "parentId")
public Long getParentId() {
	return parentId;
}
public void setParentId(Long parentId) {
	this.parentId = parentId;
}
public String getParentTitle() {
	return parentTitle;
}
public void setParentTitle(String parentTitle) {
	this.parentTitle = parentTitle;
}
@OneToMany
  @JoinColumn(name="parentId", referencedColumnName="parentId")
@JsonManagedReference
public Set<Task> getTasks() {
	return tasks;
}
public void setTasks(Set<Task> tasks) {
	this.tasks = tasks;
}
  	
}
