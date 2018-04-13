package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.IndustryMapper;
import pojo.Industry;
import service.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {
	@Autowired
	IndustryMapper industryMapper;

	@Override
	public List<Industry> list() {
		return industryMapper.list();
	}

	@Override
	public Industry getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
