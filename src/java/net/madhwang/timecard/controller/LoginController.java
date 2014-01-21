package net.madhwang.timecard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = "/LoginForm")
	public String loginForm() {

		return "login";
	}

}
