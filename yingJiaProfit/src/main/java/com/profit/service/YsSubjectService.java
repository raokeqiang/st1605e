package com.profit.service;
import java.util.List;
import com.profit.bean.Subject;

public interface YsSubjectService {
 List<Subject>listSubject();
 Subject getById(int id);
 void updateSub(Subject sub);
 void p2pAdd(Subject sub);
}
