package mapper;

import java.util.List;

import pojo.Admin;

public interface AdminMapper {
	public int add(Admin admin);

	public int update(Admin admin);

	public List<Admin> search();

	public Admin getById(Integer id);

}
