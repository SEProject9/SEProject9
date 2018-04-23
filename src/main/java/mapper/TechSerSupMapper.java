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
	 * null为全部,会给mybatis替代为0  所以0不能设状态   好像又不是了...
	 * 应该改为4审核未通过
	 */
	public List<TechSerSup> listByState(@Param(value = "state") Integer state);

	public List<TechSerSup> search(TechSerSup sup);
}
