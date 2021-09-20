package com.test;

public class Rectangle {

	private double width;
    private double length;
    private double area;
    private double perimeter;
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getArea() {
		return width*length;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPerimeter() {
		return 2*(width*length);
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
    
    
}
