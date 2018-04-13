package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.IndustryData;

public interface IndustryDataMapper {

	public IndustryData get(Integer id);

	public List<IndustryData> list(@Param("indId") Integer indId, @Param("title") String title);

}
