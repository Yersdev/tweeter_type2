package org.project2.tweeter_type2.controller;

import lombok.RequiredArgsConstructor;
import org.project2.tweeter_type2.model.Message;
import org.project2.tweeter_type2.services.MessageServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
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
    public String mainPage(Model model) {
        List<Message> messages = messageServices.findAll();
        model.addAttribute("messages", messages);
        model.addAttribute("message", new Message());
        return "main";
    }

    @PostMapping("/main")
    public String addMessage(@Valid Message message, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Message> messages = messageServices.findAll();
            model.addAttribute("messages", messages);
            return "main"; // Возвращаем ту же страницу с отображением ошибок
        }

        messageServices.save(message);
        return "redirect:/main";
    }
//    @PostMapping("/main")
//    public String updateMessage(@Valid Message message, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            List<Message> messages = messageServices.findAll();
//        }
//        Message updMessage = new Message();
//        updMessage.setId(message.getId());
//        updMessage.setText(message.getText());
//        updMessage.setTag(message.getTag());
//        messageServices.save(updMessage);
//        return "redirect:/main";
//    }
}
