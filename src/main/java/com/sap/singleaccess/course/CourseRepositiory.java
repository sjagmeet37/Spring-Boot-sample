package com.sap.singleaccess.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepositiory extends CrudRepository<Course, Integer> {

	public List<Course> findByTopicId(Integer topicId);
	
	//syntax to declare method find(if it's a read method)By(followed by property)property_name(if it's a datatype write filed name or if it's an object writr class name followed by key/property of that class)
	
}
