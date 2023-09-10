package org.example;

import org.json.JSONObject;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
	public void sendMail(Cat catObj){
		//properties
		Properties sysPropertiesMap = System.getProperties();
		sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com");//smtp server
		sysPropertiesMap.put("mail.smtp.port","465");//server port
		sysPropertiesMap.put("mail.smtp.ssl.enable","true");//ssl-secure socket layer
		sysPropertiesMap.put("mail.smtp.auth","true");//authentication

		//authentication
		Authenticator mailAuthenticator = new CustomizedMailAuthenticator();
		Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);

		//build the mail
		//--> mime object
		MimeMessage mailMessage = new MimeMessage(mailSession);
		try {
			JSONObject jsonAPIResponse = new JSONObject(catObj);
			mailMessage.setFrom(MailConstants.SENDER);
			mailMessage.setSubject("Cat Object");
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailConstants.RECIPIENT));
			mailMessage.setText(jsonAPIResponse.toString());

			Transport.send(mailMessage);
		}catch (Exception e){
			System.out.println("Some error while preparing mail body");
			System.out.println(e.getMessage());
		}
	}
}
