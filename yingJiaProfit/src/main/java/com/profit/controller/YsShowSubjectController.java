package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MatrixVariableMapMethodArgumentResolver;

import com.profit.bean.Subject;
import com.profit.service.YsSubjectServiceqian;

@Controller
@RequestMapping("/subjectqian")
public class YsShowSubjectController {
	@Autowired
//	@Qualifier("ysSubjectServiceImplqian")
	private YsSubjectServiceqian subjectServiceqian;
	
	
	
	@RequestMapping("/sss/{m}")
	public String sss(@PathVariable("m")String s){
		 System.out.println("s="+s);
		return "front/showsubject";
	}
	
	
	
	//条件为空，则查询全部
	@RequestMapping("/showsubject")
	public String showsubject(Model model,HttpServletRequest request,HttpServletResponse response){
		Map map=new HashMap();//新建一个map集合
		String status=request.getParameter("sss");//标的状态
		String year_rate=request.getParameter("year_rate");//年化收益
		map=initMap(request, map);
		List<Subject>list=subjectServiceqian.list(map);//查询所有
		model.addAttribute("list",list);
return "front/showsubject";
	}
	
	public Map initMap(HttpServletRequest request,Map map){
		String type=request.getParameter("type");
		String year_rate=request.getParameter("year_rate");//年化收益
		String period_start=request.getParameter("period_start");//开始期限
		String period_end=request.getParameter("period_end");//结束期限
		String status=request.getParameter("sss");//标的状态
		String flag=request.getParameter("flag"); //标志
        map.put("type",type);
		map.put("year_rate",year_rate);
		map.put("period_start",period_start);
		map.put("period_end",period_end);
		map.put("sss",status);
		map.put("flag",flag);
	  if(type!=null){
			request.setAttribute("type",type);
		}
		if(year_rate!=null){
			request.setAttribute("year_date",year_rate);
		}
		if(period_start!=null){
			request.setAttribute("period_start",period_start);
		}
		if(period_end!=null){
			request.setAttribute("period_end",period_end);
		}
		if(status!=null){
			request.setAttribute("sss",status);
		}
		if(flag!=null){
			request.setAttribute("flag",flag);
		}
		return map;
	}
}
