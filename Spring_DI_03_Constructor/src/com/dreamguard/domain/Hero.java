package com.dreamguard.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Hero {
	private int id;
	private String name;
	private List<String> jobs;
	
	private Dog dog;
	private Cat cat;
	
	
	
	public Hero(int id, String name, List<String> jobs, Dog dog, Cat cat) {
		super();
		this.id = id;
		this.name = name;
		this.jobs = jobs;
		this.dog = dog;
		this.cat = cat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getJobs() {
		return jobs;
	}
	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", jobs=" + jobs
				+ ", dog=" + dog + ", cat=" + cat + "]";
	}
	
}
