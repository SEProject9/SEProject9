package service;

import java.util.List;
import pojo.TechSerReq;

public interface TechSerReqService {

	TechSerReq add(TechSerReq req);

	boolean delete(int id);

	List<TechSerReq> searchByAdmin(TechSerReq req);

	/*搜索
	 * 行业id
	 * 标题*/
	List<TechSerReq> searchByUser(TechSerReq req);

	// 企业显示自己的发布
	List<TechSerReq> listByEnt(Integer state);

	TechSerReq show(int id);

	// 管理员审核更改状态
	boolean changeState(TechSerReq req);

	// 用户更改信息
	boolean changeInfo(TechSerReq req);

}
