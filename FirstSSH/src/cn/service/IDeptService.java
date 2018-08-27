package cn.service;

import java.util.List;

import cn.entity.Dept;

/**
 * 部门模块业务逻辑层接口
 * @author Administrator
 * 
 * */
public interface IDeptService {
	//查询全部
	List<Dept> getAll();
	//根据主键查询
	Dept findById(int id);
}
