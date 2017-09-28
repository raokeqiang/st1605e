package com.profit.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.BbinInfo;
import com.profit.bean.FeedBack;
import com.profit.dao.FeedbackDao;
import com.profit.service.FeedbackService;
@Service
public class FeedbackServiceImpl implements FeedbackService<FeedBack>{

	@Autowired
	@Qualifier("feedbackDaoImpl")
	private FeedbackDao feedbackDaoImpl;

	public void saveF(FeedBack feedback) {
		feedbackDaoImpl.saveF(feedback);
	}

	public List<FeedBack> listBbinInfo() {
		return feedbackDaoImpl.listFeedback();
	}

}
