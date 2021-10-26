package com.bankapp.demo.exception;

public class InavalidAccountException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InavalidAccountException(String message) {
		super(message);

	}

	public InavalidAccountException(String message, Throwable t) {
		super(message, t);

	}

}
