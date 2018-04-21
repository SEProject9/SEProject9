package mapper;

import java.util.List;

import pojo.EnterpriseInfo;

public interface EnterpriseInfoMapper {

	public int add(EnterpriseInfo ei);

	public int delete(int id);

	public EnterpriseInfo get(int id);

	public int update(EnterpriseInfo ei);

	/*默认显示所有通过审核的(管理员人员不用到)
	 * 行业
	 * 企业名字
	 * 企业地址*/
	public List<EnterpriseInfo> search(EnterpriseInfo ei);
}
