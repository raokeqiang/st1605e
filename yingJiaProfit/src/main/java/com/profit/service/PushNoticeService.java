package com.profit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profit.bean.PushNotice;
import com.profit.dao.PushNoticeDao;
@Service
public class PushNoticeService {
	@Autowired
	private PushNoticeDao pushNoticeDao;

	public List<PushNotice> listAllPushNotice(String title) {
		return pushNoticeDao.listAllPushNotice(title);
	}

	public void updatePushNotice(PushNotice pushNotice) {
		pushNoticeDao.updatePushNotice(pushNotice);
	}

	public PushNotice listByid(int id) {
		return pushNoticeDao.listByid(id);
	}

	public void savePushNotice(PushNotice pushNotice) {
		pushNoticeDao.savePushNotice(pushNotice);
	}
}
