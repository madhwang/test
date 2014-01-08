package net.madhwang.timecard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberListController {

	@RequestMapping(value = "MemberList")
	public String memberList() {

		return "memberList";
	}
}
