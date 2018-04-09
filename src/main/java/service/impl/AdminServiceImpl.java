package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.AdminMapper;
import pojo.Admin;
import service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;

	@Override
	public boolean add(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean resetPasswork(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin show(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
