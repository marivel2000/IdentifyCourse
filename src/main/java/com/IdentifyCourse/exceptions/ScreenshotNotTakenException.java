package com.IdentifyCourse.exceptions;

/***********Exception for Screenshot*********/

@SuppressWarnings("serial")
public class ScreenshotNotTakenException extends Exception{
	public ScreenshotNotTakenException(String message) {
		super(message);
	}
}

