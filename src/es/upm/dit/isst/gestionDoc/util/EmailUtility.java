package es.upm.dit.isst.gestionDoc.util;
 
import java.util.Date;
import java.util.Properties;
 

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailUtility {
    public static void sendEmail(String port,
            final String userName, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host","localhost");
        properties.put("mail.smtp.port", 2525);
//        properties.put("mail.smtp.auth", "false");
//        properties.put("mail.smtp.starttls.enable", "false");
 
//        // creates a new session with an authenticator
//        Authenticator auth = new Authenticator() {
//            public PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("root", "root");
//            }
//        };
 
//        Session session = Session.getInstance(properties,auth);
        Session session = Session.getInstance(properties);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
}
