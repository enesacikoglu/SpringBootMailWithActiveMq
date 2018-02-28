package com.cengenes.activemq.mail.api.controller;



import com.cengenes.activemq.mail.api.model.request.MailRequest;
import com.cengenes.activemq.mail.api.model.response.MailResponse;
import com.cengenes.activemq.mail.api.model.response.ResponseStatusType;
import com.cengenes.activemq.mail.api.queue.MailMQPublisherService;
import com.cengenes.activemq.mail.api.queue.model.MailMessage;
import com.cengenes.activemq.mail.api.service.converter.MailRequestToMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    protected MailMQPublisherService mailMQPublisherService;
    @Autowired
    private MailRequestToMessageConverter mailRequestToMessageConverter;

    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public MailResponse send(@RequestBody final MailRequest request) {
        final  MailResponse response = new MailResponse();

        try {
            final MailMessage message = mailRequestToMessageConverter.convert(request);
            mailMQPublisherService.publishMailMessage(message);
            response.setStatus(ResponseStatusType.SUCCESS.getValue());

        } catch(Exception e){
            response.setStatus(ResponseStatusType.FAILURE.getValue());
        }
        return response;
    }

}
