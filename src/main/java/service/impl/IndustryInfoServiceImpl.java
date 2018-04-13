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
		return infoMapper.get(id);
	}

	@Override
	public List<IndustryInfo> list(Integer indId, String title) {
		return infoMapper.list(indId, title);
	}

}
