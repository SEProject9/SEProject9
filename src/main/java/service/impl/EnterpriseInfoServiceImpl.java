package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.EnterpriseInfoMapper;
import pojo.EnterpriseInfo;
import service.EnterpriseInfoService;

@Service
public class EnterpriseInfoServiceImpl implements EnterpriseInfoService {
	@Autowired
	EnterpriseInfoMapper entInfoMapper;

	@Override
	public boolean add(EnterpriseInfo ei) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EnterpriseInfo> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnterpriseInfo> searchByAdmin(EnterpriseInfo ei) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnterpriseInfo> searchByUser(EnterpriseInfo ei) {
		return entInfoMapper.search(ei);
	}

	@Override
	public EnterpriseInfo show(int id) {
		return entInfoMapper.get(id);
	}

	@Override
	public boolean update(EnterpriseInfo ei) {
		// TODO Auto-generated method stub
		return false;
	}

}
