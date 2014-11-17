package net.kc.spring.user.domain;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User getUser(Long id);

    @Insert("insert into user values (#{id}, #{username})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long createUser(User user);

    @Select("select * from user where username like '%#{username}%'")
    public List<User> findUsers(String username);

    @Select("call identity()")
    public Long getNewId();
}
