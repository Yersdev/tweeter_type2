package controller;

import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.MessageRepositorry;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepositorry messageRepositorry;

    @GetMapping("")  // Явно указываем путь
    public String mainPage(Map<String, Object> model) {
        Iterable<Message> messages = messageRepositorry.findAll();
        model.put("messages", messages);
        return "main";  // Возвращаем название шаблона
    }

    @PostMapping("/add") // Убедитесь, что у вас есть этот путь
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message newMessage = new Message(text, tag);
        messageRepositorry.save(newMessage);
        return "main"; // Возвращает main.mustache
    }

}

