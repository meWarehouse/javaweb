package com.wen.progect.progect03.domain;

public class Architect extends Designer {

	private int stock;// 股票

	public Architect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t"
				+ getEquipment().getDescription();
	}

	// 3/2	马化腾	32	18000.0	架构师	15000.0	2000
	public String getDetailsForTeam() {
		return getTeamBaseDetials() + "架构师\t" + getBonus() + "\t" + stock;
	}
}
