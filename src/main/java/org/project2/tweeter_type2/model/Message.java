package org.project2.tweeter_type2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "text")
    private String text;
    @Column(name = "tag")
    private String tag;

}
