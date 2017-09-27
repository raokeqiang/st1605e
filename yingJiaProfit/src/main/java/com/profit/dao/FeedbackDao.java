package com.profit.dao;

import java.util.List;

import com.profit.bean.BbinInfo;
import com.profit.bean.FeedBack;

public interface FeedbackDao<T> {

	void saveF(T t);
	List<FeedBack> listFeedback();
}
