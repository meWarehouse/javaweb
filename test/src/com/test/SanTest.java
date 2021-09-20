package com.test;

public class SanTest {

	double a;
	double b;
	double c;
	
	double perimeter;
	//海伦公式 S=sqrt[p(p-a)(p-b)(p-c)] p为周长的一半
	double area;
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public double getPerimeter() {
		return (a+b+c);
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	public double getArea() {
		double p = getPerimeter()/2;
		return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
	}
	public void setArea(double area) {
		this.area = area;
	}

	
	
	

}
