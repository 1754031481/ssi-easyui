package com.jk.service.highcharts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.highcharts.HighchartsDao;
import com.jk.model.RoleAndUser;
import com.jk.model.User;

@Service
public class HighchartsServiceImpl implements HighchartsService {
	
	@Autowired
	private HighchartsDao highchartsDao;

	@Override
	public List<RoleAndUser> selectWorkloadAnalysis() throws Exception {
		List<RoleAndUser> list = highchartsDao.selectWorkloadAnalysis();
		return list;
	}

	@Override
	public List<User> findUserCreateTime() throws Exception {
		//int k=0;
//		List<User> list=
//		for (User user : list) {
//			Map<String, Object> params = new HashMap<String, Object>();
//			params.put("a", k);
//			params.put("b", k + 2);
//			k = k + 2;
//		}
		return highchartsDao.findUserCreateTime();
	}

}
