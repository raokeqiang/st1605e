package com.profit.service;

import java.util.List;

import com.profit.bean.PushNotice;

public interface PushNoticeService<T> {

	List<T> listAllPushNotice(String title);
	void updatePushNotice(T t);
	List<PushNotice> listByid(int id);
    void savePushNotice(T t);
}
