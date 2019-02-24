package com.sap.singleaccess.course;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
		
	@Autowired
	CourseRepositiory courseRepositiory;
	
	
	public List<Course> allCourses(int topicId)
	{
		List<Course> list = new ArrayList<>();
		Iterable<Course> iter = courseRepositiory.findByTopicId(topicId);
		for(Course t : iter)
		{
			list.add(t);
		}
		return list;	
	}
	
	public Course getCourse(int id)
	{
		return courseRepositiory.findById(id).get();
	}
	
	public void addCourse(Course course) 
	{
		courseRepositiory.save(course);
	}

	
	public void updateCourse(Course course) {

		courseRepositiory.save(course);
		
	}

	public void deleteCourse(int id) {
			
		courseRepositiory.deleteById(id);;
	}
	
}
