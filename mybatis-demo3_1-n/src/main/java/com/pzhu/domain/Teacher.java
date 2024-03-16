package com.pzhu.domain;

import lombok.Data;

import java.util.List;

@Data

public class Teacher {

private int id;
private String name;
//一个老师多个学生
	private List<Student> students;
}
