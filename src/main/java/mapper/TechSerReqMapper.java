package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.TechSerReq;

public interface TechSerReqMapper {

	public int add(TechSerReq req);

	public int delete(int id);

	public TechSerReq getById(int id);

	public int update(TechSerReq req);

	/*
	 * 0审核未通过 1正常 2已匹配 3待审核(再次审核)
	 * * null为全部,会给mybatis替代为0  所以0不能设状态    好像又不是了...
	 * 应该改为4审核未通过
	 */
	public List<TechSerReq> listByState(@Param(value = "state") Integer state);

	public List<TechSerReq> search(TechSerReq req);
}
