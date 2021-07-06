package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
}
