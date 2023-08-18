package com.example.toDoApp.Model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema="tbl_toDo")
public class ToDo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="toDo_id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="status")
	private boolean status=false;
	@Column(name="createdAt")
	private LocalDateTime createdAt=LocalDateTime.now() ;
	public ToDo(String title, String description) {
		super();
		
		this.title = title;
		this.description = description;
	
	}
	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public ToDo() {
		super();
	}
	@Override
	public String toString() {
		return "toDo [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	

}

