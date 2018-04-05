package mapper;

import java.util.List;

import pojo.IndustryData;

public interface IndustryDataMapper {

	public IndustryData get(Integer id);

	public List<IndustryData> list(Integer indId);

}
