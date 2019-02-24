package com.sap.singleaccess.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.sap.singleaccess.topic.Topic;

@Entity
public class Course {
	
	@Id
	private Integer id;
	private String name;
	private String description;

	@ManyToOne
	private Topic topic;
	
	public Course() {

	}
	
	
	public Course(int id, String name, String description, Integer topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
		
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	
	
	
}
