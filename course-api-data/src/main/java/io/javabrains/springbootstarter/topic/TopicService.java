package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","spring framework","spring framework Description"),
			new Topic("java","Core Java","Core Java Description"),
			new Topic("javascript","JavaScript","JavaScript Description")
		));
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic>getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		Topic topic =new Topic();
		var val = topicRepository.findById(id);
		if(val.isPresent()) {
			topic = val.get();
		}
		return topic;
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		//removeIf(t->t.getId().equals(id));
		
		topicRepository.deleteById(id);
	}
}
