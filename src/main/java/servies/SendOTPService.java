package servies;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class SendOTPService {
    public static void sentOTP(String email , String genOTP,String messageToSent){
    // Recipient's email ID needs to be mentioned.

// Sender's email ID needs to be mentioned
String from = "jeetkoursuri29@gmail.com";

 String host = "smtp.gmail.com";

// Get system properties
Properties properties = System.getProperties();

// Setup mail server

properties.put("mail.smtp.host", host);
properties.put("mail.smtp.port", "465");
properties.put("mail.smtp.ssl.enable", "true");
properties.put("mail.smtp.auth", "true");

final String password = "yddeppdftmwjavap";
// Get the Session object.// and pass username and password
Session session = Session.getInstance(properties,new Authenticator(){
    protected  PasswordAuthentication getPasswordAuthentication(){
    return new  PasswordAuthentication(from , password) ;
    }
});

// Used to debug SMTP issues
 session.setDebug(true);

        try {

// Create a default MimeMessage object.

        MimeMessage message = new MimeMessage(session);

// Set From: header field of the header.
message.setFrom(new InternetAddress(from));

// Set To: header field of the header.
message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

// Set Subject: header field
message.setSubject("Quiz Game OTP");

// Now set the actual message
message.setText(messageToSent+"\n"+"Your One time Password for File Enc app is "+genOTP);

        System.out.println("sending...");

// Send message

        Transport.send(message);

        System.out.println("Sent message successfully....");

        } catch (MessagingException mex) { mex.printStackTrace();

        }


        }
}
