package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.TechSerSup;

public interface TechSerSupMapper {

	public int add(TechSerSup sup);

	public int delete(int id);

	public TechSerSup getById(int id);

	public int update(TechSerSup sup);

	/*
	 * 0审核未通过 1正常 2已匹配 3待审核
	 */
	public List<TechSerSup> listByState(@Param(value = "state") Integer state);

	public List<TechSerSup> search(TechSerSup sup);
}
