package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    private int id;
    private String message;
    private String tag;
    public Message(String message, String tag) {
        this.message = message;
        this.tag = tag;
    }
}
