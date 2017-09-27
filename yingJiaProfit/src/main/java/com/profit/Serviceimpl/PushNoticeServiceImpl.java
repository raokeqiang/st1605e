package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.PushNotice;
import com.profit.dao.PushNoticeDao;
import com.profit.service.PushNoticeService;
@Service
@Transactional
public class PushNoticeServiceImpl implements PushNoticeService<PushNotice>{
	@Autowired
	@Qualifier("pushNoticeDaoimpl")
	private PushNoticeDao pushNoticeDaoimpl;
	
	public List<PushNotice> listAllPushNotice(String title) {
		return pushNoticeDaoimpl.listAllPushNotice(title);
	}

	public void updatePushNotice(PushNotice pushNotice) {
		pushNoticeDaoimpl.updatePushNotice(pushNotice);
	}




	public void savePushNotice(PushNotice pushNotice) {
		pushNoticeDaoimpl.savePushNotice(pushNotice);
	}

	public List<PushNotice> listByid(int id) {
		return pushNoticeDaoimpl.listByid(id);
	}

}
