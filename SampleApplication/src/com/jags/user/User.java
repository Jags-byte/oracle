package com.jags.user;

public class User {
	private double userId;
	private String namme;
	private int age;
	
	
	public User(String namme, int age) {
		this.userId = Math.random();
		this.namme = namme;
		this.age = age;
	}
	/**
	 * @return the userId
	 */
	public double getUserId() {
		return userId;
	}
	
	/**
	 * @return the namme
	 */
	public String getNamme() {
		return namme;
	}
	/**
	 * @param namme the namme to set
	 */
	public void setNamme(String namme) {
		this.namme = namme;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", namme=");
		builder.append(namme);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
