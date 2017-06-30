package com.jk.dao.mechanism;

import java.util.List;

import com.jk.model.Mechanism;

public interface MechanismDao {

	List<Mechanism> countMechanism(Mechanism mechanism) throws Exception;

	List<Mechanism> showMechanism(Mechanism mechanism) throws Exception;

	void addMechanism(Mechanism mechanism) throws Exception;

	void deleteMechanism(Mechanism mechanism) throws Exception;

	Mechanism showMechanismById(Mechanism mechanism) throws Exception;

	void updateMechanism(Mechanism mechanism) throws Exception;

}
