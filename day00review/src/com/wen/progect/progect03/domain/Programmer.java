package com.wen.progect.progect03.domain;

import com.wen.progect.progect03.service.Status;

public class Programmer extends Employee {

	private int memberId;// 用力爱记录成员加入开发团队后在团队中的id
	private Status status = Status.FREE;
	private Equipment equipment;

	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return super.toString() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}

	public String getTeamBaseDetials() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t";
	}

	// 1/4	刘强东	24	7300.0	程序员
	public String getDetailsForTeam() {
		return getTeamBaseDetials() + "程序员";
	}

}
