package net.kc.spring.user.dao;

import java.util.List;

import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;
import net.kc.spring.user.domain.UserGroupItem;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select * from user where id = #{id}")
	public User getUser(Long id);

	@Insert("insert into user values (#{id}, #{username})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertUser(User user);

	@Select("select * from user where username like '%#{username}%'")
	public List<User> findUsers(String username);

	//@Select("select * from user order by id")
	//public List<User> getAllUsers();

	@Insert("insert into user_group values (#{id}, #{name})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertUserGroup(UserGroup userGroup);

	@Insert("insert into user_group_item values (#{id}, #{groupId}, #{user.id})")
	@Options(useGeneratedKeys = true, keyColumn = "id")
	public void insertUserGroupItem3(UserGroupItem item);
	//public Long insertUserGroupItem(Map<String, Object> r);

	//@Select("call identity()")
	//public Long getNewId();
}
