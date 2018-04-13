package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mapper.TechSerSupMapper;
import pojo.TechSerSup;
import service.TechSerSupService;
import util.DateTimeUtil;

@Service
public class TechSerSupServiceImpl implements TechSerSupService {
	@Autowired
	TechSerSupMapper supMapper;

	@Override
	public TechSerSup add(TechSerSup sup) {
		if (null == sup)
			return sup;
		String dateTime = DateTimeUtil.getDateTime();
		sup.setSup_date(dateTime);
		int i = 0;
		i = supMapper.add(sup);
		if (i == 0)
			return null;
		return sup;
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
		if (null == sup)
			sup = new TechSerSup();
		sup.setState(1);
		List<TechSerSup> list = supMapper.search(sup);
		if (null == list || list.size() == 0)
			return null;
		return list;
	}

	@Override
	public List<TechSerSup> listByEnt(Integer state) {

		return supMapper.listByState(state);
	}

	@Override
	public TechSerSup show(int id) {

		return supMapper.getById(id);
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
