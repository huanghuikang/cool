package cn.dao;

import java.util.List;

/**
 * 
 * 所有dao的通用操作接口定义
 * @author Administrator
 * 
 * */
public interface IBaseDao<T> {

	//保存
	void save(T emp);
	//更新对象信息
	void update(T emp);
	//根据主键删除
	void delete(int id);
	//根据主键查询
	T findById(int id);
	//查询全部
	List<T> getAll();
}
