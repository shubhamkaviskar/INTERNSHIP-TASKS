package com.App_MVCMailSender.Services;

import java.io.File;
import javax.mail.MessagingException;
import com.App_MVCMailSender.Model.MailInfo;

public interface MailServices {
    void sendMail(MailInfo info);
    void sendMailWithAttachment(MailInfo info, File attachment) throws MessagingException;
    void sendMailWithInlineContent(MailInfo info) throws MessagingException;
}
