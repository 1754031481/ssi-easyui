package com.jk.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.role.RoleDao;
import com.jk.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> showPageRole(Role role, Integer page, Integer rows) throws Exception {
		Map<String, Object> QUERY_NAME=new HashMap<>();
		QUERY_NAME.put("name", role.getName());
		QUERY_NAME.put("description", role.getDescription());
		QUERY_NAME.put("iconCls", role.getIconCls());
		QUERY_NAME.put("seq", role.getSeq());
		QUERY_NAME.put("createdatetime", role.getCreatedatetime());
		QUERY_NAME.put("updatedatetime", role.getUpdatedatetime());
		QUERY_NAME.put("page", (page-1)*rows);
		QUERY_NAME.put("rows", rows);
		List<Role> showPageRole = roleDao.showPageRole(QUERY_NAME);
		return showPageRole;
	}

	@Override
	public Long countRole(Role role) throws Exception {
		Map<String, Object> QUERY_NAME=new HashMap<>();
		QUERY_NAME.put("name", role.getName());
		Long countRole = roleDao.countRole(QUERY_NAME);
		return countRole;
	}

	@Override
	public void deleteRole(String ids) throws Exception {
		List<Integer> list=new ArrayList<>();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			if(null!=split[i] && !"".equals(split[i])){
				list.add(Integer.valueOf(split[i].trim()));
			}
		}
		roleDao.deleteRole(list);
	}

	@Override
	public void insertRole(Role role) throws Exception {
		roleDao.insertRole(role);
	}

	@Override
	public Role findRoleById(Role role) throws Exception {
		return roleDao.findRoleById(role);
	}

	@Override
	public void updateRole(Role role) throws Exception {
		roleDao.updateRole(role);
	}


	
	
}
