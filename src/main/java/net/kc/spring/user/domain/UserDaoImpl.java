package net.kc.spring.user.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    // @Autowired
    // private SqlSession sqlSession;

    @Autowired
    private UserMapper mapper;

    @Override
    public Long createUser(User user) {
	// UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	mapper.createUser(user);
	// Long id = mapper.getNewId();
	// sqlSession.insert("net.kc.spring.user.UserMapper.createUser", user);
	// Long id = sqlSession.selectOne("net.kc.spring.user.UserMapper.getNewId");
	// user.setId(id);
	return user.getId();
    }

    @Override
    public User getUser(Long userId) {
	// UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	return mapper.getUser(userId);
	// return (User) sqlSession.selectOne("net.kc.spring.user.UserMapper.getUser",
	// userId);
    }

    @Override
    public List<User> findUsers(String username) {
	// UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	return mapper.findUsers(username);
	// return sqlSession.selectList("net.kc.spring.user.UserMapper.findUsers");
    }

}
