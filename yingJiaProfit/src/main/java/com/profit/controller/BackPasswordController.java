package com.profit.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profit.bean.Users;
import com.profit.service.RoleService;


@Controller
@RequestMapping("/backPassword")
public class BackPasswordController {
	
	@Resource
	@Qualifier("backPasswordServiceImpl")
	private RoleService<Users> BackPasswordServiceImpl;
	
	@RequestMapping("/topassword")
	public String topassword(){
		return "backPassword";
	}
	
	//校验原密码
	@RequestMapping("/lober")
	public String boolea(String password,HttpServletRequest request){
		System.out.println("校验原密码");
		String pwd=(String)request.getSession().getAttribute("password");
		boolean boo=false;
		if(password==pwd||password.equals(pwd)){
			boo=true;
		}
		
		Map<String,Boolean> map=new HashMap<>(); 
		map.put("valid", boo);
		System.out.println(boo);
		ObjectMapper mapper=new ObjectMapper();
		String res="";
			try {
				res =mapper.writeValueAsString(map);
				System.out.println(res);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		return "res";
		}
	
	//修改密码
	@RequestMapping("/updatePassword")
	public String updatepassword(String password2,HttpServletRequest request){
		String user_name=(String)request.getSession().getAttribute("user_name");
		BackPasswordServiceImpl.updateUsers(password2, user_name);
		return "backPassword";
		}
	}





