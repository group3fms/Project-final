package com.cg.flightmgmt.exception;

public class InvalidUserException extends RuntimeException{
public InvalidUserException(String str)
{
	super(str);
}
public InvalidUserException(RuntimeException e)
{
	e.printStackTrace();
}
}
