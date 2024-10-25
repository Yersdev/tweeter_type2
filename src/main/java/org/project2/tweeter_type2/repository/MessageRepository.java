package org.project2.tweeter_type2.repository;

import org.project2.tweeter_type2.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
        List<Message> findById(int id);
    }
