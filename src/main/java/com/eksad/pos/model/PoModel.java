package com.eksad.pos.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="purchase_order")
public class PoModel {
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "purchase_order_seq")
	@TableGenerator(name = "purchase_order_seq", table = "tbl_squence", pkColumnName = "seq_id", valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Integer id;
	
	@Column(name="purchase_number")
	private String poNumber;
	
	@Column(name="purchase_date")
	private Date poDate;
	
	@Column(name="notes")
	private String notes;
	
	@Column(name="supplier_id")
	private Integer supplierId;
	
	@Column(name="total_amount")
	private String totalAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date poDateNew = null;
		try {
			poDateNew = format.parse(poDate);
		} catch (Exception e) {
			this.poDate = null;
		}
		this.poDate = poDateNew;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}	
}
