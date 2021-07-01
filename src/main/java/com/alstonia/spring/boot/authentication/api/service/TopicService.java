package com.alstonia.spring.boot.authentication.api.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alstonia.spring.boot.authentication.api.model.Topics;
import com.alstonia.spring.boot.authentication.api.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topics> getAllTopics() {
		List<Topics> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	public Topics getTopics(String id) {
		return topicRepository.findOne(id);
	}
	public void addTopics(Topics topics) {
		topicRepository.save(topics);
		
	}
	public void updateTopics(String id, Topics topics) {
		topicRepository.save(topics);
		
	}
	public void deleteTopics(String id) {
		
		topicRepository.delete(id);
	}
	public Topics getTopicByName(String name) {
		List<Topics> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics.stream().filter(t->t.getName().equals(name)).findFirst().get();
	}
//	public List<Topics> listAll(String keyword) {
//        if (keyword != null) {
//            return topicRepository.search(keyword);
//        }
//        return (List<Topics>) topicRepository.findAll();
//    }
}
