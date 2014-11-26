package net.kc.spring.product.service;

import net.kc.spring.product.dao.ProductDao;
import net.kc.spring.product.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public Product getProduct(Long id) {
		return dao.getById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public Long createProduct(Product product) {
		return dao.insert(product);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void saveProduct(Product product) {
		dao.save(product);
	}

}
