package org.project2.tweeter_type2.services;

import lombok.RequiredArgsConstructor;
import org.project2.tweeter_type2.model.Message;
import org.project2.tweeter_type2.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServices {

    private final MessageRepository messageRepository;


    public void save(Message message) {
        messageRepository.save(message);
    }
    public List<Message> findAll(){
        return messageRepository.findAll();
    }
}
