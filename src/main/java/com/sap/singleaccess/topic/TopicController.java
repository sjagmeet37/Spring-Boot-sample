package com.sap.singleaccess.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@RequestMapping("/topic")
	public List<Topic> getTopics()
	{
		return topicService.allTopics(); 
	}
	
	@RequestMapping("/topic/{id}")//"/topic/{foo}"
	public Topic getTopic(@PathVariable int id) // (@PathVariable("foo") int id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topic")
	public Topic addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
		return topic;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
	public void addTopic(@RequestBody Topic topic, @PathVariable int id)
	{
		
		 topicService.updateTopic(topic,id);
	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic.{id}")
	public void addTopic(@PathVariable int id)
	{
		topicService.deleteTopic(id);
	}
}
