package com.example.demoexception_2.controller.message;

import com.example.demoexception_2.controller.user.BaseController;
import com.example.demoexception_2.dto.request.command.message.AddMessageCommandRequest;
import com.example.demoexception_2.dto.response.command.message.AddMessageCommandResponse;
import com.example.demoexception_2.model.message.Message;
import com.example.demoexception_2.service.command.message.service.MessageCommandService;
import com.example.demoexception_2.service.query.message.service.MessageQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/message")
public class ExceptionController extends BaseController {
    private final MessageCommandService messageCommandService;
    private final MessageQueryService messageQueryService;

    @GetMapping("")
    public String getAllMessages(Model model) {
        List<Message> messageList = messageQueryService.getAllMessages();
        model.addAttribute("messageList", messageList);
        return "message";
    }

    @PostMapping("/add")
    public ResponseEntity<AddMessageCommandResponse> addMessage(AddMessageCommandRequest messageCommandRequest) {
      //  messageService.addMessage(messageCommandRequest);
        return excute(messageCommandRequest);
    }

//    @GetMapping("/delete/{messageId}")
//    public String deleteMessage(@PathVariable(name = "messageId") int messageId){
//        messageService.deleteMessage(messageId);
//        return "redirect:/message";
//    }

//    @GetMapping("/edit/{messageId}")
//    public ModelAndView editMessage(@PathVariable(name = "messageId") int messageId, Model model){
//        ModelAndView mav = new ModelAndView("edit");
//        Message message = messageService.editMessage(messageId);
//        mav.addObject("message", message);
//        return mav;
//    }
//    @PostMapping("/message/save")
//    public String saveMessage(@ModelAttribute("message") Message message){
//        messageService.addMessage(message);
//        return "redirect: ";
//    }

}
