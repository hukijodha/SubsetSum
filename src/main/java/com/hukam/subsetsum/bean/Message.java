package com.hukam.subsetsum.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Message {
	
	@NotNull
	@NotEmpty 
	String input;
	
	@Min(value=0)
	int sum;
	String output;
	

	public String getOutput() {
		return output;
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}
