package net.madhwang.timecard.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Alias("member")
@Data
public class Member implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7496796765052686261L;
	private String memberNo;
	private String memberName;
	private String memberPassword;
	private TimeRecord timeRecord;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.getMemberPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getMemberName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
