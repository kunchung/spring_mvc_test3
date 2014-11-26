package net.kc.spring.product.dao;

import net.kc.spring.product.domain.Product;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ProductDaoTest {
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void setup() {
		//String[] configLocations = new String[] {"classpath:"};
		//ctx = new ClassPathXmlApplicationContext(configLocations);
		String[] configLocations = new String[] {"./src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"};
		ctx = new FileSystemXmlApplicationContext(configLocations);
	}
	
	@Test
	public void testGetProduct() {
		ProductDao dao = (ProductDao) ctx.getBean(ProductDao.class);
		Product p = dao.getProduct(101L);
		System.out.println("product: " + p);
	}
}
