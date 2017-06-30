package com.jk.dao.highcharts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.model.RoleAndUser;
import com.jk.model.User;

public interface HighchartsDao {

	List<RoleAndUser> selectWorkloadAnalysis() throws Exception;

	List<User> findUserCreateTime() throws Exception;


}
