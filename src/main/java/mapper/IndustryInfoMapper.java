package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.IndustryInfo;

public interface IndustryInfoMapper {

	public IndustryInfo get(int id);

	public List<IndustryInfo> list(@Param("indId")Integer indId, @Param("title")String title);

}
