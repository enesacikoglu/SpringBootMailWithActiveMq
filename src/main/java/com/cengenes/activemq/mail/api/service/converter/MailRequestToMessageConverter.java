package com.cengenes.activemq.mail.api.service.converter;


import com.cengenes.activemq.mail.api.model.request.MailRequest;
import com.cengenes.activemq.mail.api.queue.model.MailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailRequestToMessageConverter {

    public MailMessage convert(MailRequest request) {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setSubject(request.getSubject());
        mailMessage.setSender(request.getSender());
        mailMessage.setToList(request.getToList());
        mailMessage.setBccList(request.getBccList());
        mailMessage.setCcList(request.getCcList());
        mailMessage.setReplyTo(request.getReplyTo());
        mailMessage.setBody(request.getBody());
        return mailMessage;
    }
}
