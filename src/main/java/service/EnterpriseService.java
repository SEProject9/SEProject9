package service;

import java.util.List;

import pojo.Enterprise;

public interface EnterpriseService {

	Enterprise login(String account,String password);

	boolean signupSave(Enterprise ent);

	boolean checkAccount(String account);

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
