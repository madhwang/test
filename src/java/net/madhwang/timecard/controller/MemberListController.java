package net.madhwang.timecard.controller;

import java.util.List;

import javax.inject.Inject;

import net.madhwang.timecard.dao.MemberDAO;
import net.madhwang.timecard.dao.TimeRecordDAO;
import net.madhwang.timecard.model.Member;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberListController {

	@Inject
	private MemberDAO memberDAO;

	@Inject
	private TimeRecordDAO timeRecordDAO;

	private Member loginMember() {
		return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@RequestMapping(value = "MemberList")
	public String memberList(@RequestParam(defaultValue = "1") final Integer page, final Model model) {

		int startRowNum = (page - 1) * 10;

		List<Member> members = memberDAO.selectListWithRecordTime(startRowNum);
		model.addAttribute("members", members);
		model.addAttribute("page", page);
		model.addAttribute("loginMember", this.loginMember());

		return "memberList";
	}

	@RequestMapping(value = "PunchIn")
	public String punchIn(@RequestParam(defaultValue = "1") final Integer page, final RedirectAttributes redirectAttrs, final Model model) {
		Member loginMember = this.loginMember();
		timeRecordDAO.insertOfPunchIn(loginMember.getMemberNo());
		redirectAttrs.addAttribute("page", page);

		return "redirect:/MemberList?page={page}";

	}
}
