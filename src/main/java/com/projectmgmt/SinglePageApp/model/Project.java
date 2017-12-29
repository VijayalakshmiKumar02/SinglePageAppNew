package com.projectmgmt.SinglePageApp.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.FetchType;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
//import org.hibernate.jpamodelgen.xml.jaxb.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="project_details")
public class Project {

	  private Long projectId;
	  @NotBlank
	  private String projectName;
	  @Temporal(TemporalType.TIMESTAMP)
	  @CreatedDate
	  private Date createDate;
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date endDate;
	  private Integer priority;
	  private Set<UserDetails> users;
	  private Set<Task> tasks;	  
	  
	  public Project()
	  {
		  
	  }
	  public Project(Long projectId)
	  {
		  this.projectId=projectId;
		 
		  
	  }
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "projectId")
	public Long getprojectId() {
		return projectId;
	}
	public void setprojectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	@OneToMany(cascade = CascadeType.ALL)
	
	  @JoinColumn(name="projectId", referencedColumnName="projectId")
	@JsonManagedReference
	 public Set<UserDetails> getUsers() {
       return users;
   }

   public void setUsers(Set<UserDetails> users) {
       this.users = users;
   }
   public void addUser(UserDetails user) {
       users.add(user);
       user.setProject(this);
   }

   public void removeUser(UserDetails user) {
	   user.setProject(null);
       this.users.remove(user);
   }
   
   @OneToMany(cascade = CascadeType.ALL)
	
	  @JoinColumn(name="projectId", referencedColumnName="projectId")
	@JsonManagedReference
public Set<Task> getTasks() {
	return tasks;
}
public void setTasks(Set<Task> tasks) {
	this.tasks = tasks;
}
}
