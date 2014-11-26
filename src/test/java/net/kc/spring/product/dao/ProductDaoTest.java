package net.kc.spring.product.dao;

import net.kc.spring.product.domain.Product;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ProductDaoTest {
	private static Logger logger = LoggerFactory.getLogger(ProductDaoTest.class);
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void setup() {
		//String[] configLocations = new String[] {"classpath:"};
		//ctx = new ClassPathXmlApplicationContext(configLocations);
		String[] configLocations = new String[] {"./src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"};
		ctx = new FileSystemXmlApplicationContext(configLocations);
	}
	
	@Ignore
	public void getProduct() {
		ProductDao dao = (ProductDao) ctx.getBean(ProductDao.class);
		Product p = dao.getById(101L);
		logger.info("product: " + p);
	}

	@Ignore
	public void insertProduct() {
		ProductDao dao = (ProductDao) ctx.getBean(ProductDao.class);
		Product p = new Product();
		p.setNumber("P1");
		p.setName("Product 1");
		dao.insert(p);
	}

	@Test
	public void updateProduct() {
		ProductDao dao = (ProductDao) ctx.getBean(ProductDao.class);
		Product p = dao.getById(107L);
		p.setName("Product 1a");
		dao.save(p);
	}
}
