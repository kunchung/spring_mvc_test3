package net.kc.spring.product.dao;

import net.kc.spring.product.domain.Product;

public interface ProductDao {
	public Product getById(Long id);
	
	public Long insert(Product product);

	public void update(Product product);
	
	public void save(Product product);
}
