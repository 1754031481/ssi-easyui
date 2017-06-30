package com.jk.controller;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.DataGrid;
import com.jk.util.Json;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController implements ServletContextAware{
	
	//日志打印
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	private ServletContext ServletContext;
	
	
//	用户登录
	@RequestMapping("/login")
	public void login(User user,HttpServletResponse response,HttpServletRequest request){
		Json j=new Json();
		try {
			User login = userService.login(user);
			request.getSession().setAttribute("user", login);
			if(null!=login){
				j.setSuccess(true);
				j.setMsg("登录成功！");
			}else{
				j.setSuccess(false);
				j.setMsg("用户名或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("登录失败");
		}
		super.writeJson(j, response);
	}
//	查询
	@RequestMapping("/userList")
	public void userList(User user,String q,HttpServletResponse response){
		Json j=new Json();
		List<User> userList=null;
		if(null!=q && !"".equals(q)){
			user.setName(q);
		}
		try {
			 userList = userService.userList(user);
			j.setSuccess(true);
			j.setObject(userList);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("由于网络问题，用户列表查询异常，请稍后再试");
		}
		super.writeJson(userList, response);
	}
//	分页查询
	@RequestMapping("/showPageUser")
	public void showPageUser(User user,String q,Integer page,Integer rows,String startTime,String endTime,HttpServletResponse response) throws Exception{
		DataGrid dataGrid = new DataGrid();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (null != startTime && !"".equals(startTime)) {
				user.setStartDate(sim.parse(startTime));
			}
			if (null != endTime && !"".equals(endTime)) {
				user.setEndDate(sim.parse(endTime));
			}
			if(null!=q && !"".equals(q)){
				user.setName(q);
			}
			List<User> pageUser = userService.pageUser(user, page, rows);
			 Long countUser = userService.countUser(user);
			dataGrid.setTotal(countUser);
			dataGrid.setRows(pageUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.writeJson(dataGrid, response);
	}
	
	
//	添加 or修改 or 添加图片
	@RequestMapping("insertUser")
	public void insertUser(User user,HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file) throws Exception{
		String path = this.ServletContext.getRealPath("/upload/");
		String fileName = file.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		String imgUrl = new Date().getTime() + fileType;
		File file2 = new File(path, imgUrl);

		if(null!=user.getId() && !user.getId().equals("")){
			file.getFileItem().write(file2);
			user.setImgname("/upload/" + imgUrl);

			user.setModifydatetime(new Date());
			userService.updateUser(user);
		}else{
			try {
				file.getFileItem().write(file2);
				user.setImgname("/upload/" + imgUrl);
				user.setCreatedatetime(new Date());
				user.setModifydatetime(new Date());
				userService.insertUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
//	dialog添加 or 回显
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(User user,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		if(user.getId()!=null){
		try {
			user = userService.showById(user);
				
			mv.addObject("user",user);
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
		mv.setViewName("/WEB-INF/user/addUser");
		return mv;
	}

	
//	批量删除
	@RequestMapping("deleteUser")
	public void deleteUser(String ids,HttpServletResponse response){
		try {
			userService.deleteUsers(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.ServletContext=servletContext;
	}

	

	

}
