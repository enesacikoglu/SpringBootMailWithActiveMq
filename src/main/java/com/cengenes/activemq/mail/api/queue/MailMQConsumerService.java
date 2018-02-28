package com.cengenes.activemq.mail.api.queue;


import com.cengenes.activemq.mail.api.queue.model.MailMessage;
import com.cengenes.activemq.mail.api.service.mail.MailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public final class MailMQConsumerService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MailSenderService mailSenderService;

    @JmsListener(destination = QueueConstants.MAIL_QUEUE_NAME, containerFactory = "jmsContainerFactory")
    public void onSendMailRequest(final MailMessage mailMessage) {
        logger.info("Consuming mail message for sending mail to {}" , mailMessage.getToList());
        mailSenderService.sendMail(mailMessage);
    }

}
