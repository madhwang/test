package net.madhwang.timecard.controller;

import java.util.List;

import javax.inject.Inject;

import net.madhwang.timecard.dao.TimeRecordDAO;
import net.madhwang.timecard.dao.TimeStatDAO;
import net.madhwang.timecard.model.Member;
import net.madhwang.timecard.model.TimeRecord;
import net.madhwang.timecard.model.TimeStat;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberInfoController {

	@Inject
	private TimeStatDAO timeStatDAO;

	@Inject
	private TimeRecordDAO timeRecordDAO;

	private Member loginMember() {
		return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@RequestMapping("/MyInfo/{year}")
	public String myInfoOfYear(@PathVariable final Integer year, final Model model) {
		Member member = this.loginMember();
		List<TimeStat> timeStatsLst = timeStatDAO.selectYearStatsOfMember(year, member.getMemberNo());
		model.addAttribute("timeStatsLst", timeStatsLst);
		return "MyInfoOfYear";
	}

	@RequestMapping("/MyInfo/{year}/{month}")
	public String myInfoOfYearMonth(@PathVariable final Integer year, @PathVariable final Integer month, final Model model) {
		Member member = this.loginMember();
		List<TimeRecord> timeRecords = timeRecordDAO.selectRecordsOfMember(year, month, member.getMemberNo());
		model.addAttribute("timeRecords", timeRecords);
		return "MyInfoOfMonth";
	}
}
