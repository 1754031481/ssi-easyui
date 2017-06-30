package com.jk.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.TreeService;
import com.jk.service.UserService;
import com.jk.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-ibatis.xml"})
public class UserTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TreeService treeService; 
	
//	查询
	@Test
	public void userList(){
		User user=new User();
		try {
			List<User> userList = userService.userList(user);
			System.out.println(JSON.toJSONStringWithDateFormat("我是查询到的数据="+userList, "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	分页查询
/*	@Test
	public void pageList() throws SQLException{
		User user =new User();
		Page pages=new Page();
		pages.setStart(0);
		pages.setPageSize(3);
		user.setName("111");
		List<User> pageList = userService.pageList(pages, user);
		System.out.println(JSON.toJSONStringWithDateFormat("我是分页"+pageList,"yyyy-MM-dd"));
	}*/
	
//	增加
	@Test
	public void insertUser(){
		User user=new User();
		
		try {
			user.setName("111");
			user.setPwd("222");
			user.setModifydatetime(new Date());
			user.setCreatedatetime(new Date());
			userService.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
//	删除
	@Test
	public void deleteUser(){
		User user=new User();
		try {
			user.setId(2);
			userService.deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	批量删除
	@Test
	public void deleteUsers(){
		try {
			userService.deleteUsers("10,11");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	修改
	@Test
	public void updateUser() throws Exception{
		User user =new User();
		try {
			user.setId(3);
			user.setName("999");
			user.setModifydatetime(new Date());
			user.setCreatedatetime(new Date());
			user.setPwd("888");
			userService.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	分页
	@Test
	public void pageUser(){
		User user=new User();
		try {
			List<User> pageUser = userService.pageUser(user, 1, 3);
			Long countUser = userService.countUser(user);
			System.out.println("每页展示数据" + JSON.toJSONStringWithDateFormat(pageUser, "yyyy-MM-dd HH:mm:ss"));
			System.out.println("用户总个数为" + countUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
