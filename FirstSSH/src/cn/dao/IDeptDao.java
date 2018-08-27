package cn.dao;

import java.util.List;

import cn.entity.Dept;

/**
 * 
 * 部门模块dao接口设计
 * @author Administrator
 * 
 * */

public interface IDeptDao {

	//查询全部
	List<Dept> getAll();
	//根据主键查询
	Dept findById(int id);
}
