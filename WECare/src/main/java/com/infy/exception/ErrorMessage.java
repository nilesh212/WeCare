package com.infy.exception;

import java.util.List;

public class ErrorMessage {

	private int errorCode;
	private List<String> messages;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	
	
}
