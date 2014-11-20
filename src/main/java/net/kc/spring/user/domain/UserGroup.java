package net.kc.spring.user.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserGroup {
	private Long id;
	private String name;
	private List<UserGroupItem> itemList;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Column(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public List<UserGroupItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<UserGroupItem> userList) {
		this.itemList = userList;
	}

	public String toString() {
		return "id: " + id + ", name: " + name;
	}
}
