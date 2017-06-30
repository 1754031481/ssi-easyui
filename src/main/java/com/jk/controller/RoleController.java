package com.jk.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jk.model.Role;
import com.jk.service.role.RoleService;
import com.jk.util.DataGrid;

@Controller
@RequestMapping("role")
public class RoleController extends BaseController {
	
	@Autowired
	private RoleService roleService;
//	添加 or 修改
	@RequestMapping("insertRole")
	public void insertRole(Role role,HttpServletResponse response){
		try {
				if(role.getId()!=null){
					role.setUpdatedatetime(new Date());
					roleService.updateRole(role);
				}else{
					role.setCreatedatetime(new Date());
					role.setUpdatedatetime(new Date());
					roleService.insertRole(role);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
//	dialog 添加 or  回显
	@RequestMapping("toAddOrUpdateRole")
	public ModelAndView toAddOrUpdateRole(Role role,HttpServletResponse response,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		if(null!=role.getId()){
			try {
				role=roleService.findRoleById(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mv.addObject("role",role);
		}
		mv.setViewName("/WEB-INF/role/addRole");
		return mv;
	}
//删除
	@RequestMapping("deleteRole")
	public void deleteRole(String ids,HttpServletResponse response){
		try {
			roleService.deleteRole(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	分页查询角色
	@RequestMapping("showPageRole")
	public void showPageRole(Role role,Integer page,Integer rows,String QUERY_NAME ,HttpServletResponse response){
		DataGrid datagrid=new DataGrid();
		role.setName(QUERY_NAME);
		try {
			List<Role> showPageRole = roleService.showPageRole(role, page, rows);
			Long countRole = roleService.countRole(role);
			datagrid.setRows(showPageRole);
			datagrid.setTotal(countRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.writeJson(datagrid, response);
	}
	
//	角色授权跳转
	@RequestMapping("toRoleGrant")
	public String toRoleGrant(){
		return "/WEB-INF/role/roleGrant";
	}
}
