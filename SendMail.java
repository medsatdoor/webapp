package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * ********************************************  CUSTOMIZATION  ****************************************
 * - Google has blocked the mailing services to be accessed from any external applications
 * - which can not login the accounts with the user name and passwords for security purposes.
 * - In account to be used for such services needs to allow less secure apps to allow such access
 * - On running the following code snippet a mail will be sent to the sender's inbox raising 
 * - a security alert with the subject - Review blocked sign-in attempt
 * - and a link to allow access -  allowing access to less secure apps
 * - After clicking the link turn on the option for - "Allow less secure apps: OFF"
 * - Now the following code will work for the gmail account for mailing services
 * *****************************************************************************************************
 * */
public class SendMail {

	final String username;
	final String password;
	
	public SendMail(String username,String password){
	    this.username = username;
	    this.password = password;

	}

	public boolean sendMail(String subject, String msg, String sender, String cc, String to) throws Exception {
		Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	      });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(sender));
	        message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));
	        message.setSubject(subject);
	        message.setText(msg);

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
		return false;
	}

	
	public static void main(String a[]) throws Exception {
		SendMail m = new SendMail("fdtapan349paul@gmail.com", "newpasswordisiamtapan");
		m.sendMail("Subject", "message", "fdtapan349paul@gmail.com", "kaustab.paul93@gmail.com", "fdtapan349paul@gmail.com");
	}

}
