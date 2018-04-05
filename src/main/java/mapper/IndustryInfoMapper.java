package mapper;

import java.util.List;

import pojo.IndustryInfo;

public interface IndustryInfoMapper {

	public IndustryInfo get(int id);

	public List<IndustryInfo> list(Integer indId);

}
