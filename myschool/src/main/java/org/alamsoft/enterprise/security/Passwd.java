package org.alamsoft.enterprise.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Passwd {

	public static void main(String[] args) {
		//String encoded = new BCryptPasswordEncoder().encode("test");
		String encoded = new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return null;
			}
		};().encode("test");
		System.out.println(encoded);
		

	}

}
