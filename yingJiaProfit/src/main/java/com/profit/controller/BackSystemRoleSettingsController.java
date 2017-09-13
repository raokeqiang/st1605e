package com.profit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profit.bean.Resources;
import com.profit.bean.UserRole;
import com.profit.service.UserService;

/**
 * 后台-->系统设置-->角色设置
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/backSystemRoleSettings")
public class BackSystemRoleSettingsController {

	@Resource
	private UserService userServiceImpl;

	@Resource
	private UserService userRoleServiceImpl;

	@Resource
	private UserService userRolesResources;

	// 查询角色列表
	@RequestMapping("/login")
	public String login(Model model) {
		List<UserRole> roleList = this.userRoleServiceImpl.ListAll(null);
		System.out.println("123456789");
		model.addAttribute("list", roleList);
		return "backRole";
	}

	// 点ztree选择菜单后 添加角色权限 跳转到角色设置页面
	@RequestMapping("/addPers")
	public String BgRight(String msg, int id) {
		System.out.println(msg + "msg/" + id + "id/");
		userRolesResources.save(msg, id);
		return "backRole";
	}

	// 后台用户权限管理
	@ResponseBody
	@RequestMapping("Ztree")
	public String Ztree(Model model, int id) {
		System.out.println("初始化");
		List<Resources> list = userRolesResources.ListAll();
		List<Integer> bool = userRoleServiceImpl.ListAlltrue(id);
		StringBuffer json = new StringBuffer("[");
		String data = "";
		for (int i = 0; i < list.size(); i++) {
			json.append("{id:" + list.get(i).getResources_id() + ",");
			json.append("pId:" + list.get(i).getResources_higher() + ",");
			json.append("name:\"" + list.get(i).getResources_name() + "\",");
			if (list.get(i).getIsParent() != 0) {
				json.append("isParent:" + list.get(i).getIsParent() + ",");
			}
			for (int y = 0; y < bool.size(); y++) {
				if (list.get(i).getResources_id() == bool.get(y)) {

					System.out.println(bool.get(y));
					// 默认勾选
					json.append("checked:true,");
					// 勾选后默认打开
					json.append("open:" + list.get(i).getResources_id() + ",");
				}
			}
			if (list.get(i).getChkDisabled() == 1) {
				json.append("checked:true,");
				json.append("chkDisabled:true,");
			}
			data = json.substring(0, json.lastIndexOf(",")) + "},";
			json = new StringBuffer(data);
		}
		data = json.substring(0, json.length() - 1) + "]";
		System.out.println(data);
		return data;
	}
}
