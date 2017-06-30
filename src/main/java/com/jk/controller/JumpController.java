package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <zjb>项目名称：ssi-renrenwang    
 * 类名称：JumpController    
 * 类描述： 	这个controller只是提供了页面跳转   
 * 创建人：赵俊彪   
 * @version </pre>
 */

@Controller
@RequestMapping("jump")
public class JumpController extends BaseController{

//跳转注册时间分布--柱状图报表
	@RequestMapping("toCreateTime")
	public String toCreateTime(){
		return "/WEB-INF/highcharts/CreateTime";
	}
	
	
//跳转到用户角色分布饼状图报表
	@RequestMapping("toUserAndRole")
	public String toUserAndRole(){
		return "/WEB-INF/highcharts/roleAndUser";
	}
	
//	跳转到机构列表
	@RequestMapping("toShowMechanism")
	public String toShowMechanism(){
		return "/WEB-INF/mechanism/mechanism";
	}
	
//	tab跳转用户管理
	@RequestMapping("/toShowUser")
	public String toShowUser(){
		return "/WEB-INF/user/user";
	}
	
//	tab跳转资源管理
	@RequestMapping("toShowResources")
	public String toShowResources(){
		return "/WEB-INF/resources/resources";
	}
//	tab跳转角色管理
	@RequestMapping("toShowRole")
	public String toShowRole(){
		return "/WEB-INF/role/showRole";
	}
	

}
