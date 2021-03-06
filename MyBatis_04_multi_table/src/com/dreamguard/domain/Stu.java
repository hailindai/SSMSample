package com.dreamguard.domain;

import java.util.List;

public class Stu {
	private int id;
	private String name;
	private List<Teacher> list;
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
	public List<Teacher> getList() {
		return list;
	}
	public void setList(List<Teacher> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
}
