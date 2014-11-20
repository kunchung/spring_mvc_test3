package net.kc.spring.user.domain;

public class UserGroupItem {
	private Long id;
	private Long groupId;
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString() {
		return "id: " + id + ", groupId: " + groupId + ", userId: " + user.getId();
	}
}
