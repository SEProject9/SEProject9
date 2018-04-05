package service.impl;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.IndustryDataMapper;
import pojo.IndustryData;
import service.IndustryDataService;

@Service
public class IndustryDataServiceImpl implements IndustryDataService {
	@Autowired
	IndustryDataMapper dataMapper;

	@Override
	public IndustryData show(Integer id) {
		return dataMapper.get(id);
	}

	@Override
	public List<IndustryData> list(Integer indId) {
		System.out.println("test");
		return dataMapper.list(indId);
	}

}
