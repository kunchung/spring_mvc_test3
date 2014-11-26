package net.kc.spring.order.domain;

import java.util.List;

import net.kc.spring.common.BaseEntity;

public class Order extends BaseEntity {

	private List<OrderItem> itemList;

	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

}
