package com.App_MVCMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import javax.mail.MessagingException;
import com.App_MVCMailSender.Model.MailInfo;
import com.App_MVCMailSender.Services.MailServices;

@Controller
public class AppController {
    @Autowired
    private MailServices service;

    @RequestMapping("/")
    public String landingPage() {
        System.out.println("1st Page : Landing Page");
        return "index";
    }

    @RequestMapping("/contact")
    public String contactUs() {
        System.out.println("2nd Page : Contact Page");
        return "contactPage";
    }

    @RequestMapping("/sendEmail")
    public String sendMail(@ModelAttribute MailInfo info) {
        System.out.println(info);
        service.sendMail(info);
        return "contactPage";
    }

    @RequestMapping("/sendEmailWithAttachment")
    public String sendMailWithAttachment(@ModelAttribute MailInfo info, @RequestParam("file") MultipartFile file)
            throws IOException, MessagingException {
        File attachment = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(attachment);
        service.sendMailWithAttachment(info, attachment);
        System.out.println("3rd Page : IMG SENT ON MAIL");
        return "contactPage";
    }

    @RequestMapping("/sendEmailWithInlineContent")
    public String sendMailWithInlineContent(@ModelAttribute MailInfo info) throws MessagingException {
        service.sendMailWithInlineContent(info);
        System.out.println("3rd Page : CHART SENT ON MAIL");
        return "contactPage";
    }
}
