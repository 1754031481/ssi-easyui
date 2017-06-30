package com.jk.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jk.model.Resources;
import com.jk.model.Tree;

@Repository
public class TreeDaoImpl implements TreeDao {
	
	@Autowired
	@Qualifier("sqlMapClient")
	private SqlMapClient sqlMapClient;
	//旧版
	@Override
	public List<Tree> treeList(Tree tree1) throws Exception {
		return sqlMapClient.queryForList("Tree.treeList", tree1);
	}
	//旧版
	@Override
	public int findTreeCount(int menuId) throws Exception {
		Tree tree = new Tree();
		tree.setMenuId(menuId);
		return (int) sqlMapClient.queryForObject("Tree.findTreeCount", tree);
	}

//	资源管理
	@Override
	public List<Resources> showResources(Resources resources) throws Exception {
		List resourcesList = sqlMapClient.queryForList("Resources.showResources", resources);
		return resourcesList;
	}
	
	

	@Override
	public List<Resources> countResources(Resources resources) throws Exception {
		List<Resources> count=sqlMapClient.queryForList("Resources.countResources", resources);
		return count;
	}
	

	@Override
	public void addResources(Resources resources) throws Exception {
		sqlMapClient.insert("Resources.addResources", resources);
	}

	@Override
	public void deleteResources(List<Integer> ids) throws Exception {
		sqlMapClient.delete("Resources.deleteResources", ids);
	}

	@Override
	public Resources showResoId(Resources resources) throws Exception {
		return (Resources) sqlMapClient.queryForObject("Resources.showResoId", resources);
	}

	@Override
	public List<Map> queryResourcesType() throws Exception {
		return sqlMapClient.queryForList("Resources.queryResourcesType");
	}
	
	@Override
	public void updateResources(Resources resources) throws Exception {
		sqlMapClient.update("Resources.updateResources", resources);
	}
	
	
	
	
//=========================以下为重复代码，只为查询资源列表和导航tree的代码一致=============================================================
	@Override
	public List<Resources> showResourcesRight(Resources resources) throws Exception {
		List resourcesList = sqlMapClient.queryForList("Resources.showResourcesRight", resources);
		return resourcesList;
	}
	@Override
	public List<Resources> countResourcesRight(Resources resources) throws Exception {
		List<Resources> count=sqlMapClient.queryForList("Resources.countResourcesRight", resources);
		return count;
	}


}
