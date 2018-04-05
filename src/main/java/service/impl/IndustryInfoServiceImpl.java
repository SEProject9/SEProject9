package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.IndustryInfoMapper;
import pojo.IndustryInfo;
import service.IndustryInfoService;

@Service
public class IndustryInfoServiceImpl implements IndustryInfoService {
	@Autowired
	IndustryInfoMapper infoMapper;

	@Override
	public IndustryInfo show(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IndustryInfo> list(Integer indId) {
		System.out.println("test");
		return infoMapper.list(indId);
	}

}
