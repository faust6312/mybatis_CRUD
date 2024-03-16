package com.pzhu.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data

public class Student {
	private int id;
	private String name;
	//关联一个老师
	private Teacher teacher;
}
