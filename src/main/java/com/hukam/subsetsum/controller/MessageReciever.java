package com.hukam.subsetsum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hukam.subsetsum.bean.Message;
import com.hukam.subsetsum.logic.SubsetSumLogic;
import com.hukam.subsetsum.repository.MessageRepository;

@Controller
public class MessageReciever {

	@Autowired
	SubsetSumLogic subsetsumlogic;

	@Autowired
	MessageRepository repository;

	String history = "";

	@GetMapping("/input")
	public String sendForm(Message messages) {
		return "inputArray";
	}

	@PostMapping("/input")
	public String processForm(Message message) {
		message.setOutput(subsetsumlogic.processInput(message.getInput(), message.getSum()));
		repository.findAll().forEach(x -> {
			history = history.concat("<br />").concat("Input : " + x.getInput() + "<br /> Output: ")
					.concat(x.getOutput());
		});
		repository.save(message);
		String outputWithHistory = message.getOutput().concat("<br /> History of Messages :" + "<br /" + history);
		message.setOutput(outputWithHistory);
		return "showMessage";
	}

	@PostMapping("/error")
	public String processError(Message message) {
		return "showError";

	}

}
