package io.workspace.SpringBoot_EmailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.workspace.SpringBoot_EmailService.Configuration.FetchEmailConfiguration;
import io.workspace.SpringBoot_EmailService.EmailModel.CustomerMessage;
import io.workspace.SpringBoot_EmailService.Exceptions.EmailSendingException;

@RestController
@RequestMapping("/message")
public class CutomerMessageController {
	
	
	private FetchEmailConfiguration fetchEmailConfiguration;
	
	public CutomerMessageController(FetchEmailConfiguration fetchEmailConfiguration) {
		this.fetchEmailConfiguration=fetchEmailConfiguration;
	}

	@PostMapping("/send")
	public void sendFeedback(@RequestBody CustomerMessage customerMessage,BindingResult bindingResult) throws EmailSendingException {
		
		if(bindingResult.hasErrors()) {
			throw new EmailSendingException();
		}
		
		//create mail sender:
		
		JavaMailSenderImpl mailer=new JavaMailSenderImpl();
		
		mailer.setHost(fetchEmailConfiguration.getHost());
		mailer.setPort(fetchEmailConfiguration.getPort());
		mailer.setUsername(fetchEmailConfiguration.getUsername());
		mailer.setPassword(fetchEmailConfiguration.getPassword());
		
		
		//java mail instance
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setFrom(customerMessage.getEmailAddress());
		simpleMailMessage.setTo("test@cutstomer-inputs.com");
		simpleMailMessage.setSubject("New Customer Inputs From :"+customerMessage.getUser().toUpperCase());
		simpleMailMessage.setText(customerMessage.getTodo()+";\nPriority:"+customerMessage.getPriority()+";\nRating:"+customerMessage.getRating());
		
		//send mail
		mailer.send(simpleMailMessage);
	}
}
