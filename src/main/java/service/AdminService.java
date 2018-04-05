package service;

import java.util.List;

import pojo.Admin;

public interface AdminService {

	boolean add(Admin admin);

	// 成功返回对象设置session;失败返回null
	Admin login(Admin admin);

	List<Admin> search();

	boolean resetPasswork(Admin admin);

	Admin show(Integer id);

}
