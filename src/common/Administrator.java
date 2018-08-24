package common;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import frame.AdministratorFrame;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;






public class Administrator extends User {// 继承User
	public Administrator(String name, String password, String role) {
		super(name, password, role);// 调用父类的构造函数
	}

	public static boolean downloadFile(String filenum) throws IOException {
		// double ranValue=Math.random();
		// if (ranValue>0.5)
		// throw new IOException( "Error in accessing file" );
		System.out.println("下载文件... ...");
		// return true;
		Doc doc = null;
		try {
			doc = DataProcessing.searchDoc(filenum);
		} catch (SQLException e) {
			System.out.println("错误：" + "数据库错误。");
			return false;
		}

		byte[] buffer = new byte[2048];
		File fileRead = new File(filenum +"\\" + doc.getFilename());// 源
		File fileWrite = new File(downloadfile +"\\" + doc.getFilename());// 目的地
		try {
			FileInputStream infile = new FileInputStream(fileRead);
			BufferedInputStream in = new BufferedInputStream(infile);// 创造输入
			FileOutputStream outfile = new FileOutputStream(fileWrite);
			BufferedOutputStream out = new BufferedOutputStream(outfile);// 创造输出
			if (fileRead.exists()) {
				while (true) {

					int byteRead = in.read(buffer);// 读文件
					if (byteRead == -1)
						break;
					out.write(buffer, 0, byteRead);// 写文件
				}
				in.close();
				out.close();
				return true;
			} else {
				System.out.println("目录不存在");
				DataProcessing.deleteDoc(filenum);
				return false;
			}
		} catch (Exception e) {
			System.out.println("错误：" + "文件访问错误。");
			return false;
		}

	}

	
	
	public void listUsers() {// 定义列出用户的方法
		do {
			try {
				Enumeration<User> e = DataProcessing.getAllUser();
				User user;
				while (e.hasMoreElements()) {
					user = e.nextElement();// 下一个人
					String infomat = "姓名:" + user.getName() + "\t密码：" + user.getPassword() + "\t身份:" + user.getRole();
					System.out.println(infomat);
					// 列出用户
				}
			} catch (SQLException e) {// 异常处理
				System.out.println("错误：" + "数据库错误。");
				continue;
			}
		} while (false);// 异常继续处理直到程序继续进行

	}
	public User user;
	
	public void showMenu() {
		Scanner scanner = new Scanner(System.in);// 输入打开

		
		String tip_system = "管理员菜单";
		String infos = "****欢迎进入" + tip_system + "****\n" + "\t1.修改用户\n" + "\t2.删除用户\n" + "\t3.新增用户\n" + "\t4.列出用户\n"
				+ "\t5.下载文件\n" + "\t6.文件列表\n" + "\t7.修改（本人）密码\n" + "\t8.退       出\n" + "******************";
		System.out.println(infos);// 打印标题和菜单

		boolean loop = true;
		while (loop) {
			System.out.println("请选择菜单");
			int num = scanner.nextInt();// 选择菜单
			switch (num) {

			case 8: {
				exitSystem();// 退出，谢谢使用
				loop = false;// 退出循环
				break;
			}

			case 1: {// 修改用户
				System.out.println("修改用户");
				System.out.println("请输入用户名");
				String name = scanner.next();
				System.out.println("请输入口令");
				String pass = scanner.next();
				System.out.println("请输入角色");
				do {
					try {
						String role = scanner.next();
						if (DataProcessing.updateUser(name, pass, role) == true)// 无异常则信息匹配成功
							System.out.println("修改成功！");
						else
							System.out.println("修改失败！");// 信息匹配失败
					} catch (SQLException e) {// 异常处理
						System.out.println("错误：" + "数据库错误。");
						continue;
					}
				} while (false);// 异常继续处理直到程序继续进行
				break;
			}

			case 2: {// 删除用户
				System.out.println("删除用户");
				System.out.println("请输入用户名");
				do {
					try {
						String name = scanner.next();
						if (DataProcessing.deleteUser(name) == true)// 无异常则姓名匹配成功
							System.out.println("删除成功！");
						else
							System.out.println("删除失败！");// 匹配失败
					} catch (SQLException e) {// 异常处理
						System.out.println("错误：" + "数据库错误。");
						continue;
					}
				} while (false);// 异常继续处理直到程序继续进行
				break;
			}

			case 3: {// 添加用户
				System.out.println("新增用户");
				System.out.println("请输入用户名");
				String name = scanner.next();
				System.out.println("请输入口令");
				String pass = scanner.next();
				System.out.println("请输入角色");
				do {
					try {
						String role = scanner.next();
						if (DataProcessing.insertUser(name, pass, role) == true)
							System.out.println("新增成功！");// 无异常则添加成功
						else
							System.out.println("新增失败！");// 添加失败
					} catch (SQLException e) {// 异常处理
						System.out.println("错误：" + "数据库错误。");
						continue;
					}
				} while (false);// 异常继续处理直到程序继续进行
				break;
			}

			case 4: {// 列出用户
				System.out.println("列出用户");
				listUsers();// 列出用户
				break;
			}

			case 5: {// 下载文件
				do {
					try {

						System.out.println("下载文件");
						System.out.println("请输入档案号:");
						String filenum = scanner.next();
						if (downloadFile(filenum)) {// 下载文件
							System.out.println("下载成功！");
						} else {
							System.out.println("下载失败！");
						}
					} catch (IOException e) {
						System.out.println("错误:" + "文件访问错误。");
						continue;
					}
				} while (false);
				break;
			}

			case 6: {// 文件列表
				System.out.println("文件列表");
				do {
					try {
						showFileList();// 文件列表
					} catch (SQLException e) {// 异常处理
						System.out.println("错误:" + "数据库错误。");
						continue;
					}
				} while (false);// 异常继续处理直到程序继续进行
				break;
			}

			case 7: {// 修改密码
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
		public void showFrame(JFrame parentFrame){
			this.user = user;
			new AdministratorFrame("管理员菜单",parentFrame,user);
		}
		
	





}