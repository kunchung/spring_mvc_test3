package net.kc.spring.product.domain;

import javax.validation.constraints.Size;

import net.kc.spring.common.BaseEntity;

public class Product extends BaseEntity {

	@Size(min = 1, max=100)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "id: " + getId() + ", number: " + getNumber();
	}
}
