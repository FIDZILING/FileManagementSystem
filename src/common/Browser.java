package common;
import java.util.*;

import javax.swing.JFrame;

import frame.BrowserFrame;

import java.io.IOException;
import java.sql.*;

public class Browser extends User {// 继承User
	public Browser(String name, String password, String role) {
		super(name, password, role);// 调用父类的构造函数
	}

	public User user;
	public void showMenu() {

		boolean loop = true;// 控制循环,检测是否退出
		Scanner scanner = new Scanner(System.in);// 输入打开
		String tip_system = "档案浏览员菜单";
		String infos = "****欢迎进入" + tip_system + "****\n" + "\t1.下载文件\n" + "\t2.文件列表\n" + "\t3.修改密码\n"
				+ "\t4.退       出\n" + "******************";
		System.out.println(infos);// 打印标题和菜单

		while (loop) {
			System.out.println("请选择菜单");
			int num = scanner.nextInt();// 选择菜单
			switch (num) {

			case 4: {
				exitSystem();// 退出,谢谢使用
				loop = false;// 跳出循环
				break;
			}

			case 1: {// 下载文件
				do {
					System.out.println("下载文件");
					System.out.println("请输入档案号:");
					String filenum = scanner.next();
					try {
						if (Administrator.downloadFile(filenum)) {// 下载文件
							System.out.println("下载成功！");
						} else {
							System.out.println("下载失败！");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (false);
				break;
			}
			
			case 2: {// 文件列表
				System.out.println("文件列表");
				do {
					try {
						showFileList();// 文件列表
					} catch (SQLException e) {// 异常处理
						System.out.println("错误：" + "数据库错误。");
						continue;
					}
				} while (false);// 异常继续处理直到程序继续进行
				break;
			}

			case 3: {// 修改密码
				System.out.println("修改本人密码");
				System.out.println("请输入新口令");
				do {
					try {
						String newpassword = scanner.next();// 新密码
						changeUserInfo(newpassword);// 修改密码
						System.out.println("修改成功!");// 无异常则密码修改成功
					} catch (SQLException e) {// 异常处理
						System.out.println("错误：" + "数据库错误。");
						continue;
					}
				} while (false);// 异常继续处理直到程序继续进行
				break;
			}
			default: {
				System.out.println("菜单选择错误，请重新输入。");
			}
			}
		}
	}

	private boolean downloadFile(String filenum) {
		// TODO Auto-generated method stub
		return false;
	}

	public void showFrame(JFrame parentFrame){
		this.user = user;
		new BrowserFrame("档案浏览员菜单",parentFrame,user);
	}
}
