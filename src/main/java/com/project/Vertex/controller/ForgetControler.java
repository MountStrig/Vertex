package com.project.Vertex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgetControler {
	
	@GetMapping("/forgetPassword")
	public String forget() {
		return "forget";
	}
}
