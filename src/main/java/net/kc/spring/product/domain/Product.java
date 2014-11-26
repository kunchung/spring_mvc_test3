package net.kc.spring.product.domain;

import net.kc.spring.common.BaseEntity;

public class Product extends BaseEntity {

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
