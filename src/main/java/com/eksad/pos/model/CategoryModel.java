package com.eksad.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryModel {
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="category_code")
	private String code;
	
	@Column(name="category_name")
	private String name;
}
