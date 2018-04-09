package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.EnterpriseMapper;
import pojo.Enterprise;
import service.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	@Autowired
	EnterpriseMapper enterpriseMapper;

	@Override
	public Enterprise login(Enterprise ent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signupSave(Enterprise ent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signupCheck(Enterprise ent) {
		// TODO Auto-generated method stub
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

	@Override
	public Enterprise getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
