package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.IndustryInfoMapper;
import pojo.IndustryInfo;
import service.IndustryInfoService;
import util.FileStreamUtil;

@Service
public class IndustryInfoServiceImpl implements IndustryInfoService {
	@Autowired
	IndustryInfoMapper infoMapper;

	@Override
	public IndustryInfo show(int id) {
		IndustryInfo indInfo = infoMapper.get(id);
		String txtUrl = indInfo.getText();
		System.out.println(txtUrl);
		if (null != txtUrl) {
			StringBuffer txt=FileStreamUtil.readLogInfo(txtUrl);
			indInfo.setText(txt.toString());
		}
		return indInfo;
	}

	@Override
	public List<IndustryInfo> list(Integer indId, String title) {
		return infoMapper.list(indId, title);
	}

}
