package org.project2.tweeter_type2.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @PositiveOrZero(message = "ID должен быть неотрицательным числом")
    private int id;
    @Size(min = 10, max = 250, message = "Текст должен содержать от 10 до 250 символов")
    @Column(name = "text")
    private String text;
    @Size(min = 3, max = 50, message = "Тэг должен содержать от 3  до 50 символов")
    @Column(name = "tag")
    private String tag;

}
