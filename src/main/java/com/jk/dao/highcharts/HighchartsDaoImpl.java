package com.jk.dao.highcharts;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jk.model.RoleAndUser;
import com.jk.model.User;

@Repository
public class HighchartsDaoImpl implements HighchartsDao {
	
	@Autowired
	@Qualifier("sqlMapClient")
	private SqlMapClient sqlMapClient;

	@Override
	public List<RoleAndUser> selectWorkloadAnalysis() throws Exception {
		List<RoleAndUser> list = sqlMapClient.queryForList("roleAndUser.selectWorkloadAnalysis");
		return list;
	}

	@Override
	public List<User> findUserCreateTime() throws Exception {
		List<User> list = sqlMapClient.queryForList("User.findUserCreateTime");
		return list;
	}

}
