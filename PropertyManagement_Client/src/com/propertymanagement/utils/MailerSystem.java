package com.propertymanagement.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class MailerSystem {
	String d_email = "cmpe275.projecthomeforsale@gmail.com",
			d_password = "project275", d_host = "smtp.gmail.com",
			d_port = "465", m_to = " ", m_subject = "Requested details",
			m_text = "Requested details \n";

	String ret = null;

	public String mail(String tomail, String pass) {
		m_to = tomail;
		System.out.println("Details are mailed to " + m_to + " and the body has the detail " + pass);
		m_text = m_text + " " + pass;
		Properties props = new Properties();
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(m_text);
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(m_to));
			Transport.send(msg);

			return ("OK");
		} catch (Exception mex) {
			mex.printStackTrace();
			return ("SORRY");
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(d_email, d_password);
		}
	}
	
	public static void main(String[] args) {
		new MailerSystem().mail("harshad.rane89@gmail.com", "Hii Kishen");
	}

}
