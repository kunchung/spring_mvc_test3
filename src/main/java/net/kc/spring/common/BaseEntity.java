package net.kc.spring.common;

import java.util.Date;

import javax.validation.constraints.NotNull;

public abstract class BaseEntity {
	private Long id;

	//@Size(min = 10, max = 30)
	// constraint should be specified by subclass
	private String number;
	
	@NotNull
	private Date createDate;
	private Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
