package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.TechSerReq;

public interface TechSerReqMapper {

	public int add(TechSerReq req);

	public void delete(int id);

	public TechSerReq getById(int id);

	public int update(TechSerReq req);

	/*
	 * 0审核未通过 1正常 2已匹配 3待审核(再次审核)
	 */
	public List<TechSerReq> listByState(@Param(value = "state") Integer state);

	public List<TechSerReq> search(TechSerReq req);
}
