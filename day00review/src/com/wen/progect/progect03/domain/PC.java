package com.wen.progect.progect03.domain;

public class PC implements Equipment {

	private String model;
	private String display;// 显示器型号

	public PC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String getDescription() {
		return model + "(" + display + ")";
	}

}
