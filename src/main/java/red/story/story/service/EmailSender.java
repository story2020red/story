package red.story.story.service;

import com.sun.mail.util.MailSSLSocketFactory;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * 业务需要，一个邮件发送，，
 * 老账号story.red@foxmail.com被封了
 * story_red@foxmail.com
 * qnepkqwsjdateaad
 * @author storyRed
 */
public class EmailSender {
   private static EmailSender EMAIL_SENDER=null;

    static {
        try {
            EMAIL_SENDER = new EmailSender();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public static EmailSender getEmailSender() {
        return EMAIL_SENDER;
    }

    /**
     * 发件人
     *
     * */
    private final String from ="story2020@foxmail.com";
    /**
     * 授权码
     * */
    private final String emailAuth="djzaibhbxzivdajd";
//    private final String emailAuthIMAP="jnzgcnxlrqiwcjhh";

    private final String host="smtp.qq.com";
    Properties properties = System.getProperties();


    MailSSLSocketFactory mailSSLSocketFactory;
    private EmailSender() throws GeneralSecurityException {
        properties.setProperty("mail.smtp.host",host);
        properties.put("mail.smtp.auth",true);
        mailSSLSocketFactory=new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);

        properties.put("mail.smtp.ssl.enable",true);
        properties.put("mail.smtp.ssl.socketFactory",mailSSLSocketFactory);
    }

    public void sendEmail(String goalEmailAddr, String content) throws MessagingException {
        Session session=Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return  new PasswordAuthentication(from,emailAuth);
            }
        });
        MimeMessage mimeMessage=new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(from));
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(goalEmailAddr));
        mimeMessage.setSubject("story.red");
        mimeMessage.setText(content);
        Transport.send(mimeMessage);

    }
}
