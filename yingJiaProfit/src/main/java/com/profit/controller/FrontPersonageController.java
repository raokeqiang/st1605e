package com.profit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toFrontPersonage")
public class FrontPersonageController {
	
	
		@RequestMapping("/shouyi")
		public String FrontPersonage(){
			return "/frontPersonage/ShouYi";
		}
		@RequestMapping("/anquan")
		public String anquan(){
			return "/frontPersonage/anquan";
		}
		@RequestMapping("/chongzhi")
		public String chongzhi(){
			return "/frontPersonage/chongzhi";
		}
		
		@RequestMapping("/tikuan")
		public String tixian(){
			return "/frontPersonage/tikuan";
		}
		@RequestMapping("/tiyanjin")
		public String tiyanjin(){
			return "/frontPersonage/tiyanjin";
		}
		@RequestMapping("/touzi")
		public String touzi(){
			return "/frontPersonage/touzi";
		}
		@RequestMapping("/woyaotikuan")
		public String woyaotikuan(){
			return "/frontPersonage/woyaotikuan";
		}
		@RequestMapping("/bangka")
		public String bangka(){
			return "/frontPersonage/bangka";
		}
		
		//购买页面
		@RequestMapping("/shopping")
		public String shopping(){
			return "/front/frontShopping";
		}
		//注册页面
		@RequestMapping("/zhuce")
		public String zhuce(){
			return "/front/frontZhuCe";
		}
		
		
	}
