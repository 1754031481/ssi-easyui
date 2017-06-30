package com.jk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jk.model.Resources;
import com.jk.model.Tree;
import com.jk.service.TreeService;

@Controller
@RequestMapping("/tree")
public class TreeController extends BaseController{
//	日志打印
	private  static final Logger logger=Logger.getLogger(TreeController.class);
	
	@Autowired
	private TreeService treeService;
//	导航的tree --旧版
	@RequestMapping("treeList")
	public void treeList(int pid,HttpServletResponse response) throws Exception{
		Tree tree = new Tree();
		tree.setMenuId(pid);
		List<Tree> treeList = treeService.treeList(tree);
		List<Map> mapList=new ArrayList<Map>();
		for (int i = 0; i < treeList.size(); i++) {
			Tree tree2 = treeList.get(i);
			HashMap<String, Object> mapss=new HashMap<String, Object>();
			mapss.put("id", tree2.getMenuId());
			mapss.put("text", tree2.getMenuTitle());
			mapss.put("pid", tree2.getParentId());
			mapss.put("url", tree2.getMenuUrl());
			mapss.put("iconCls", tree2.getMenuIcon());
			mapss.put("state", treeService.findTreeCount(tree2.getMenuId())>0?"closed":"open");
			mapList.add(mapss);
		} 
		super.writeJson(mapList, response);
	}
//	资源管理 树形展示
	@RequestMapping("showResourcesRight")
	public void showResourcesRight(Resources resources,HttpServletResponse response) {
		Set<Resources> showResourcesRight=new HashSet<>();
		try {
			  showResourcesRight = treeService.showResourcesRight(resources);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.writeJson(showResourcesRight, response);
	}
//	导航栏的tree
	@RequestMapping("newTreeList")
	public void newTreeList(Resources resources,HttpServletResponse response){
		
		Set<Resources> showResources=new HashSet<>();
		try {
			showResources = treeService.showResources(resources);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.writeJson(showResources, response);
	}

//	添加 or 回显
	@RequestMapping("addResources")
	public void addResources(Resources resources,HttpServletResponse response){
		try {
			if(null!=resources.getId() && !resources.getId().equals("")){
				treeService.updateResources(resources);
			}else{
				treeService.addResources(resources);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	dialog添加资源 or 回显
	@RequestMapping("toAddResources")
	public ModelAndView toAddResources(Resources resources,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		if(null!=resources.getId()){
			try {
				resources=treeService.showResoId(resources);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mv.addObject("resources",resources);
		}
		mv.setViewName("WEB-INF/resources/addResources");
		return mv;
	}
	
//删除
	@RequestMapping("deleteResources")
	public void  deleteResources(String ids,HttpServletResponse response){
		try {
			treeService.deleteResources(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
//	查询资源类型表
	@RequestMapping("queryResourcesType")
	public void queryResourcesType(HttpServletResponse response){
		List<Map> queryResourcesType =new ArrayList<>();
		try {
			queryResourcesType= treeService.queryResourcesType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.writeJson(queryResourcesType, response);
	}
	

}
