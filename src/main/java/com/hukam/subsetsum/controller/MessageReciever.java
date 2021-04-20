package com.hukam.subsetsum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hukam.subsetsum.bean.Message;
import com.hukam.subsetsum.logic.SubsetSumLogic;

@Controller
public class MessageReciever {

	@Autowired
	SubsetSumLogic subsetsumlogic;

	@GetMapping("/input")
	public String sendForm(Message messages) {
		return "inputArray";
	}

	@PostMapping("/input")
	public String processForm(Message message) {
		message.setOutput(subsetsumlogic.processInput(message.getInput(), message.getSum()));
		return "showMessage";
	}
	
	@PostMapping("/error")
	public String processError(Message message)
	{
		return "showError";
		
	}

}
