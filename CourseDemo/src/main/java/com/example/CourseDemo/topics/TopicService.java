package com.example.CourseDemo.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {


    @Autowired
    private TopicRepository topicRepository;
//    private List<Topic> topics=new ArrayList<>( Arrays.asList(
//            new Topic("spring","Spring Framework","Spring Framework Description"),
//                new Topic("java","Jave","Java Description")
//
//    ));

    public List<Topic> getAllTopics(){
        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
//        return topics;
    }
    public Topic getTopic(String id){
        Optional<Topic> topicOptional = topicRepository.findById(id);
        // Check if the topic is present in the repository
        if(topicOptional.isPresent()) {
            return topicOptional.get();
        } else {
            // If the topic is not found, return Optional.empty()
            throw new RuntimeException("Id not found");
        }
    }
//    public Optional<Topic> getTopic(String id){
//
//        return topicRepository.findById(id);
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//    }
    public void addTopic(Topic topic){

        topicRepository.save(topic);
//        topics.add(topic);

    }

    public void updateTopic(String id,Topic topic){

        topicRepository.save(topic);

//        for (int i=0; i< topics.size();i++){
//            Topic temp=topics.get(i);
//            if (temp.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
//        topics.add(topic);

    }

    public void delTopic(String id) {
        topicRepository.deleteById(id);
//
//        topics.removeIf(t->t.getId().equals(id));
    }
}
