package net.kc.spring.user.domain;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select * from user where id = #{id}")
	public User getUser(Long id);
	
	@Select ("insert into user values (#{id}, #{username})")
	public Long createUser(User user);
	
	@Select ("select * from user where username like '%#{username}%'")
	public List<User> findUsers(String username);
	
	@Select ("call identity()")
	public Long getNewId();
}
