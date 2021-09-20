package com.wen.progect.progect03.view;

import com.wen.progect.progect03.domain.Employee;
import com.wen.progect.progect03.domain.Programmer;
import com.wen.progect.progect03.service.NameListService;
import com.wen.progect.progect03.service.TeamException;
import com.wen.progect.progect03.service.TeamService;

public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	/**
	 * 
	 * @Descripyion 主界面显示及控制方法
	 * @author wen
	 * @date 2020年3月2日下午10:34:55
	 *
	 */
	public void enterMainMenu() {

		boolean loopFlag = true;
		char menu = 0;

		while (loopFlag) {
			if (menu != '1') {
				listAllEmployee();
			}

			System.out.print("\n1-团队成员    2-添加成员    3-删除团队成员    4-退出    请选择（1-4）： ");

			menu = TSUtility.readMenuSelection();

			switch (menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("是否确认退出(Y/N)：");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
				}
			}
		}

	}

	/**
	 * 
	 * @Descripyion 以表格形式列出公司所有成员
	 * @author wen
	 * @date 2020年3月2日下午10:35:33
	 *
	 */
	private void listAllEmployee() {
		// System.out.println(" 以表格形式列出公司所有成员");

		System.out.println(
				"-----------------------------------------开发团队成员调度软件-----------------------------------------\n");

		Employee[] employees = listSvc.getAllEmployees();

		if (employees == null || employees.length == 0) {
			System.out.println("公司没有任何员工！！！");
		} else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------");

	}

	/**
	 * 
	 * @Descripyion 显示团队成员列表操作
	 * @author wen
	 * @date 2020年3月2日下午10:36:02
	 *
	 */
	private void getTeam() {
		// System.out.println("显示成员列表");
		System.out.println("-----------------------------------------团队成员列表-----------------------------------------");
		Programmer[] team = teamSvc.getTeam();

		if (team == null || team.length == 0) {
			System.out.println("该团队中还没有成员！！！");
		} else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}

		System.out.println("-----------------------------------------------------------------------------------------");
	}

	/**
	 * 
	 * @Descripyion 实现添加成员操作
	 * @author wen
	 * @date 2020年3月2日下午10:41:58
	 *
	 */
	private void addMember() {
		// System.out.println("添加成员");
		System.out.println("-----------------------------------------添加成员-----------------------------------------");
		System.out.print("请输入要添加员工ID：");
		int id = TSUtility.readInt();

		// 获取到该id员工
		try {
			Employee employee = listSvc.getEmployee(id);
			teamSvc.addMember(employee);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因" + e.getMessage());
		}
		TSUtility.readReturn();

	}

	/**
	 * 
	 * @Descripyion 实现删除成员操作
	 * @author wen
	 * @date 2020年3月2日下午10:50:06
	 *
	 */
	private void deleteMember() {
//		System.out.println("删除成员");
		
		System.out.println("-----------------------------------------开发团队成员调度软件-----------------------------------------");
		System.out.print("请输入要删除的员工的TID：");
		int tId = TSUtility.readInt();
		System.out.println("确认是否删除(Y/N)：");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'N'){
			return;
		}
		
		try {
			teamSvc.removeMember(tId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败，原因" + e.getMessage());
		}
		
		TSUtility.readReturn();
		
	}

	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
	}

}
