package com.codechallenge.domain;

import java.io.Serializable;

public class SecurityQuestionRequest  implements Serializable{

	private static final long serialVersionUID = 1L;

	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
