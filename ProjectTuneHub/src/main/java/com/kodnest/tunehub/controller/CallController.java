package com.kodnest.tunehub.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CallController {

	@GetMapping("/call")
	public String call(){
		System.out.println("call received by the back end");
		return "call received";
	}

	@PostMapping("/testpost")
	public String testPost(@RequestBody String data) {
		System.out.println("Post request received: "+data);
		return "success";
	}
	
	@PostMapping("/testform")
	public String testForm(@RequestBody String formdata) {
		System.out.println("Post form request received: "+formdata);
		return "success form";
	}
	
}
