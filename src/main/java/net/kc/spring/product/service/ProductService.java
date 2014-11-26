package net.kc.spring.product.service;

import net.kc.spring.product.domain.Product;

public interface ProductService {
	public Product getProduct(Long id);

	public Long createProduct(Product product);

	public void saveProduct(Product product);
}
