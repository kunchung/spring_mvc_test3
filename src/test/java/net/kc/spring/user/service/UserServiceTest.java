package net.kc.spring.user.service;

import java.io.File;
import java.util.List;

import net.kc.spring.user.domain.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserServiceTest {
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void setup() {
		//String[] configLocations = new String[] {"classpath:"};
		//ctx = new ClassPathXmlApplicationContext(configLocations);
		String[] configLocations = new String[] {"./src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"};
		ctx = new FileSystemXmlApplicationContext(configLocations);
	}

	@Test
	public void testCreateUser() {
		UserService userService = (UserService) ctx.getBean(UserService.class);
		User user = new User();
		user.setUsername("user test");
		userService.createUser(user);
		List<User> userList = userService.getAllUsers();
		System.out.println(userList);
	}
}
