package com.jk.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.UserDao;
import com.jk.model.User;
import com.jk.util.Page;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> userList(User user) throws Exception {
		List<User> userList = userDao.userList(user);
		return userList;
	}

	@Override
	public void insertUser(User user) throws SQLException {
		userDao.insertUser(user);
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		userDao.deleteUser(user);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		
		 userDao.updateUser(user);
	}


	@Override
	public void deleteUsers(String ids) throws Exception {
		List<Integer> list=new ArrayList<>();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			if(null != split[i] && !"".equals(split[i])){
				list.add(Integer.valueOf(split[i].trim()));
			}
		}
		userDao.deleteUsers(list);
	}

	@Override
	public List<User> pageUser(User user, Integer page, Integer rows) throws Exception {
		Map<String, Object> parmes=new HashMap<>();
		parmes.put("name", user.getName());
		parmes.put("pwd", user.getPwd());
		parmes.put("startDate", user.getStartDate());
		parmes.put("endDate", user.getEndDate());
		parmes.put("page", (page-1)*rows);
		parmes.put("rows", rows);
		List<User> pageUser = userDao.pageUser(parmes);
		return pageUser;
	}

	@Override
	public Long countUser(User user) throws Exception {
		Map<String, Object> parmes = new HashMap<String, Object>();
		parmes.put("name", user.getName());
		parmes.put("startDate", user.getStartDate());
		parmes.put("endDate", user.getEndDate());
		Long count = userDao.countUser(parmes);
		return count;
	}

	@Override
	public User showById(User user) throws Exception {
		return userDao.showById(user);
	}

	@Override
	public User login(User user) throws Exception {
		return userDao.login(user);
	}

	

}
