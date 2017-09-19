package com.profit.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.profit.bean.Subject;

public interface YsSubjectDaoqian {
  List <Subject>list(Map map);
  Session getsession();
}
