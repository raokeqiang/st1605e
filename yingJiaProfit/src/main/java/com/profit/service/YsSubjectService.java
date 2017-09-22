package com.profit.service;
import java.util.List;
import java.util.Map;

import com.profit.bean.FinanceProductSubscribe;
import com.profit.bean.Subject;
import com.profit.bean.SubjectBbinPurchassRecord;

public interface YsSubjectService {
 List<Subject>listSubject(Map map);
 Subject getById(int id);
 void updateSub(Subject sub);
 void p2pAdd(Subject sub);
 List<SubjectBbinPurchassRecord>listp2pton();

}
