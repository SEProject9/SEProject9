package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.TechSerReqMapper;
import pojo.TechSerReq;
import service.TechSerReqService;

@Service
public class TechSerReqServiceImpl implements TechSerReqService{
	@Autowired
	TechSerReqMapper reqMapper;

	@Override
	public TechSerReq add(TechSerReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TechSerReq> searchByAdmin(TechSerReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TechSerReq> searchByUser(TechSerReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TechSerReq> listhByEnt(Integer state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TechSerReq show(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeState(TechSerReq req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeInfo(TechSerReq req) {
		// TODO Auto-generated method stub
		return false;
	}

}
