package com.jk.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jk.model.User;
import com.jk.util.Page;

/**
 * 类名称：UserDao    
 * 类描述：			ssi单表  增删改查    
 * 创建时间：2017年5月18日 下午4:41:13    
 * @version </pre>
 */

public interface UserDao {
//	单查询
	public List<User> userList(User user) throws Exception;
//	添加
	public void insertUser(User user) throws SQLException;
//	单个删除
	public void deleteUser(User user) throws SQLException;
//	修改
	public void updateUser(User user) throws SQLException;
//	批量删除
	public void deleteUsers(List<Integer> list) throws Exception;
//	分页
	public List<User> pageUser(Map<String, Object> parmes) throws Exception;
//	总条数	
	public Long countUser(Map<String,Object> parmes) throws Exception;
//	回显
	public User showById(User user) throws Exception;
//	用户登录
	public User login(User user) throws Exception;
//	根据id查询

	
}
