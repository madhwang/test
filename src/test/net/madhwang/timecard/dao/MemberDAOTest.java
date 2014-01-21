package net.madhwang.timecard.dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-root-context.xml" })
public class MemberDAOTest {

	@Inject
	private MemberDAO memberDAO;

	@Test
	public void testSelectOne() {
		System.out.println(memberDAO.selectOne("1"));
	}

}
