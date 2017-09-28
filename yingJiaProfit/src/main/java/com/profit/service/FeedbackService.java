package com.profit.service;

import java.util.List;

import com.profit.bean.BbinInfo;
import com.profit.bean.FeedBack;

public interface FeedbackService<T> {

	void saveF(T t);
	List<FeedBack> listBbinInfo();
}
