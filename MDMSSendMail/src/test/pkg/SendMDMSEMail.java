package test.pkg;
//Java program to send email

import java.util.Properties;



import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMDMSEMail {

		public static void MailDetail(StringBuilder sb)
		//public static void MailDetail()
	   {   
	      // email ID of Recipient.
			
		  String recipient1 = "agarwal2.gaurav@cris.org.in";
		  String recipient2 = "anshul@cris.org.in";
		  
		  //String ccRecipient1 = "amitsingh.dvp@gmail.com";
		  //String ccRecipient2 = "ritujoshiji@gmail.com";
		  String ccRecipient1 = "kumari.shilpi@cris.org.in";
		  String ccRecipient2 = "agarwal2.gaurav@cris.org.in";
		  
		  
		 // message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abc@abc.com,abc@def.com,ghi@abc.com"));

		 // message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("abc@abc.com,abc@def.com,ghi@abc.com"));
		  
	      // email ID of  Sender.
	      String sender = "mdmsadmin@cris.org.in";
	 
	      // using host as localhost
	      String host = "10.77.32.47";
	 
	      // Getting system properties
	      Properties properties = System.getProperties();
	 
	      // Setting up mail server
	      properties.setProperty("mail.smtp.host", host);
	 
	      // creating session object to get properties
	      Session session = Session.getDefaultInstance(properties);
	 
	      try
	      {
	         // MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From Field: adding senders email to from field.
	         message.setFrom(new InternetAddress(sender));
	 
	         // Set To Field: adding recipient's email to from field.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient1));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient2));
	         message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccRecipient1));
	         message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccRecipient2));
	         
	         // Set Subject: subject of the email
	         message.setSubject("Welcome to MDMS Monitoring Test E-mail");
	         String emailBody=(String) sb.toString();
	 
	         // set body of the email.
	        // message.setText("This is a test mail");
	         message.setText(emailBody);
	 
	         // Send email.
	         Transport.send(message);
	         System.out.println("Mail successfully sent");
	      }
	      catch (MessagingException mex)
	      {
	         mex.printStackTrace();
	      }
	   }
}
