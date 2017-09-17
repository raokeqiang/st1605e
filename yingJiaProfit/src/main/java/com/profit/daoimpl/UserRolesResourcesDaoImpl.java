package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Resources;
import com.profit.bean.Users;

@Component
public class UserRolesResourcesDaoImpl {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	//查询角色
	public List<Resources> ListAll() {
		Session session = getSession();
		List<Resources> UserRoleList = session.createQuery("from Resources").list();
		System.out.println(UserRoleList.size() + "aaa");
		return UserRoleList;
	}
//	根据ID查询
	public List<Resources> ListById(int id) {
		Session session = getSession();
		List<Resources> UserRoleList = session.createQuery("from Resources where resources_id=" + id).list();
		return UserRoleList;
	}
	
//	修改权限
	public void save(Object... objects) {
		Session session = getSession();
		int id = (int) objects[1];
		delete(id);
		String[] sourceStrArray = ((String) objects[0]).split(",");
		for (int i = 0; i < sourceStrArray.length; i++) {
			int i1 = (Integer.parseInt(sourceStrArray[i]));
			String sql = "insert into role_res values (" + id + "," + i1 + ") ";
			session.createSQLQuery(sql).executeUpdate();
			// UserRole userRole=(UserRole)session.get(UserRole.class, id);
			// Resources resources=(Resources)session.get(Resources.class,i1);
			// userRole.getResour().add(resources);
			// resources.getResour().add(userRole);
		}
	}
	
	public void delete(int id) {
		Session session = getSession();
		String sql = "delete  from role_res where rid=" + id;
		session.createSQLQuery(sql).executeUpdate();
		session.flush();
	}
	

	
}
