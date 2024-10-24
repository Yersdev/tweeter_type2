package repository;


import model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepositorry extends JpaRepository<Message, Integer> {

}
