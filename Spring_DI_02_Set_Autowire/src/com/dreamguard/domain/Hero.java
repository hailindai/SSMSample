package com.dreamguard.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Hero {
	private int id;
	private String name;
	private List<String> jobs;
	private Set<String> set;
	private Map<String, String> map;
	private Properties prop;
	
	private Dog dog;
	private Cat cat;
	
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
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
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
				+ ", set=" + set + ", map=" + map + ", prop=" + prop + ", dog="
				+ dog + ", cat=" + cat + "]";
	}
	
}
