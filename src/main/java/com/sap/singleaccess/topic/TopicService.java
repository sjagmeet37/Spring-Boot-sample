package com.sap.singleaccess.topic;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
		
	@Autowired
	TopicRepositiory topicRepositiory;
	
	
	public List<Topic> allTopics()
	{
		List<Topic> list = new ArrayList<>();
		Iterable<Topic> iter = topicRepositiory.findAll();
		for(Topic t : iter)
		{
			list.add(t);
		}
		return list;
		
		/*
		 * using lambda expression
		 * topicRepositiory.findAll().forEach(list :: add);
		 * 
		 * */
		
		
	}
	
	public Topic getTopic(int id)
	{
		/*
		 * simple array list parser
		 * for (Topic i : topics)
		{
			if (i.getId() == id) {
				return i;
			}
		}
		
		return null;*/
		
		return topicRepositiory.findById(id).get();

		//		return topicRepositiory.findById(id).orElse(null);
		
	}
	
	public void addTopic(Topic topic) {

		topicRepositiory.save(topic);
	}

	
	public void updateTopic(Topic topic, int id) {
	
		/*
		 * save method looks if entity is present, if it is present it will update else it will create using passed argument 
		 * */
		topicRepositiory.save(topic);
		
	}

	public void deleteTopic(int id) {
			
		topicRepositiory.deleteById(id);;
	}
	
}
