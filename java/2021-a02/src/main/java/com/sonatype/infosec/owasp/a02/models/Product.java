package com.sonatype.infosec.owasp.a02.models;

public class Product {
	String name;
	String description;
	
	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}
