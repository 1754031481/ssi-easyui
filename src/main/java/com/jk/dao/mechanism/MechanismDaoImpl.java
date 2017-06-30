package com.jk.dao.mechanism;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jk.model.Mechanism;

@Repository
public class MechanismDaoImpl implements MechanismDao {
	
	@Autowired
	@Qualifier("sqlMapClient")
	private SqlMapClient sqlMapClient;

	@Override
	public List<Mechanism> countMechanism(Mechanism mechanism) throws Exception {
		List countMechanism = sqlMapClient.queryForList("Mechanism.countMechanism", mechanism);
		return countMechanism;
	}

	@Override
	public List<Mechanism> showMechanism(Mechanism mechanism) throws Exception {
		List showMechanism = sqlMapClient.queryForList("Mechanism.showMechanism", mechanism);
		return showMechanism;
	}

	@Override
	public void addMechanism(Mechanism mechanism) throws Exception {
		sqlMapClient.insert("Mechanism.addMechanism", mechanism);
	}

	@Override
	public void deleteMechanism(Mechanism mechanism) throws Exception {
		sqlMapClient.delete("Mechanism.deleteMechanism", mechanism);
	}

	@Override
	public Mechanism showMechanismById(Mechanism mechanism) throws Exception {
		return (Mechanism) sqlMapClient.queryForObject("Mechanism.showMechanismById", mechanism);
	}

	@Override
	public void updateMechanism(Mechanism mechanism) throws Exception {
		sqlMapClient.update("Mechanism.updateMechanism", mechanism);
	}
}
