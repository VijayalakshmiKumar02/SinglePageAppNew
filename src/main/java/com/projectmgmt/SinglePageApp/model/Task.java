package com.projectmgmt.SinglePageApp.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Task")
public class Task {
	
	  private Long taskId;
	  @NotBlank
	  private String taskName;
	  @Temporal(TemporalType.TIMESTAMP)
	  //@CreatedDate
	  private Date createdAt;
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date endDate;
	  private Integer priority;
	  private String status;
	  private Project project;
	  private ParentTask parenttask;
	  public Task(){
			 
		 }
		  public Task(Long taskId, Long parentId,Long projectId, String taskName,Date createdAt, Date endDate,Integer priority){
		       this.taskId = taskId;
		       this.parenttask = new ParentTask(parentId);
		       this.project = new Project(projectId);
		       this.taskName = taskName;
		       this.createdAt = createdAt;
		       this.endDate = endDate;
		       this.priority = priority;
		       
		    }
		
		  
		  @Id
		  @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getTaskId() {
		return taskId;
	}
		  @OneToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name = "user_id", nullable = false)
		    private UserDetails user;
		  
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getTask() {
		return taskName;
	}
	public void setTask(String taskName) {
		this.taskName = taskName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	  
	@ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "parentId")
	@JsonBackReference
public ParentTask getParenttask() {
	return parenttask;
}
public void setParenttask(ParentTask parenttask) {
	this.parenttask = parenttask;
}
@ManyToOne(fetch= FetchType.EAGER)
@JoinColumn(name = "projectId")
@JsonBackReference
public Project getProject() {
	return project;
}
public void setProject(Project project) {
	this.project = project;
}  
}
