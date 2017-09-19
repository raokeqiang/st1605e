package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Subject;
import com.profit.dao.YsSubjectDaoqian;
@Component
public class YsSubjectDaoqianImpl implements YsSubjectDaoqian{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}
	   //全部
	@Override
	//double year_date=
//	String hql="select * from Subject where year_date>="+year_date+"and  year_date<="+year_date+""
//			+ "and   ";
	public List<Subject> list(Map map) {
		String hql="from Subject  where 0=0 ";
		hql=listDataHql(hql, map);
         Session session=getsession();
  	    List<Subject> list=session.createQuery(hql).list();
		return list;
	}
	
   public String listDataHql(String hql,Map map){
	   String year_rate=(String)map.get("year_rate");
	   String period_start=(String)map.get("period_start");
	   String period_end=(String)map.get("period_end");
	   String type=(String)map.get("type");
	   String status=(String)map.get("sss");
	   String flag=(String)map.get("flag");
	   
	   System.out.println("dao="+status);
	   if(year_rate!=null&&!year_rate.equals("")){
		   if("0".equals(flag)){
			   hql+=" and year_rate="+Double.valueOf(year_rate);
		 }else if("1".equals(flag)){
			   hql+=" and year_rate>"+Double.valueOf(year_rate);  
		   }
	   }
	   if((period_start!=null&&!period_start.equals(""))&&(period_end!=null&&!period_end.equals(""))){
		      if(period_end.equals("-1")){
		    	  hql+=" and period >="+Integer.valueOf(period_start);
		      }else{
			    hql+=" and period between "+Integer.valueOf(period_start)+ " and "+Integer.valueOf(period_end);
		      }
	   }
	   
	   if(status!=null&&!status.equals("")){
		     if(status.equals("-1")){
		     }else{
		    	  hql+="and status="+Integer.valueOf(status); 
		     }
		  
	   }
	   System.out.println("hql===="+hql);
	   return hql;
   }

	
}
