package com.example.VFSS.exception;

public class InvalidPagenationException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  public  InvalidPagenationException(String message) {
	  super(message);
  }
}
