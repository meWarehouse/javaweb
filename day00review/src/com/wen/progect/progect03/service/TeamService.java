package com.wen.progect.progect03.service;

import com.wen.progect.progect03.domain.Architect;
import com.wen.progect.progect03.domain.Designer;
import com.wen.progect.progect03.domain.Employee;
import com.wen.progect.progect03.domain.Programmer;
import com.wen.progect.progect03.service.Data;

/**
 * 
 * @Descripyion 关于开发团队成员的管理：添加、删除等
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月2日下午9:01:46
 *
 */
public class TeamService {

	private static int counter = 1;// 用来为开发团队新增成员自动生成团队中的唯一ID
	private final int MAX_MEMBER = 5;// 表示开发团队最大成员数
	private Programmer[] team = new Programmer[MAX_MEMBER];// 用来保存当前团队中的各成员对象
	private int total = 0;// 记录团队成员的实际人数

	public TeamService() {
		super();
	}

	/**
	 * 
	 * @Descripyion 返回当前团队的所有对象
	 * @author wen
	 * @date 2020年3月2日下午9:08:32
	 * @return 包含所有成员对象的数组，数组大小与成员数一致
	 *
	 */
	public Programmer[] getTeam() {

		Programmer[] newTeam = new Programmer[total];
		for (int i = 0; i < total; i++) {
			newTeam[i] = team[i];
		}

		return newTeam;

	}

	/**
	 * 
	 * @Descripyion 向团队中添加成员
	 * @author wen
	 * @date 2020年3月2日下午9:10:33
	 * @param e
	 *            待添加成员的对象
	 * @throws TeamException
	 *
	 */
	public void addMember(Employee e) throws TeamException {
		// 成员已满，无法添加
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}

		// 该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}

		// 该员工已在本开发团队中
		if (isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}

		// 该员工已是某团队成员
		// 该员正在休假，无法添加
		Programmer p = (Programmer) e;
		// if(p.getStatus().getNAME().equals("BUSY")){
		// throw new TeamException("该员工已是某团队成员");
		// }else if(p.getStatus().getNAME().equals("VOCATION")){
		// throw new TeamException("该员正在休假，无法添加");
		// }

		if ("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
		} else if ("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员正在休假，无法添加");
		}

		// 团队中至多只能有一名架构师
		// 团队中至多只能有两名设计师
		// 团队中至多只能有三名程序员

		// 获取team已有成员中的程序员，设计师，架构师
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;

		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}

		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		} else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		} else if (p instanceof Programmer) {
			if (numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}

		// 将e添加到团队中
		team[total++] = p;
		// 给p的属性赋值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);

	}

	/**
	 * 
	 * @Descripyion 判断指定的员工是否已经存在团队中
	 * @author wen
	 * @date 2020年3月2日下午9:44:59
	 * @param e
	 * @return true存在 false不存在
	 *
	 */
	private boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			return team[i].getId() == e.getId();
		}
		return false;
	}

	/**
	 * 
	 * @Descripyion 从团队中删除成员
	 * @author wen
	 * @date 2020年3月2日下午9:12:29
	 * @param memberId
	 *            待删除成员的编号
	 * @throws TeamException
	 *
	 */
	public void removeMember(int memberId) throws TeamException {
		int i;
		for (i = 0; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				// 修改状态
				team[i].setStatus(Status.FREE);
				break;
			}
		}

		if (i == total) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}

		// 后一个元素覆盖前一个元素
		for (int k = i; k < total - 1; k++) {
			team[k] = team[k + 1];
		}

		team[--total] = null;

	}

}
