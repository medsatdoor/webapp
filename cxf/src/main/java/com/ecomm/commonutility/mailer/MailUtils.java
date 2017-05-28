package com.ecomm.commonutility.mailer;

import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import com.ecomm.commonutility.logger.EcommLogger;

/**
 * ******************************************** CUSTOMIZATION ****************************************
 * - Google has blocked the mailing services to be accessed from any external applications 
 * - which can not login the accounts with the user name and passwords for security purposes. 
 * - The accounts to be used for such services need to allow "less secure apps" to
 * - allow such access - On running the following code snippet a mail will be sent
 * - to the sender's inbox raising - a security alert with the subject 
 * - Review blocked sign-in attempt 
 * - and a link to allow access - allowing access to less secure apps 
 * - After clicking the link turn on the option for - "Allow less secure apps: OFF" 
 * - Now the following code will work for the gmail account for mailing services
 * ***************************************************************************************************
 * */
public class MailUtils {

	private static String AUTH_USER;
	private static String AUTH_PASSWORD;
	private static Properties props;

	public MailUtils(String AUTH_USER, String AUTH_PASSWORD, Properties props) {
		
		// set Google authenticated users and passwords 
		this.AUTH_USER = AUTH_USER;
		this.AUTH_PASSWORD = AUTH_PASSWORD;
		
		// set properties of mail transport
		MailUtils.props = props;
	}

	/**
	 * Try the following : < checked with group@gmail.com as fdtapan349paul@gmail.com >
	 * MailUtils.sendMail("Subject", "message", "group@gmail.com", "your-mail@gmail.com");
	 * */
	public static boolean sendMail(String subject, String msg, String sender, String to) throws Exception {

		EcommLogger.debug("Mail SMTP Properties = "+props);
		
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(AUTH_USER, AUTH_PASSWORD);
				}
			}
		);

		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(msg);
			Transport.send(message);
			EcommLogger.info("MAIL SENT TO..."+to);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
