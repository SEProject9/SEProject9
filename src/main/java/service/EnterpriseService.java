package service;

import java.util.List;

import pojo.Enterprise;

public interface EnterpriseService {

	Enterprise login(Enterprise ent);

	boolean signupSave(Enterprise ent);

	boolean signupCheck(Enterprise ent);

	boolean delete(int id);

	boolean changePassword(Enterprise ent);

	boolean changeState(Enterprise ent);

	/*管理员搜索
	 * 状态
	 * 企业名
	 * 地址*/
	List<Enterprise> search(Enterprise ent);

	Enterprise getById(Integer id);

}
