package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mapper.TechSerSupMapper;
import pojo.TechSerSup;
import service.TechSerSupService;

@Service
public class TechSerSupServiceImpl implements TechSerSupService {
	@Autowired
	TechSerSupMapper supMapper;

	@Override
	public TechSerSup add(TechSerSup sup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TechSerSup> searchByAdmin(TechSerSup sup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TechSerSup> searchByUser(TechSerSup sup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TechSerSup> listByEnt(TechSerSup sup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TechSerSup show(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeState(TechSerSup sup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeInfo(TechSerSup sup) {
		// TODO Auto-generated method stub
		return false;
	}

}
