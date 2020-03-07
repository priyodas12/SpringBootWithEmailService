package io.workspace.SpringBoot_EmailService.EmailModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class CustomerMessage {
	
	@NotNull
	private String user;
	
	@NotNull
	@Email
	private String emailAddress;
	
	@NotNull
	@Max(20)
	private String todo;
	
	@NotNull
	private String priority;
	
	@NotNull
	private float rating;

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
	
}
