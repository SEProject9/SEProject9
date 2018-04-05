package service;

import java.util.List;

import pojo.EnterpriseInfo;

public interface EnterpriseInfoService {
	// 完善企业用户信息
	boolean add(EnterpriseInfo ei);

	boolean delete(int id);

	List<EnterpriseInfo> list();

	/*默认显示所有通过审核的(管理员人员不用到)
	 * 行业
	 * 企业名字
	 * 企业地址*/
	List<EnterpriseInfo> searchByAdmin(EnterpriseInfo ei);

	List<EnterpriseInfo> searchByUser(EnterpriseInfo ei);

	EnterpriseInfo show(int id);

	boolean update(EnterpriseInfo ei);

}
