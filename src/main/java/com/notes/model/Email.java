package com.notes.model;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Email {
    @Autowired
    Environment env;

    private static final String MAIL_HOST = "smtp.gmail.com";
    private static final String MAIL_SUBJECT = "Task completed";
    private static final String MAIL_TEXT = "This email sent via http://best-notes.herokuapp.com\n" +
        "Project source code available on https://github.com/SolidaSlOl/notes\n" +
        "My CV https://drive.google.com/open?id=0B9Zt8VTdbQrCSEpkV1hFMFMyanM";
    private static final String USERNAME = "task.notes.test";
    private static final String PASSWORD = "notestest";
    private static final String FROM = "task.notes.test@gmail.com";

    public final void send(final String receiver) throws MessagingException {
        final Properties props = this.properties(MAIL_HOST);
        final Session session = this.sessiion(props);
        Transport.send(this.message(session, receiver));
    }

    private Message message(final Session session, final String receiver) throws MessagingException{
        final Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(receiver));
        message.setSubject(MAIL_SUBJECT);
        message.setText(MAIL_TEXT);
        return message;
    }

    private Session sessiion(final Properties props) {
        return Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
    }

    private Properties properties(final String host) {
        final Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        return props;
    }
}
