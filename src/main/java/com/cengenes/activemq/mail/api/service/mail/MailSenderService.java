package com.cengenes.activemq.mail.api.service.mail;

import com.cengenes.activemq.mail.api.queue.model.MailMessage;

public interface MailSenderService {
        void sendMail(MailMessage mailMessage);
    }

