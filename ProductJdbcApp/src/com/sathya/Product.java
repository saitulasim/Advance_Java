package com.sathya;

public class Product {
int proId;
String proName;
double proPrice;
public Product() {
	super();
}
public Product(int proId, String proName, double proprice) {
	super();
	this.proId = proId;
	this.proName = proName;
	this.proPrice = proprice;
}
public int getProId() {
	return proId;
}
public void setProId(int proId) {
	this.proId = proId;
}
public String getProName() {
	return proName;
}
public void setProName(String proName) {
	this.proName = proName;
}
public double getProPrice() {
	return proPrice;
}
public void setProPrice(double proprice) {
	this.proPrice = proprice;
}
@Override
public String toString() {
	return "Product [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + "]";
}

}
