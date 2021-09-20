package com.wen.progect.progect02.ui;

import com.wen.progect.progect02.bean.Customer;
import com.wen.progect.progect02.service.CustomerList;
import com.wen.progect.progect02.util.CMUtility;

/**
 * 
 * @Descripyion CustomerView为主模块，负责菜单的显示和处理用户操作
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年2月21日下午1:21:02
 *
 */
public class CustomerView {

	private CustomerList customerList = new CustomerList(10);// 创建CustomerList对象
																// 并创建出customer[10]

	public CustomerView() {
//		Customer customer = new Customer("王涛", '男', 23, "12345678912", "wt@goole.com");
//		customerList.addCustomer(customer);
	}

	/**
	 * 
	 * @Descripyion 显示用户信息管理软件界面的方法
	 * @author wen
	 * @date 2020年2月21日下午1:27:48
	 *
	 */
	public void enterMainMenu() {

		boolean isFlag = true;
		while (isFlag) {
			System.out.println("\n--------------------客户信息管理软件--------------------");
			System.out.println("						1.添加客户");
			System.out.println("						2.修改客户");
			System.out.println("						3.删除客户");
			System.out.println("						4.客户列表");
			System.out.println("						5.退	 出");
			System.out.print("						请选择(1-5)：");

			char selectMenu = CMUtility.readMenuSelection();

			switch (selectMenu) {
			case '1':
				// 添加客户操作
				addNewCustomer();
				break;
			case '2':
				// 修改客户
				modifyCustomer();
				break;
			case '3':
				// 删除客户
				deleteCustomer();
				break;
			case '4':
				// 客户列表
				listAllCustomers();
				break;
			case '5':
				// 退出
				System.out.print("确认是否退出(Y/N)：");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
				}
			}
		}

	}

	/**
	 * 
	 * @Descripyion 添加新客户操作
	 * @author wen
	 * @date 2020年2月21日下午1:28:07
	 *
	 */
	private void addNewCustomer() {
		// System.out.println("添加新客户");

		System.out.println("--------------------添加客户--------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(13);
		System.out.print("邮箱：");
		String email = CMUtility.readString(30);

		// customerList.addCustomer(new Customer(name, gender, age, phone,
		// email));
		Customer cust = new Customer(name, gender, age, phone, email);
		boolean isSuccess = customerList.addCustomer(cust);
		if (isSuccess) {
			System.out.println("--------------------添加成功--------------------");
		} else {
			System.out.println("--------------------客户已满，添加失败--------------------");
		}

	}

	/**
	 * 
	 * @Descripyion 修改客户操作
	 * @author wen
	 * @date 2020年2月21日下午1:28:26
	 *
	 */
	private void modifyCustomer() {
		// System.out.println("修改客户操作");
		System.out.println("--------------------修改客户--------------------");
		Customer cust;
		int number;
		for (;;) {
			System.out.print("请选择待修改客户的编号(-1退出)：");
			number = CMUtility.readInt();

			if (number == -1) {
				return;
			}

			cust = customerList.getCustomer(number-1);
			if (cust == null) {
				System.out.println("无法找到指定的客户！！！");
			} else
				break;
		}
		// 修改客户信息 姓名\t性别\t年龄\t电话\t\t\t邮箱"
		System.out.print("姓名(" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("性别(" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("年龄(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("电话(" + cust.getPhone() + ")");
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.print("邮箱(" + cust.getEmail() + ")");
		String email = CMUtility.readString(30, cust.getEmail());

		Customer newCust = new Customer(name, gender, age, phone, email);

		boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
		if (isReplaced) {
			System.out.println("--------------------修改成功--------------------");
		} else {
			System.out.println("--------------------修改失败--------------------");
		}
	}

	/**
	 * 
	 * @Descripyion 删除客户
	 * @author wen
	 * @date 2020年2月21日下午1:29:05
	 *
	 */
	private void deleteCustomer() {
//		System.out.println("删除客户");
		int number;
		for(;;){
			System.out.print("请选择待删除客户的编号(-1退出)：");
			number = CMUtility.readInt();
			
			if(number == -1){
				return;
			}
			
			Customer customer = customerList.getCustomer(number-1);
			if(customer == null){
				System.out.println("无法找到指定的客户！！！");
			}else break;
		}
		
		//找到了指定的客户
		System.out.println("确认是否删除(Y/N):");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete == 'Y'){
			boolean deleteSuccess = customerList.deleteCustomer(number-1);
			if(deleteSuccess){
				System.out.println("--------------------删除成功--------------------");
			}else{
				System.out.println("--------------------删除失败--------------------");
			}
		}
		
		
		
	}

	/**
	 * 
	 * @Descripyion 客户列表
	 * @author wen
	 * @date 2020年2月21日下午1:29:52
	 *
	 */
	private void listAllCustomers() {
		System.out.println("--------------------客户列表--------------------");

		int total = customerList.getTotal();
		if (total == 0) {
			System.out.println("没有客户记录！！！");
		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
						+ "\t" + cust.getPhone() + "\t\t" + cust.getEmail());
			}

		}

		System.out.println("--------------------客户列表完成--------------------");

	}

	public static void main(String[] args) {
		CustomerView cv = new CustomerView();
		cv.enterMainMenu();
	}

}
