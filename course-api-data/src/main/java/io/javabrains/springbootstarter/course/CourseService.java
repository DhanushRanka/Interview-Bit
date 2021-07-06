package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	//private List<Course> topics = new ArrayList<>(Arrays.asList(
	//		new Course("spring","spring framework","spring framework Description"),
	//		new Course("java","Core Java","Core Java Description"),
	//		new Course("javascript","JavaScript","JavaScript Description")
	//	));
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Course>getAllCourses(String topicId){
		//return topics;
		List<Course> course = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(course::add);
		return course;
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		Course course =new Course();
		var val = courseRepository.findById(id);
		if(val.isPresent()) {
			course = val.get();
		}
		return course;
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		//removeIf(t->t.getId().equals(id));
		
		courseRepository.deleteById(id);
	}
}
