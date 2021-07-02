package com.abinanth.exception;

public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException(String message) {
		super(message);
	}

	public DBException(Exception e, String message) {
		super(message, e);
	}
}
