package com.jk.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jk.model.Mechanism;
import com.jk.service.mechanism.MechanismService;

@Controller
@RequestMapping("mechanism")
public class MechanismController extends BaseController{
	
	@Autowired
	private MechanismService mechanismService;
	
	
	@RequestMapping("deleteMechanism")
	public void deleteMechanism(Mechanism mechanism,HttpServletResponse response) throws Exception{
		mechanismService.deleteMechanism(mechanism);
		
	}
	@RequestMapping("addMechanism")
	public void addMechanism(Mechanism mechanism,HttpServletResponse response){
		
		try {
			if(null!=mechanism.getId()){
				mechanism.setUpdatetime(new Date());
				mechanismService.updateMechanism(mechanism);
			}else{
				mechanism.setCreatedatetime(new Date());
				mechanism.setUpdatetime(new Date());
				mechanismService.addMechanism(mechanism);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping("showMechanism")
	public void showMechanism(Mechanism mechanism,HttpServletResponse response){
		Set<Mechanism> showMechanism=new HashSet<>();
		try {
			showMechanism = mechanismService.showMechanism(mechanism);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.writeJson(showMechanism, response);
	}
	
	@RequestMapping("toAddMechanism")
	public ModelAndView toAddMechanism(Mechanism mechanism,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		Mechanism mechanism12=new Mechanism();
		if(null!=mechanism.getId()){
			try {
				mechanism12=mechanismService.showMechanismById(mechanism);
				mv.addObject("mechanism", mechanism12);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mv.setViewName("/WEB-INF/mechanism/addMechanism");
		}
		return mv;
	}
}
