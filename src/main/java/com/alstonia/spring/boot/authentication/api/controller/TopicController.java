package com.alstonia.spring.boot.authentication.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alstonia.spring.boot.authentication.api.model.Topics;
import com.alstonia.spring.boot.authentication.api.repository.TopicRepository;
import com.alstonia.spring.boot.authentication.api.service.TopicService;
@RestController
public class TopicController {
	@Autowired
	private TopicService topicservice;
	
	@RequestMapping("/topics/createTopic")
	public List<Topics> getAllTopics(){
		return topicservice.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topics getTopics(@PathVariable String id){
		return topicservice.getTopics(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics/createTopic")
	public void addTopics(@RequestBody Topics topics){
		topicservice.addTopics(topics);
	}
	@RequestMapping(method=RequestMethod.GET, value="/topics")
	public Topics getTopicByName(@RequestParam String name){
		return topicservice.getTopicByName(name);
		
				
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopics(@RequestBody Topics topics,@PathVariable String id){
		topicservice.updateTopics(id,topics);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopics(@PathVariable String id){
		 topicservice.deleteTopics(id);
}
//	@RequestMapping("/")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<Topics> listProducts = topicservice.listAll(keyword);
//        model.addAttribute("listProducts", listProducts);
//        model.addAttribute("keyword", keyword);
//         
//        return "index";
//    }
}