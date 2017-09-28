package com.profit.dao;

import java.util.List;

import com.profit.bean.PushNotice;

public interface PushNoticeDao<T> {

	List<T> listAllPushNotice(String title);
	void updatePushNotice(T t);
	List<PushNotice> listByid(int id);
    void savePushNotice(T t);
}
