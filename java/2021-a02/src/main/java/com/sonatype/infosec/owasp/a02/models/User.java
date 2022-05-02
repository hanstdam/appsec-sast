package com.sonatype.infosec.owasp.a02.models;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends BasicUser {
	String plainTextPassword;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHashedPassword() throws NoSuchAlgorithmException {
		// CWE-327: Use of a Broken or Risky Cryptographic Algorithm
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(plainTextPassword.getBytes());
	    byte[] digest = md.digest();
	    return String.format("%032x", new BigInteger(1, digest)).toUpperCase();
	}
	
	public void setPassword(String plainTextPassword) {
		this.plainTextPassword = plainTextPassword;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public BasicUser toBasic() {
		BasicUser basic = new BasicUser();
		basic.setUsername(username);
		basic.setAge(age);
		return basic;
	}
}
