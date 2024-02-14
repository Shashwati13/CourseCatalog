package com.example.CourseDemo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {


    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getAllCourses(String topicId){
        List<Course> courses =new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;

    }
    public Course getCourse(String id){
        Optional<Course> topicOptional = courseRepository.findById(id);
        // Check if the topic is present in the repository
        if(topicOptional.isPresent()) {
            return topicOptional.get();
        } else {
            // If the topic is not found, return Optional.empty()
            throw new RuntimeException("Id not found");
        }
    }

    public void addCourse(Course course){

        courseRepository.save(course);


    }

    public void updateCourse(Course course){

        courseRepository.save(course);



    }

    public void delCourse(String id) {
        courseRepository.deleteById(id);

    }
}
