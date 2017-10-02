package dao;

import java.util.List;

import pojo.Role;
import pojo.User;

public interface UserMapper {
	
	public int count();
	
	public void add(User user);
	public void update(User user);
	public void delete(User user);
	public List<User> getUserList();
	
	//根据RoleId获取用户列表
	
	public List<User> getUserListByRoleId(Role role);
	
	//获取指定用户的地址列表
	public User getAddressListByUserId(User user);

}
