package com.example.demo.jms;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jms.core.*;
import org.springframework.stereotype.*;

@Component
public class MessageSender{
    private final JmsTemplate jmsTemplate;

    @Autowired
    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Value("${spring.jms.myQueue}")
    private String queue;

    public void mySend(String message) {
        // MessageCreator messageCreator = new MessageCreator() {
        //     @Override
        //     public Message createMessage(Session session) throws JMSException {
        //         return session.createTextMessage(message);
        //     }
        // };

        MessageCreator messageCreator = session -> session.createTextMessage(message);

        jmsTemplate.send(queue, messageCreator);


        // jmsTemplate.convertAndSend(queue, message);
    }
}

