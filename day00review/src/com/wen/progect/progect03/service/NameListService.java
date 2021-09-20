package com.wen.progect.progect03.service;

import com.wen.progect.progect03.domain.Architect;
import com.wen.progect.progect03.domain.Designer;
import com.wen.progect.progect03.domain.Employee;
import com.wen.progect.progect03.domain.Equipment;
import com.wen.progect.progect03.domain.PC;
import com.wen.progect.progect03.domain.Printer;
import com.wen.progect.progect03.domain.Programmer;
import com.wen.progect.progect03.domain.NoteBook;

import static com.wen.progect.progect03.service.Data.*;

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * 
 * @Descripyion 描述
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月2日下午2:28:27
 *
 */
public class NameListService {

	private Employee[] employees;// 用来保存公司所有员工对象

	/**
	 * 
	 * @param employee
	 *            1.根据项目提供的Data类构建相应大小的employees数组
	 *            2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
	 *            3.将对象存于数组中
	 */
	public NameListService() {
		// 1.根据项目提供的Data类构建相应大小的employees数组
		// employees = new Employee[Data.EMPLOYEES.length];
		employees = new Employee[EMPLOYEES.length];

		// 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
		for (int i = 0; i < employees.length; i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);

			// 获取员工的基本信息 Archiect : 13, id, name, age,salary, bonus, stock
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);

			// Equipment equipment = createEquipment(i);//错误 第i个员工不一定有Equipment
			Equipment equipment;
			double bonus;

			switch (type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				int stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}

	}

	/**
	 * 获取指定index员工的设备
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年3月2日下午7:40:05
	 * @param index
	 * @return
	 *
	 */
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);

		switch (type) {
		case PC:// 21
			return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		case NOTEBOOK:// 22
			return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
		case PRINTER:// 23
			return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		}
		return null;
	}

	/**
	 * 获取当前所有员工
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年3月2日下午2:30:20
	 * @return 包含所有员工对象数组
	 *
	 */
	public Employee[] getAllEmployees() {
		return employees;

	}

	/**
	 * 获取指定id的员工
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年3月2日下午8:04:53
	 * @param id
	 * @return
	 * @throws TeamException
	 *
	 */
	public Employee getEmployee(int id) throws TeamException {

		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}

		throw new TeamException("找不到指定的员工");

	}

}
