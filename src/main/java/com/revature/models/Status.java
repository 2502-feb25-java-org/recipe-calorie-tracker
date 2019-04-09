package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="STATUS")
public class Status {

	@Id
	@Column(name="STATUS_ID")
	@GeneratedValue(generator="STATUS_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="STATUS_SEQ_GEN", sequenceName="STATUS_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="STATUS_NAME", nullable=false)
	private String statusName;
	
	public Status() { }

	public Status(int id, String statusName) {
		super();
		this.id = id;
		this.statusName = statusName;
	}

	public Status(String statusName) {
		super();
		this.statusName = statusName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", statusName=" + statusName + "]";
	}
}
