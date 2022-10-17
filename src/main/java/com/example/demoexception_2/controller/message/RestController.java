package com.example.demoexception_2.controller.message;

import com.example.demoexception_2.controller.user.BaseController;
import com.example.demoexception_2.dto.request.command.message.AddMessageCommandRequest;
import com.example.demoexception_2.dto.request.command.message.DeleteMessageCommandRequest;
import com.example.demoexception_2.dto.request.command.message.UpdateMessageCommandRequest;
import com.example.demoexception_2.dto.request.query.message.MessageQueryRequestData;
import com.example.demoexception_2.dto.response.command.message.AddMessageCommandResponse;
import com.example.demoexception_2.dto.response.command.message.DeleteMessageCommandResponse;
import com.example.demoexception_2.dto.response.command.message.UpdateMessageCommandResponse;
import com.example.demoexception_2.dto.response.query.message.MessageQueryResponseData;
import com.example.demoexception_2.model.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
    @RequestMapping("/message")
public class RestController extends BaseController {

    @PostMapping
    public ResponseEntity<AddMessageCommandResponse> createNewMessage(@RequestBody Message message) {
        return excute(new AddMessageCommandRequest(message));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageQueryResponseData> getMessage(@PathVariable int id) {
        return excute(new MessageQueryRequestData(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMessageCommandResponse> deleteMessage(@PathVariable int id) {
        return excute(new DeleteMessageCommandRequest(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateMessageCommandResponse> updateMessage(@PathVariable int id, @RequestBody Message message) {
        return excute(new UpdateMessageCommandRequest(id, message));
    }
}

