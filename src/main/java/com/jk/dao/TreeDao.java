package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.Resources;
import com.jk.model.Tree;

public interface TreeDao {
//	查询父节点  旧版
	public List<Tree> treeList(Tree tree1) throws Exception; 
//	查询子节点 旧版
	public int findTreeCount(int menuId) throws Exception;
//	导航tree 父节点
	public List<Resources> showResources(Resources resources) throws Exception;
//	导航tree子节点查询
	public List<Resources> countResources(Resources resources) throws Exception;
	
	
//	资源管理列表父节点
	public List<Resources> showResourcesRight(Resources resources) throws Exception;
//	资源管理列表子节点查询
	public List<Resources> countResourcesRight(Resources resources) throws Exception;
//	资源管理添加
	public void addResources(Resources resources) throws Exception;
//	资源管理的删除
	public void deleteResources(List<Integer> ids) throws Exception;
//查询id
	public Resources showResoId(Resources resources) throws Exception;
	
//	查询资源类型表
	public List<Map> queryResourcesType() throws Exception;
	
//	修改
	public void updateResources(Resources resources) throws Exception;
}
