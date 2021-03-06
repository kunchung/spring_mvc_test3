package net.kc.spring.user.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import net.kc.spring.common.BaseEntity;

//@Entity
//@Table(name = "user")
public class User extends BaseEntity {

	@Size(min = 1, max = 30)
	private String name;

	private Date dateOfBirth;

	//	@Id
	//	@GeneratedValue(strategy = GenerationType.AUTO)
	//	@Column(name = "id")
	//	public Long getId() {
	//		return id;
	//	}
	//
	//	public void setId(Long id) {
	//		this.id = id;
	//	}

	//	@Column(name = "username")
	@Size(min = 1, max = 30)
	public String getUsername() {
		return getNumber();
	}

	public void setUsername(String username) {
		this.setNumber(username);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String toString() {
		return "id: " + getId() + ", username: " + getUsername() + ", name: " + getName() + ", createDate: " + getCreateDate() + ", updateDate: " + getUpdateDate();
	}
}
