package com.jk.service.mechanism;

import java.util.List;
import java.util.Set;

import com.jk.model.Mechanism;

public interface MechanismService {

	Set<Mechanism> showMechanism(Mechanism mechanism) throws Exception;

	void addMechanism(Mechanism mechanism) throws Exception;

	void deleteMechanism(Mechanism mechanism) throws Exception;

	Mechanism showMechanismById(Mechanism mechanism) throws Exception;

	void updateMechanism(Mechanism mechanism) throws Exception;


}
