package com.jk.service.mechanism;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.mechanism.MechanismDao;
import com.jk.model.Mechanism;

@Service
public class MechanismServiceImpl implements MechanismService {
	
	@Autowired
	private MechanismDao mechanismDao;

	@Override
	public Set<Mechanism> showMechanism(Mechanism mechanism) throws Exception {
		List<Mechanism> mechanismList = new ArrayList<Mechanism>();
		if (null != mechanism && null != mechanism.getId()) {
			mechanismList = mechanismDao.countMechanism(mechanism);
		} else {
			mechanismList = mechanismDao.showMechanism(mechanism);
		}
		Set<Mechanism> s = new HashSet<Mechanism>();
		for (Mechanism mechanism2 : mechanismList) {
			if (isExsitChildrenNode2(mechanism2)) {
				mechanism2.setState("closed");
			}
			s.add(mechanism2);
		}
		return s;
	}

	private boolean isExsitChildrenNode2(Mechanism mechanism2) throws Exception {
		boolean flag = false;
		List<Mechanism> nodeById = mechanismDao.countMechanism(mechanism2);
		if (nodeById != null && nodeById.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void addMechanism(Mechanism mechanism) throws Exception {
		mechanismDao.addMechanism(mechanism);
		
	}

	@Override
	public void deleteMechanism(Mechanism mechanism) throws Exception {
		mechanismDao.deleteMechanism(mechanism);
	}

	@Override
	public Mechanism showMechanismById(Mechanism mechanism) throws Exception {
		return mechanismDao.showMechanismById(mechanism);
	}

	@Override
	public void updateMechanism(Mechanism mechanism) throws Exception {
		mechanismDao.updateMechanism(mechanism);
		
	}

}
