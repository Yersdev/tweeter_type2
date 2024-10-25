package org.project2.tweeter_type2.controller;

import lombok.RequiredArgsConstructor;
import org.project2.tweeter_type2.model.Message;
import org.project2.tweeter_type2.services.MessageServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

     private final MessageServices messageServices;
     @GetMapping("/")
     public String greeting() {
         return "greeting";
     }

    @GetMapping("/main")
    // Путь для главной страницы
    public String mainPage(Model model) {
        List<Message> messages = messageServices.findAll(); // Не нужно кастовать, возвращает List<Message>
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/main") // Убедитесь, что это совпадает с действием формы
    public String addMessage(@RequestParam String text, @RequestParam String tag, Model model) {
        Message newMessage = new Message();
        newMessage.setText(text);
        newMessage.setTag(tag);

        // Сохранение нового сообщения в репозитории
        messageServices.save(newMessage);

        // Получение обновленного списка сообщений
        List<Message> messages = messageServices.findAll(); // Не нужно кастовать
        model.addAttribute("messages", messages); // Добавляем список сообщений в модель

        return "main"; // Возвращаем main.mustache
    }
}
