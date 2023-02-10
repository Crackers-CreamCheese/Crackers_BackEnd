package com.creamcheese.crackers.global.exception.CustomException;

import static com.creamcheese.crackers.global.constant.ResponseConstant.DUPLICATE_EMAIL;

public class EmailDuplicateException extends IllegalArgumentException{
	public EmailDuplicateException() {
		super(DUPLICATE_EMAIL);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
