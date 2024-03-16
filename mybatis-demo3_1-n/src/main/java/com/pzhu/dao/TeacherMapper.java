package com.pzhu.dao;

import com.pzhu.domain.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
//获取老师
List<Teacher> getTeacher();
//获取老师下所有学生及老师信息
	Teacher getTeacher( int id);
}
