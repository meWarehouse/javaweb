package com.kc.mvc;

public class Student {

	private Integer id;
	private Long idCard;
	private String name;
	private String sex;
	private Double height;
	private String colation;
	private Integer classes;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, Long idCard, String name, String sex, Double height, String colation, Integer classes) {
		super();
		this.id = id;
		this.idCard = idCard;
		this.name = name;
		this.sex = sex;
		this.height = height;
		this.colation = colation;
		this.classes = classes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getColation() {
		return colation;
	}

	public void setColation(String colation) {
		this.colation = colation;
	}

	public Integer getClasses() {
		return classes;
	}

	public void setClasses(Integer classes) {
		this.classes = classes;
	}

}
