package com.example.toDoProject.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(schema="tbl_toDo")
public class toDo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="toDo_id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="status")
	private String status;
	@Column(name="createdAt")
	private Date createdAt ;
	public toDo(String title, String description, String status, Date createdAt) {
		super();
		
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public toDo() {
		super();
	}
	@Override
	public String toString() {
		return "toDo [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	

}
