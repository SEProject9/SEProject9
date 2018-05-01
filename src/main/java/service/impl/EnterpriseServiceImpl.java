package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.EnterpriseInfoMapper;
import mapper.EnterpriseMapper;
import pojo.Enterprise;
import pojo.EnterpriseInfo;
import service.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	@Autowired
	EnterpriseMapper entMapper;
	@Autowired
	EnterpriseInfoMapper entInfoMapper;

	@Override
	public Enterprise login(String account, String password) {
		Enterprise temp = this.searchByAccount(account);
		if (null == temp || !temp.getEnt_password().equals(password))
			return null;
		return temp;
	}

	@Override
	public boolean signupSave(Enterprise ent) {
		boolean flag = checkAccount(ent.getEnt_account());
		if (!flag)
			return false;
		Integer result = entMapper.add(ent);
		if (1 != result)
			return false;
		// 创建对应的企业信息 表上对应id
		Enterprise temp = this.searchByAccount(ent.getEnt_account());
		EnterpriseInfo entInfo = new EnterpriseInfo();
		entInfo.setEnt_id(temp.getEnt_id());
		entInfo.setInd_id(1);//数据库nonull 要改的话麻烦 只能这里先默认了
		entInfoMapper.add(entInfo);
		return true;
	}

	@Override
	public boolean checkAccount(String account) {
		if (null == account || account.equals(""))
			return false;
		Enterprise ent = this.searchByAccount(account);
		if (null == ent)// 存在该帐号
			return true;
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(Enterprise ent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeState(Enterprise ent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Enterprise> search(Enterprise ent) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enterprise searchByAccount(String Account) {
		Enterprise temp = new Enterprise();
		temp.setEnt_account(Account);
		List<Enterprise> list = entMapper.search(temp);
		if (null == list || list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public Enterprise getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
