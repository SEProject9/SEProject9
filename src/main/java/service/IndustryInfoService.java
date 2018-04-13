package service;

import java.util.List;
import pojo.IndustryInfo;

public interface IndustryInfoService {
	public IndustryInfo show(int id);

	public List<IndustryInfo> list(Integer indId,String title);

}
