package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.TechSerMatchMapper;
import service.TechSerMatchService;

public class TechSerMatchServiceImpl implements TechSerMatchService{
	@Autowired
	TechSerMatchMapper matchMapper;
	
}
