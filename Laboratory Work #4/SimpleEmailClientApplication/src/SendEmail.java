import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import java.util.Properties;

public class SendEmail {
    public static void main(String args[]) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("test@gmail.com"));;
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("address@gmail.com", false));
        message.setSubject("Laboratory Work 3");
        message.setText("Here I send Email");
        message.setHeader("Mail", "Mail");
        message.setSentDate(new Date());
        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "test@gmail.com", "password");
        t.sendMessage(message, message.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
    }
}
