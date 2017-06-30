package com.jk.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jk.model.Resources;
import com.jk.model.Tree;

public interface TreeService {
	//旧版
	public List<Tree> treeList(Tree tree1) throws Exception;
	//旧版
	public int findTreeCount(int menuId) throws Exception;
	//导航tree	
	public Set<Resources> showResources(Resources resources) throws Exception;
	//资源列表展示	
	public Set<Resources> showResourcesRight(Resources resources) throws Exception;
	
	public void addResources(Resources resources) throws Exception;
	
	public void deleteResources(String ids) throws Exception;

	public Resources showResoId(Resources resources) throws Exception;
	
	public List<Map> queryResourcesType() throws Exception;
	
	public void updateResources(Resources resources) throws Exception;
	
}
