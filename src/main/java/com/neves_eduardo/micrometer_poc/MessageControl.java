package com.neves_eduardo.micrometer_poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageControl {
    private List<Message> messages = new ArrayList<>();
    private int idIterator = 1;
    private MessageCustomMetric messageCustomMetric;

    @Autowired
    public MessageControl(MessageCustomMetric messageCustomMetric) {
        this.messageCustomMetric = messageCustomMetric;
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody
    ResponseEntity addMessage(@RequestBody Message message) {
        message.setId(idIterator);
        messages.add(message);
        idIterator++;
        messageCustomMetric.counterMessage(message);
        messageCustomMetric.addToTotalChars(message.getText().length());
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }


}
