package red.story.story;

import red.story.story.service.EmailSender;

import javax.mail.MessagingException;

public class T1118A {
    public static void main(String[] args) throws MessagingException {
        EmailSender.getEmailSender().sendEmail("story.red@foxmail.com","hello");
    }
}
