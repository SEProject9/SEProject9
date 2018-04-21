package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.TechSerReqMapper;
import pojo.TechSerReq;
import service.TechSerReqService;
import util.DateTimeUtil;

@Service
public class TechSerReqServiceImpl implements TechSerReqService {
	@Autowired
	TechSerReqMapper reqMapper;

	@Override
	public TechSerReq add(TechSerReq req) {
		if (null == req)
			return null;
		String dateTime = DateTimeUtil.getDateTime();
		req.setReq_date(dateTime);
		int i = 0;
		i = reqMapper.add(req);
		if (i == 0)
			return null;
		return req;
	}

	@Override
	public boolean delete(Integer id) {
		if (1 == reqMapper.delete(id))
			return true;
		return false;
	}

	@Override
	public List<TechSerReq> searchByAdmin(TechSerReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TechSerReq> searchByUser(TechSerReq req) {
		if (null == req)
			req = new TechSerReq();
		req.setState(1);
		List<TechSerReq> list = reqMapper.search(req);
		if (null == list || list.size() == 0)
			return null;
		return list;
	}

	/*state
	ent_id*/
	@Override
	public List<TechSerReq> listByEnt(Integer state, Integer ent_id) {
		TechSerReq req = new TechSerReq();
		req.setState(state);
		req.setEnt_id(ent_id);
		return reqMapper.search(req);
	}

	@Override
	public TechSerReq show(int id) {

		return reqMapper.getById(id);
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
