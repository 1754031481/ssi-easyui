package com.jk.service.highcharts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.model.RoleAndUser;
import com.jk.model.User;

public interface HighchartsService {

	List<RoleAndUser> selectWorkloadAnalysis() throws Exception;

	List<User> findUserCreateTime() throws Exception;


}
