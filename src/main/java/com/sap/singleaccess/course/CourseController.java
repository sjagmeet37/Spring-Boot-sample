package com.sap.singleaccess.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.singleaccess.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@RequestMapping("/topic/{id}/courses")
	public List<Course> getCourses(@PathVariable int id)
	{
		
		return courseService.allCourses(id); 
	}
	
	@RequestMapping("/topic/{topicId}/course/{courseId}")
	public Course getCourse(@PathVariable int courseid) 
	{
		return courseService.getCourse(courseid);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/course")
	public Course addCourse(@RequestBody Course course, @PathVariable int topicId)
	{	
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return course;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable int topicId,  @PathVariable int id)
	{
		course.setTopic(new Topic(topicId, "", ""));
		 courseService.updateCourse(course);
	
	}
		
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{topicId}/course/{id}")
	public void addTopic(@PathVariable int id)
	{
		courseService.deleteCourse(id);
	}
}
