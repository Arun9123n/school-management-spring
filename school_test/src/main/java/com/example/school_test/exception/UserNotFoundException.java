package com.example.school_test.exception;


public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
      super(message);
   }
}


