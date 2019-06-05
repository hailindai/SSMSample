package com.dreamguard.domain;

import java.util.List;

public class Dept {
	private int id;
	private String name;
	private List<Emp> list;
	public Dept() {
	}
	public Dept(int id, String name, List<Emp> list) {
		this.id = id;
		this.name = name;
		this.list = list;
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
	public List<Emp> getList() {
		return list;
	}
	public void setList(List<Emp> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
}
