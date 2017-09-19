package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Subject;
import com.profit.service.YsSubjectService;

@Controller
@RequestMapping("/shopping")
public class YsShoppingqianController {
	@Autowired
	private YsSubjectService subjectService;
	
	@RequestMapping("/toBuy")
	public String shopping(Model model,int id){
		Map map=new HashMap<>();
		Subject sub=subjectService.getById(id);
		List<Subject> list = subjectService.listSubject(map);
		model.addAttribute("sub", sub);
		model.addAttribute("list", list);
		return "pront/shopping";
		
	}
}
