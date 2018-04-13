package mapper;

import java.util.List;

import pojo.Industry;

public interface IndustryMapper {

	public List<Industry> list();

	public Industry get(Integer id);

}
