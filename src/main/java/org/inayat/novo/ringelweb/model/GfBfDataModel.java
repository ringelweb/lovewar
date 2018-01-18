package org.inayat.novo.ringelweb.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "gfbfdata_table")
@Table(name = "gfbfdata_table")
public class GfBfDataModel {
	private String id;
	private String name;
	private int    age;
	private String sex;
	private String whatsappno;
	private String returnedmsg;
	private String exception;
	private Boolean success;
	
	
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getReturnedmsg() {
		return returnedmsg;
	}

	public void setReturnedmsg(String returnedmsg) {
		this.returnedmsg = returnedmsg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWhatsappno() {
		return whatsappno;
	}

	public void setWhatsappno(String whatsappno) {
		this.whatsappno = whatsappno;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
