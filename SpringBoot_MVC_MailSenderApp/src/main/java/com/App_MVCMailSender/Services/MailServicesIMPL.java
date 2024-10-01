package com.App_MVCMailSender.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.core.io.ClassPathResource;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import java.io.File;
import com.App_MVCMailSender.Model.MailInfo;

@Service
public class MailServicesIMPL implements MailServices {
    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendMail(MailInfo info) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(info.getFrom());
        msg.setTo(info.getTo());
        msg.setSubject(info.getSub());
        msg.setText(info.getText());

        sender.send(msg);
    }

    @Override
    public void sendMailWithAttachment(MailInfo info, File attachment) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        String fromAddress = info.getFrom();
        if (fromAddress == null || fromAddress.isEmpty()) {
            fromAddress = "shubhamkaviskar@gmail.com"; // Set your default email address here
        }
        helper.setFrom(fromAddress);
        helper.setTo(info.getTo());
        helper.setSubject(info.getSub());
        helper.setText(info.getText());

        FileSystemResource file = new FileSystemResource(attachment);
        helper.addAttachment(file.getFilename(), file);

        sender.send(message);
    }

    @Override
    public void sendMailWithInlineContent(MailInfo info) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        String fromAddress = info.getFrom();
        if (fromAddress == null || fromAddress.isEmpty()) {
            fromAddress = "shubhamkaviskar@gmail.com"; // Set your default email address here
        }
        helper.setFrom(fromAddress);
        helper.setTo(info.getTo());
        helper.setSubject(info.getSub());

        // Prepare the HTML content
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<h1>Hello</h1>")
                   .append("<p>This is an email with an inline image, a chart, and a table.</p>")
                   .append("<p><img src='image1'></p>")
                   .append("<p><b>Table:</b><br>")
                   .append("<table border='1'>")
                   .append("<tr><th>Roll No</th><th>Address</th><th>Marks</th><th>Mobile No</th><th>Name</th></tr>")
                   .append("<tr><td>1</td><td>Pune</td><td>95</td><td>8788229973</td><td>Shubham</td></tr>")
                   .append("<tr><td>2</td><td>Pune</td><td>90</td><td>8788229973</td><td>Drago</td></tr>")
                   .append("<tr><td>3</td><td>Pune</td><td>95</td><td>985654785</td><td>Shubh</td></tr>")
                   .append("<tr><td>4</td><td>Pune</td><td>89.2</td><td>1111111111</td><td>Draken</td></tr>")
                   .append("<tr><td>5</td><td>Pune</td><td>99</td><td>8788229973</td><td>Dummy</td></tr>")
                   .append("</table></p>");
        
        helper.setText(htmlContent.toString(), true);

        // Inline image and chart
        ClassPathResource image = new ClassPathResource("static/Youtube-logo.png"); // Your inline image path
        helper.addInline("image1", image);
        
        ClassPathResource chart = new ClassPathResource("static/pngegg.png"); // Your inline chart path
        helper.addInline("chart1", chart);

        sender.send(message);
    }
}
