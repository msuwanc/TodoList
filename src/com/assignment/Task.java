package com.assignment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task")

public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String subject;
	private String detail;
	private String status;

	public Task() {
	}

	public Task(int id, String subject, String detail, String status) {
		this.id = id;
		this.subject = subject;
		this.detail = detail;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	@XmlElement
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDetail() {
		return detail;
	}

	@XmlElement
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
}
