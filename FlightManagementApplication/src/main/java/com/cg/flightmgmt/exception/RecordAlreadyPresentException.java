package com.cg.flightmgmt.exception;

public class RecordAlreadyPresentException extends RuntimeException {
	public RecordAlreadyPresentException(String str) {
		super(str);
	}
}
