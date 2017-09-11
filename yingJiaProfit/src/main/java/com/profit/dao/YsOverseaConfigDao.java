package com.profit.dao;
//海外配置
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.oversea_config;
import com.profit.bean.oversea_config_subscribe;
@Component
public class YsOverseaConfigDao {
@Autowired
	  private SessionFactory sessionFactory;
	  public Session getSession(){
		  return sessionFactory.getCurrentSession();
	  }
	  public void saveover(oversea_config over){
		  Session session=getSession();
		  session.save(over);
	  }
	  public void updateover(oversea_config over){
		  Session session=getSession();
		  session.update(over);
	  }
	  public void deleteover(oversea_config over){
		  Session session=getSession();
		  session.delete(over);
	  }
	  public oversea_config getById(int id){
		  Session session=getSession();
		  oversea_config  over =(oversea_config)session.get(oversea_config.class, id);
		  return over;
	  }
	  public List<oversea_config >listAllover(){
		  Session session=getSession();
		  List<oversea_config> list=session.createQuery("from oversea_config").list();
		  return list;
	  }
	  public List<oversea_config_subscribe>listover(){
		  Session session=getSession();
		  List<oversea_config_subscribe> list2=session.createQuery("from oversea_config_subscribe").list();
		  return list2;
	  }
	//显示海外配置订阅
//	  public List<oversea_config_subscribe> listding(){
//		  Session session=getSession();
//		  String sql="select e.name,e.phone,e.addr,o.addTime  "
//		  		+ "from oversea_config_subscribe e,oversea_config  o where e.oversea_id=o.id  ";
//		  List<oversea_config_subscribe> list2=session.createQuery("from sql").list();
//		  return list2;
//	  }
	  
	}

