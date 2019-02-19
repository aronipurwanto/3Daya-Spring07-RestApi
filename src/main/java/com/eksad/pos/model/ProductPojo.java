package com.eksad.pos.model;

import java.util.List;

public class ProductPojo {
	private List<ProductModel> products;
	private List<PackageModel> packages;
	private List<CategoryModel> categories;
	
	public List<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}
	public List<PackageModel> getPackages() {
		return packages;
	}
	public void setPackages(List<PackageModel> packages) {
		this.packages = packages;
	}
	public List<CategoryModel> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}
}
