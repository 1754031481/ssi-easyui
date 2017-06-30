package com.jk.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jk.model.User;
import com.jk.util.Page;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	@Qualifier("sqlMapClient")
	private SqlMapClient sqlMapClient;

//	查询
	@Override
	public List<User> userList(User user) throws Exception {
		List userList = sqlMapClient.queryForList("User.userList", user);
		return userList;
	}

//	新增
	@Override
	public void insertUser(User user) throws SQLException {
		 sqlMapClient.insert("User.insertUser", user);
	}

//	删除
	@Override
	public void deleteUser(User user) throws SQLException {
		sqlMapClient.delete("User.deleteUser", user);
	}

//	修改
	@Override  
	public void updateUser(User user) throws SQLException {
		sqlMapClient.update("User.updateUser", user);
	}


//	批量删除
	@Override
	public void deleteUsers(List<Integer> list) throws Exception {
		sqlMapClient.delete("User.deleteUsers", list);
	}
//分页
	@Override
	public List<User> pageUser(Map<String, Object> parmes) throws Exception {
		List queryForList = sqlMapClient.queryForList("User.pageUser", parmes);
		return queryForList;
	}

	
//	总条数
	@Override
	public Long countUser(Map<String, Object> parmes) throws Exception {
		
		return (Long) sqlMapClient.queryForObject("User.countUser", parmes);
	}

	
//	回显
	@Override
	public User showById(User user) throws Exception {
		return (User) sqlMapClient.queryForObject("User.showById", user);
	}
//	用户登录
	@Override
	public User login(User user) throws Exception {
		return (User) sqlMapClient.queryForObject("User.login", user);
	}


}
