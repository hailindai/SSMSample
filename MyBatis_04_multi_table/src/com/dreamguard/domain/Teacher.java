package com.dreamguard.domain;

import java.util.List;

public class Teacher {
	private int id;
	private String name;
	private List<Stu> list;
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
	public List<Stu> getList() {
		return list;
	}
	public void setList(List<Stu> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
	
}
