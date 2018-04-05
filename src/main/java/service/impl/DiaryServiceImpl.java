package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.DiaryMapper;
import pojo.Diary;
import service.DiaryService;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Resource
	DiaryMapper diaryMapper;

	@Override
	public boolean add(Diary dia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Diary> search(Diary dia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String dia_text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}

}
