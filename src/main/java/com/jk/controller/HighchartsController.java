package com.jk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.RoleAndUser;
import com.jk.model.User;
import com.jk.service.highcharts.HighchartsService;
import com.jk.util.Json;

@Controller
@RequestMapping("highchartsController")
public class HighchartsController extends BaseController{

	@Autowired
	private HighchartsService highchartsService;
	
	@RequestMapping("findUserCreateTime")
	public void findUserCreateTime(HttpServletResponse response){
		Json j=new Json();
		List<User> list=new ArrayList<>();
		try {
			list=highchartsService.findUserCreateTime();
			j.setSuccess(true);
			j.setObject(list);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("装逼失败");
		} 
		super.writeJson(j, response);
	}
	/**
	 * <pre>getData(用户角色分布报表)   
	 */
	   @RequestMapping("getData")
	    public void getData(HttpServletResponse response){
		   Json j=new Json();
		   List<RoleAndUser> list = null;
			try {
				 list = highchartsService.selectWorkloadAnalysis();
				 j.setSuccess(true);
				 j.setObject(list);
			} catch (Exception e) {
				e.printStackTrace();
				j.setSuccess(false);
				j.setMsg("失败");
			}
	        super.writeJson(j, response);
	   }
	   
	   
}
