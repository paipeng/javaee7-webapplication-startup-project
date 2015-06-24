package com.paipeng.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lotto")
public class Lotto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, name = "l1")
	private int l1;
	
	@Column(nullable=false, name = "l2")
	private int l2;
	
	@Column(nullable=false, name = "l3")
	private int l3;
	
	@Column(nullable=false, name = "l4")
	private int l4;
	
	@Column(nullable=false, name = "l5")
	private int l5;
	
	@Column(nullable=false, name = "l6")
	private int l6;
	
	@Column(nullable=false, name = "s")
	private int s;
	

	public Lotto() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getL1() {
		return l1;
	}


	public void setL1(int l1) {
		this.l1 = l1;
	}


	public int getL2() {
		return l2;
	}


	public void setL2(int l2) {
		this.l2 = l2;
	}


	public int getL3() {
		return l3;
	}


	public void setL3(int l3) {
		this.l3 = l3;
	}


	public int getL4() {
		return l4;
	}


	public void setL4(int l4) {
		this.l4 = l4;
	}


	public int getL5() {
		return l5;
	}


	public void setL5(int l5) {
		this.l5 = l5;
	}


	public int getL6() {
		return l6;
	}


	public void setL6(int l6) {
		this.l6 = l6;
	}


	public int getS() {
		return s;
	}


	public void setS(int s) {
		this.s = s;
	}


	
}
