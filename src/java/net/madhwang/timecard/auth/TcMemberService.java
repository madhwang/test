package net.madhwang.timecard.auth;

import javax.inject.Inject;

import net.madhwang.timecard.dao.MemberDAO;
import net.madhwang.timecard.model.Member;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("tcMemberService")
public class TcMemberService implements UserDetailsService {

	@Inject
	private MemberDAO memberDAO;

	@Inject
	private StandardPasswordEncoder standardPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(final String memberNo) throws UsernameNotFoundException {

		Member member = memberDAO.selectOne(memberNo);
		member.setMemberPassword((standardPasswordEncoder.encode(member.getPassword())));

		return member;
	}
}