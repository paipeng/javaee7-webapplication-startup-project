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

	@Column(nullable=false, columnDefinition = "TINYINT(1)")
	private int z1;
	
	@Column(nullable=false, columnDefinition = "TINYINT(1)")
	private int z2;
	
	@Column(nullable=false, columnDefinition = "TINYINT(1)")
	private int z3;
	
	@Column(nullable=false, columnDefinition = "TINYINT(1)")
	private int z4;
	
	@Column(nullable=false, columnDefinition = "TINYINT(1)")
	private int z5;
	
	@Column(nullable=false, columnDefinition = "TINYINT(1)")
	private int z6;
	
	@Column(nullable=false, columnDefinition = "TINYINT(1)")
	private int zs;
	

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


	public int getZ1() {
		return z1;
	}


	public void setZ1(int z1) {
		this.z1 = z1;
	}


	public int getZ2() {
		return z2;
	}


	public void setZ2(int z2) {
		this.z2 = z2;
	}


	public int getZ3() {
		return z3;
	}


	public void setZ3(int z3) {
		this.z3 = z3;
	}


	public int getZ4() {
		return z4;
	}


	public void setZ4(int z4) {
		this.z4 = z4;
	}


	public int getZ5() {
		return z5;
	}


	public void setZ5(int z5) {
		this.z5 = z5;
	}


	public int getZ6() {
		return z6;
	}


	public void setZ6(int z6) {
		this.z6 = z6;
	}


	public int getZs() {
		return zs;
	}


	public void setZs(int zs) {
		this.zs = zs;
	}



	
}
