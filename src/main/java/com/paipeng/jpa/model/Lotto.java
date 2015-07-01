package com.paipeng.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


@NamedQueries({
	@NamedQuery(name=Lotto.getSum, query="SELECT l.z1+l.z2+l.z3+l.z4+l.z5+l.z6 from Lotto l WHERE l.id=:lottoId"),
	@NamedQuery(name=Lotto.getLastLotto, query="SELECT l from Lotto l order by l.id desc")
})

@XmlRootElement
@Entity
@Table(name = "lotto")
public class Lotto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String getSum = "Lotto.getSum";
	public static final String getLastLotto = "Lotto.getLastLotto";
	
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
	
	@Transient
	private int sum;

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


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}



	
}
