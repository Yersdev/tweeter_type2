package org.project2.tweeter_type2.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import org.project2.tweeter_type2.model.Message;
import org.project2.tweeter_type2.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void deleteById(int id) {
        Long id_Delete = (long) id;
        messageRepository.deleteById(id_Delete);
    }
    public Message findById(int id) {
        Optional<Message> foundMeassage = messageRepository.findById((long)id);
        return foundMeassage.orElse(null);
    }


}
