package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MatrixVariableMapMethodArgumentResolver;

import com.profit.bean.Subject;
import com.profit.service.YsSubjectServiceqian;

@Controller
@RequestMapping("/subjectqian")
public class YsShowSubjectController {
	@Autowired
//	@Qualifier("ysSubjectServiceImplqian")
	private YsSubjectServiceqian subjectServiceqian;
	
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
	@RequestMapping("/queryType")
    public String queryType(@RequestParam(required=false,value="type")
    String type,@RequestParam(required=false,value="year_rate")
    String year_rate,@RequestParam(required=false,value="status")String status,
    @RequestParam(required=false,value="days")String days,Model model,HttpSession re){
    	if("-1".equals(type)){
    		re.setAttribute("type", null);
    		type=null;
    	}
    	if("-1".equals(status)){
    		re.setAttribute("status", null);
    		status=null;
    	}
    	if("-1".equals(year_rate)){
    		re.setAttribute("year_rate", null);
    		year_rate=null;
    	}
    	if("-1".equals(days)){
    		re.setAttribute("days", null);
    		days=null;
    	}
    	if(re.getAttribute("type")!=null&&type==null){
    		type=(String) re.getAttribute("type");
    	}
    	if(re.getAttribute("year_rate")!=null&&year_rate==null){
    		year_rate=(String) re.getAttribute("year_rate");
    	}
    	if(re.getAttribute("status")!=null&&status==null){
    		status=(String) re.getAttribute("status");
    	}
    	if(re.getAttribute("days")!=null&&days==null){
    		days=(String) re.getAttribute("days");
    	}
    	String hql="from Subject where 0=0";
    	if(type!=null){
    		hql+= "and type like'%"+type+"%'";
    		re.setAttribute("type", type);
    	}
    	if(year_rate!=null){
    		hql+= "and year_rate like'%"+year_rate+"%'";
    		re.setAttribute("year_rate", year_rate);
    	}
    	if(status!=null){
    		hql+= "and status like'%"+status+"%'";
    		re.setAttribute("status", status);
    	}
    	if(days!=null){
    		String xday="";
    		if(days.equals("1")){
    			xday=" and period<=15";
   	    	}else if(days.equals("2")){
   	    		xday=" and 30>period and period>=15";	
   	    	}else if(days.equals("3")){
   	    		xday=" and 180>period and period>=30";	
   		    }else if(days.equals("4")){
   		    	xday=" and 365>period and period>=180";	
   		    }else if(days.equals("5")){
   		    	xday=" and period>=365";	
   		    	}
    		hql+=xday;
    		re.setAttribute("days", days);
    	}
   	 List<Subject> list=subjectServiceqian.query(hql);
		model.addAttribute("list",list);
    	return "front/showsubject";
    }
}
