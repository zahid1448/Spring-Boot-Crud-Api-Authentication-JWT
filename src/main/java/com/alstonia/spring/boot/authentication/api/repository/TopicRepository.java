package com.alstonia.spring.boot.authentication.api.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alstonia.spring.boot.authentication.api.model.Topics;

public interface TopicRepository extends CrudRepository<Topics,String>{

//	List<Topics> search(String keyword);

}
