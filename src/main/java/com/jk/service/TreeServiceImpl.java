package com.jk.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.TreeDao;
import com.jk.model.Resources;
import com.jk.model.Tree;

@Service
public class TreeServiceImpl implements TreeService {
	
	@Autowired
	private TreeDao treeDao;
//旧版
	@Override
	public List<Tree> treeList(Tree tree1) throws Exception {
		return treeDao.treeList(tree1);
	}
	//旧版
	@Override
	public int findTreeCount(int menuId) throws Exception {
		return treeDao.findTreeCount(menuId);
	}

	@Override
	public Set<Resources> showResources(Resources resources) throws Exception {
		List<Resources> resourceList = new ArrayList<Resources>();
		if (null != resources && null != resources.getId()) {
			resourceList = treeDao.countResources(resources);
		} else {
			resourceList = treeDao.showResources(resources);
		}
		Set<Resources> s = new HashSet<Resources>();
		for (Resources resource2 : resourceList) {
			if (isExsitChildrenNode(resource2)) {
				resource2.setState("closed");
			}
			s.add(resource2);
		}
		return s;
	}
	
	private boolean isExsitChildrenNode(Resources resource2) throws Exception {
		boolean flag = false;
		List<Resources> nodeById = treeDao.countResources(resource2);
		if (nodeById != null && nodeById.size() > 0) {
			flag = true;
		}
		return flag;
	}
	
	

	
	
	@Override
	public void addResources(Resources resources) throws Exception {
		treeDao.addResources(resources);
	}

	@Override
	public void deleteResources(String ids) throws Exception {
		List<Integer> list=new ArrayList<>();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			if(null != split[i] && !"".equals(split[i])){
				list.add(Integer.valueOf(split[i].trim()));
			}
		}
		treeDao.deleteResources(list);
	}

	@Override
	public Resources showResoId(Resources resources) throws Exception {
		return treeDao.showResoId(resources);
	}

	@Override
	public List<Map> queryResourcesType() throws Exception {
		return treeDao.queryResourcesType();
	}
	
	@Override
	public void updateResources(Resources resources) throws Exception {
		treeDao.updateResources(resources);
	}
	

//=========================以下为重复代码，只为查询资源列表和导航tree的代码一致=============================================================
	@Override
	public Set<Resources> showResourcesRight(Resources resources) throws Exception {
		List<Resources> resourceList = new ArrayList<Resources>();
		if (null != resources && null != resources.getId()) {
			resourceList = treeDao.countResourcesRight(resources);
		} else {
			resourceList = treeDao.showResourcesRight(resources);
		}
		Set<Resources> s = new HashSet<Resources>();
		for (Resources resource2 : resourceList) {
			if (isExsitChildrenNode2(resource2)) {
				resource2.setState("closed");
			}
			s.add(resource2);
		}
		return s;
	}
	
	private boolean isExsitChildrenNode2(Resources resource2) throws Exception {
		boolean flag = false;
		List<Resources> nodeById = treeDao.countResourcesRight(resource2);
		if (nodeById != null && nodeById.size() > 0) {
			flag = true;
		}
		return flag;
	}



}
