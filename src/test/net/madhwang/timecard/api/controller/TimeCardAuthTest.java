package net.madhwang.timecard.api.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;

import net.madhwang.timecard.dao.TimeRecordDAO;
import net.madhwang.timecard.model.TimeRecord;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-root-context.xml" })
public class TimeCardAuthTest {

	@Test
	public void testHash() throws NoSuchAlgorithmException {
		final String message = "ttt";
		final MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		final byte[] result = mDigest.digest(message.getBytes());

		final StringBuffer sb = new StringBuffer();
		// result 를 문자열로
		for (final byte element : result) {
			sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
		}

		// message.getBytes();
		System.out.println("result = " + sb.toString());
	}

	@Inject
	private TimeRecordDAO timeRecordDAO;

	@Test
	public void testRecords() throws JsonGenerationException, JsonMappingException, IOException {
		final List<TimeRecord> timeRecords = this.timeRecordDAO.selectRecordsOfMember(2014, 1, "1");
		final ObjectMapper m = new ObjectMapper();
		final String json = m.writeValueAsString(timeRecords);
		System.out.println(json);

	}
}
