package com.exedy;

public class Product {
	private int productId;
	private String productName;
	private double functionality;
	private double performance;
	private double usability;
	private double cost;
	private double value;
	private double environmentalImpact;
	private double customerFeedback;
	private int UserId;

	public Product(int productId, String productName, double functionality, double performance, double usability,
			double cost, double value, double environmentalImpact, double customerFeedback) {
		this.productId = productId;
		this.productName = productName;
		this.functionality = functionality;
		this.performance = performance;
		this.usability = usability;
		this.cost = cost;
		this.value = value;
		this.environmentalImpact = environmentalImpact;
		this.customerFeedback = customerFeedback;
	}

	public Product(String productName, double functionality, double performance, double usability, double cost,
			double value, double environmentalImpact, double customerFeedback,int UserId) {

		this.productName = productName;
		this.functionality = functionality;
		this.performance = performance;
		this.usability = usability;
		this.cost = cost;
		this.value = value;
		this.environmentalImpact = environmentalImpact;
		this.customerFeedback = customerFeedback;
		this.UserId = UserId;
	}

	// Add getters and setters for the fields

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getFunctionality() {
		return functionality;
	}

	public void setFunctionality(double functionality) {
		this.functionality = functionality;
	}

	public double getPerformance() {
		return performance;
	}

	public void setPerformance(double performance) {
		this.performance = performance;
	}

	public double getUsability() {
		return usability;
	}

	public void setUsability(double usability) {
		this.usability = usability;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getEnvironmentalImpact() {
		return environmentalImpact;
	}

	public void setEnvironmentalImpact(double environmentalImpact) {
		this.environmentalImpact = environmentalImpact;
	}

	public double getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(double customerFeedback) {
		this.customerFeedback = customerFeedback;
	}
	
	public int getUserid() {
		return UserId;
	}
	
	public void setUserId(int UserId) {
		this.UserId = UserId;
	}
}
