package mapper;

import java.util.List;
import pojo.Enterprise;

public interface EnterpriseMapper {

	public int add(Enterprise ent);

	public int delete(Integer id);

	public Enterprise getById(Integer id);

	// 更新密码/状态
	public int update(Enterprise ent);

	/*搜索
	 * 状态
	 * 企业名
	 * 地址*/
	public List<Enterprise> search(Enterprise ent);

	/*使用pageHelper工具
	 * public int count();*/
}
