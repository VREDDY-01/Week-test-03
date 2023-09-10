package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
	//@Autowired annotation searches for any cat object present in Spring boot and connect it with this catObj Variable
	@Autowired
	Cat catObj;

	@GetMapping("api/getCat")
	public Cat getCat(){
		System.out.println("Starting to send mail");

		MailHandler mailHandler = new MailHandler();
		mailHandler.sendMail(catObj);

		System.out.println("Mail has been sent");
		return catObj;
	}
}
