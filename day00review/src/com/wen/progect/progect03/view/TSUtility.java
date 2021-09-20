package com.wen.progect.progect03.view;

import java.util.Scanner;

/**
 * 读取键盘数据并进行返回
 * 
 * @Descripyion
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月1日下午10:36:05
 *
 */
public class TSUtility {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @Descripyion 读取键盘，如果用户键入‘1’~‘4’中的任意字符，则返回，返回值为用户键入字符
	 * @author wen
	 * @date 2020年3月1日下午10:57:45
	 * @return
	 *
	 */
	public static char readMenuSelection() {
		char c;

		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c == '1' || c == '2' || c == '3' || c == '4') {
				break;
			} else {
				System.out.print("输入错误，请重新输入：");
			}
		}

		return c;
	}

	/**
	 * 
	 * @Descripyion 提示等待，直到用户按回车键返回
	 * @author wen
	 * @date 2020年3月1日下午11:00:02
	 *
	 */
	public static void readReturn() {
		System.out.print("按回车键继续...");
		readKeyBoard(100, true);
	}

	/**
	 * 
	 * @Descripyion 从键盘读取一个不超过两位数的整数，并返回
	 * @author wen
	 * @date 2020年3月1日下午11:01:11
	 * @return
	 *
	 */
	public static int readInt() {

		int n;
		for (;;) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (Exception e) {
				System.out.print("输入错误，请输入数字：");
			}
		}

		return n;
	}

	/**
	 * 
	 * @Descripyion 从键盘读取'X'或'Y'，并将其作为返回值
	 * @author wen
	 * @date 2020年3月1日下午11:02:47
	 * @return
	 *
	 */
	public static char readConfirmSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if (c == 'N' || c == 'Y') {
				break;
			} else
				System.out.print("选择错误，请重新选择：");
		}

		return c;
	}

	/**
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年3月1日下午10:38:42
	 * @param limit
	 *            字符串位数
	 * @param blankReturn
	 *            true不返回数据 false返回数据
	 * @return 返回字符串
	 */
	private static String readKeyBoard(int limit, boolean blankReturn) {

		String line = "";

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (blankReturn) {
					return line;
				} else
					continue;
			}

			if (line.length() < 1 || line.length() > limit) {
				System.out.print("输入的长度（不大于" + limit + "）错误，请重新输入：");
				continue;
			}
			break;
		}

		return line;

	}

}
