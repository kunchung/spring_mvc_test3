package net.kc.spring.user.service;

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
	public void testSaveUser() {
		UserService service = (UserService) ctx.getBean(UserService.class);
		User user = new User();
		user.setId(5L);
		user.setUsername("user4");
		user.setName("user 4");
		service.saveUser(user);
	}
	
	//@Test
	public void testGetUser() {
		UserService userService = (UserService) ctx.getBean(UserService.class);
		String username = "user1";
		User user = userService.getUser(username);
		System.out.println("User: " + user);
	}

	//@Test
	public void testCreateUser() {
		UserService userService = (UserService) ctx.getBean(UserService.class);
		User user = new User();
		user.setUsername("user test");
		userService.createUser(user);
		List<User> userList = userService.getAllUsers();
		System.out.println(userList);
	}
}
