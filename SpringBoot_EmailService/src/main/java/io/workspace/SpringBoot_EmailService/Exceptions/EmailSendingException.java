package io.workspace.SpringBoot_EmailService.Exceptions;

public class EmailSendingException extends Exception {
	
		public EmailSendingException() {
			System.out.println("Please check configuration details....");
		}
}
