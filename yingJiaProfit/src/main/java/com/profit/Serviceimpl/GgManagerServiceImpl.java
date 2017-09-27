package com.profit.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.SysRechargePriceConfig;
@Service
public class GgManagerServiceImpl implements com.profit.service.GgManagerService {

	@Autowired
	@Qualifier("ggManagerDaoImpl")
	private com.profit.dao.GgManagerDao manager;

	public List<AwardRecords> ListCop(String creatTime,String vs,String month) {
		return manager.ListCop(creatTime,vs,month);
	}

	public List<AwardRecords> ListCop1(String creatTime,String vs,String month) {
		return manager.ListCop1(creatTime,vs,month);
	}

	public List<com.profit.bean.Subject> ListCop2(String creatTime, String endTime,String vs,String month) {
		return manager.ListCop2(creatTime, endTime,vs,month);
	}

	public List<com.profit.bean.Subject> ListCop3(String creatTime, String endTime,String vs,String month) {
		return manager.ListCop3(creatTime, endTime,vs,month);
	}

	public List<com.profit.bean.Subject> ListCop4(String creatTime, String endTime,String vs,String month) {
		return manager.ListCop4(creatTime, endTime,vs,month);
	}

	public List<SysRechargePriceConfig> ListCop5(String creatTime,String vs,String month) {
		return manager.ListCop5(creatTime,vs,month);
	}

	public List<SysRechargePriceConfig> ListCop6(String creatTime,String vs,String month) {
		return manager.ListCop6(creatTime,vs,month);
	}

	public List<MembeWithdrawRecord> ListCop7(String creatTime,String vs,String month) {
		return manager.ListCop7(creatTime,vs,month);
	}

	public List<MembeWithdrawRecord> ListCop8(String creatTime,String vs,String month) {
		return manager.ListCop8(creatTime, vs,month);
	}

	public List<com.profit.bean.Subject> ListCop9(String creatTime, String endTime,String vs,String month) {
		return manager.ListCop9(creatTime, endTime, vs,month);
	}

	public List<com.profit.bean.Subject> ListCop10(String creatTime, String endTime,String vs,String month) {
		return manager.ListCop10(creatTime, endTime,vs,month);
	}

	public List<com.profit.bean.Subject> ListCop11(String creatTime, String endTime,String vs,String month) {
		return manager.ListCop11(creatTime, endTime,vs,month);
	}

	public List<MemberTradeRecord> ListCop12(String creatTime,String vs,String month) {
		return manager.ListCop12(creatTime,vs,month);
	}

	public List<MemberTradeRecord> ListCop13(String creatTime,String vs,String month) {
		return manager.ListCop13(creatTime,vs,month);
	}

	public List<com.profit.bean.Member_tally> ListCop14(String creatTime,String vs,String month) {
		return manager.ListCop14(creatTime,vs,month);
	}
	


}
