package com.wen.progect.progect02.util;

import java.util.Scanner;

public class CMUtility {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @Descripyion 用于界面菜单的选择。该方法读取键盘，如果用户键入‘1’~‘5’中的任意字符，则方法返回，返回值为用户键入的字符
	 * @author wen
	 * @date 2020年2月20日下午10:58:24
	 * @return
	 *
	 */
	public static char readMenuSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
				System.out.print("输入错误请重新输入：");
			} else
				break;
		}
		return c;
	}

	/**
	 * 
	 * @Descripyion 从键盘读取一个字符，并作为方法的返回值
	 * @author wen
	 * @date 2020年2月20日下午11:04:26
	 * @return
	 *
	 */
	public static char readChar() {
		String str = readKeyBoard(1, false);
		return str.charAt(0);
	}

	/**
	 * 
	 * @Descripyion 从键盘读取一个字符，并将其作为方法的返回值，如果用户不输入字符而是直接回车，奖罚将以defaultValue作为返回值
	 * @author wen
	 * @date 2020年2月20日下午11:08:39
	 * @param defaultValue 默认值
	 * @return
	 *
	 */
	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1, true);
		return (str.length() == 0) ? defaultValue : str.charAt(0);
	}

	/**
	 * 
	 * @Descripyion 从键盘读取一个长度不超过2位数的整数，并将其作为返回值,
	 * @author wen
	 * @date 2020年2月20日下午11:12:49
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
			} catch (NumberFormatException e) {
				System.out.println("数字输入错误，请重新输入：");
			}
		}
		return n;
	}

	/**
	 * 
	 * @Descripyion 从键盘读取一个长度不超过2位数的整数，并将其作为返回值,如果用户不输入字符而是直接回车，奖罚将以defaultValue作为返回值
	 * @author wen
	 * @date 2020年2月20日下午11:31:03
	 * @param defaultValue
	 * @return
	 *
	 */
	public static int readInt(int defaultValue) {
		int n;
		for (;;) {
			String str = readKeyBoard(2, true);
			if (str.equals("")) {
				return defaultValue;
			}

			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.println("数字输入错误，请重新输入：");
			}
		}
		return n;
	}

	/**
	 * 
	 * @Descripyion 从键盘读取一个不超过limit的字符串，并将其作为方法的返回值
	 * @author wen
	 * @date 2020年2月20日下午11:33:33
	 * @param limit
	 * @return
	 *
	 */
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}

	/**
	 * 
	 * @Descripyion 从键盘读取一个长度不超过limit的字符串 并将其作为方法的返回值
	 *              如果用户不输入字符串而直接回车，方法将以defaultValue作为返回值
	 * @author wen
	 * @date 2020年2月20日下午11:36:27
	 * @param limit
	 * @param defaultValue
	 * @return
	 *
	 */
	public static String readString(int limit, String defaultValue) {
		String str = readKeyBoard(limit, true);
		return str.equals("") ? defaultValue : str;
	}

	/**
	 * 
	 * @Descripyion 用于确定选择输入，该方法从键盘读取'Y'或'N'，并将其作为方法的返回值
	 * @author wen
	 * @date 2020年2月20日下午11:39:19
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
			} else {
				System.out.println("选择错误，请重新输入：");
			}
		}
		return c;
	}

	/**
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年2月20日下午11:55:09
	 * @param limit
	 * @param blankReturn
	 * @return
	 *
	 */
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (blankReturn) {
					return line;
				} else {
					continue;
				}
			}

			if (line.length() < 1 || line.length() > limit) {
				System.out.println("输入的长度（不大于" + limit + "）错误，请重新输入：");
				continue;
			}
			break;
		}

		return line;
	}

}
