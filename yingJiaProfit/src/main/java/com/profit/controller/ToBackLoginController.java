package com.profit.controller;

import java.util.Set;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Users;
import com.profit.service.UserService;

@Controller
@RequestMapping("/toBackLogin")
public class ToBackLoginController {
	
	@Resource
	private UserService userRoleServiceImpl;

	@RequestMapping("/login")
	public String login(){
		return "backLogin";
	}
	
	@RequestMapping("/goToMain")
	public String goToMain(Users user,HttpServletRequest request,Model model){
			String msg="";
			String name=user.getUser_name();
			String password=user.getPassword();
			System.out.println(name+"---------"+password);
			Subject subject=SecurityUtils.getSubject();
			System.out.println("################");
			UsernamePasswordToken token=new UsernamePasswordToken(name,password);
			try {
				System.out.println("################");
				subject.login(token);
				System.out.println("################");
				Session session=subject.getSession();
				System.out.println("################");
				session.setAttribute("user_name", user.getUser_name());
				System.out.println(user.getUser_name()+"mingz");
				Set<String> set=userRoleServiceImpl.ListAllByName(name);
				String url=null;
				for (String string : set) {
					url=string;
					//用户角色
					if(url!=null){
						break;
					}
				}
				if(url!=null){
					System.out.println("success");
					 return "admin";
				}
			} catch (IncorrectCredentialsException e) {  
		        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (ExcessiveAttemptsException e) {  
		        msg = "登录失败次数过多";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (LockedAccountException e) {  
		        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (DisabledAccountException e) {  
		        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (ExpiredCredentialsException e) {  
		        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (UnknownAccountException e) {  
		        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    } catch (UnauthorizedException e) {  
		        msg = "您没有得到相应的授权！" + e.getMessage();  
		        model.addAttribute("message", msg);  
		        System.out.println(msg);  
		    }  
		return "backLogin";
	}
}
