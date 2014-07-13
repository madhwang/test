package net.madhwang.timecard.api.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;

import net.madhwang.timecard.dao.MemberDAO;
import net.madhwang.timecard.dao.TimeRecordDAO;
import net.madhwang.timecard.dao.TimeStatsDAO;
import net.madhwang.timecard.model.Member;
import net.madhwang.timecard.model.TimeRecord;
import net.madhwang.timecard.model.TimeStats;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class TimeCardAuthContorller {

	@Inject
	private MemberDAO memberDAO;

	@Inject
	private TimeRecordDAO timeRecordDAO;

	@Inject
	private TimeStatsDAO timeStatDAO;

	@RequestMapping("/authConfirm")
	public String authRequestReceive(final ServletRequest req, final String memberNo, final String passwd, final Model model) throws NoSuchAlgorithmException {

		String resultMsg = "fail";
		if (StringUtils.isNotEmpty(memberNo) == true && StringUtils.isNotEmpty(passwd) == true) {
			final Member member = memberDAO.selectOneByMemberNo(memberNo);

			if (memberNo.equals(member.getMemberNo()) == true && StringUtils.equals(member.getMemberPassword(), passwd) == true) {
				resultMsg = "success";
			}
		}
		model.addAttribute("resultMsg", resultMsg);
		return "AuthConfirm";
	}

	@RequestMapping("/dailyRecords")
	public String dailyRecords(final Integer year, final Integer month, final String memberNo, final Model model) throws JsonGenerationException, JsonMappingException, IOException {

		if (year == null || month == null || StringUtils.isEmpty(memberNo) == true) {
			return null;
		}

		List<TimeRecord> timeRecords = timeRecordDAO.selectRecordsOfMember(year, month, memberNo);
		if (CollectionUtils.isEmpty(timeRecords) == true) {
			return null;
		}
		ObjectMapper m = new ObjectMapper();
		String jsonDailyRecords = m.writeValueAsString(timeRecords);

		return jsonDailyRecords;
	}

	@RequestMapping("/monthlyRecords")
	public String monthlyRecords(final Integer year, final String memberNo, final Model model) throws JsonGenerationException, JsonMappingException, IOException {
		if (year == null || StringUtils.isEmpty(memberNo) == true) {
			return null;
		}

		List<TimeStats> timeStatList = timeStatDAO.selectYearStatsOfMember(year, memberNo);

		if (CollectionUtils.isEmpty(timeStatList) == true) {
			return null;
		}
		ObjectMapper m = new ObjectMapper();
		String jsonMonthlyRecords = m.writeValueAsString(timeStatList);

		return jsonMonthlyRecords;
	}
}
