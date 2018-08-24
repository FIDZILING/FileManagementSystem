package common;
import java.util.*;

import javax.swing.JFrame;

import frame.OperatorFrame;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class Operator extends User {// 继承User
	public Operator(String name, String password, String role) {
		super(name, password, role);// 调用父类的构造函数
	}

	public User user;
	public static boolean uploadFile(String Spath, String Sfile, String filenum, String filedes) {

		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (DataProcessing.insertDoc(filenum, getName(), timestamp, filedes, Sfile) == false) {

				System.out.println("档案号重复。");
				
				return false;
			}
		} catch (SQLException e) {
			System.out.println("错误：" + "数据库错误。");
			return false;
		}

		byte[] buffer = new byte[2048];

		try {
			File fileRead = new File(Spath  +"\\" +Sfile);// 源
			File fileWrite = new File(uploadfile  +"\\"+ Sfile);// 目的地

			FileInputStream infile = new FileInputStream(fileRead);
			BufferedInputStream in = new BufferedInputStream(infile);// 创造输入
			FileOutputStream outfile = new FileOutputStream(fileWrite);
			BufferedOutputStream out =new BufferedOutputStream(outfile);// 创造输出
			if (fileRead.exists()) {
				while (true) {

					int byteRead = in.read(buffer);// 读文件
					if (byteRead == -1)
						break;
					out.write(buffer, 0, byteRead);// 写文件
				}
				in.close();// 输入关闭
				out.close();// 输出关闭
				return true;
			} else {
				System.out.println("目录不存在");
				DataProcessing.deleteDoc(filenum);
				return false;
			}
		} catch (Exception e) {
			System.out.println("错误：" + "文件访问错误。");
			e.printStackTrace();
			return false;
		}

	}

	public void showMenu() {
		Scanner scanner = new Scanner(System.in);// 输入打开
		String tip_system = "档案录入员菜单";
		String infos = "****欢迎进入" + tip_system + "****\n" + "\t1.上传文件\n" + "\t2.下载文件\n" + "\t3.文件列表\n" + "\t4.修改密码\n"
				+ "\t5.退       出\n" + "******************";
		System.out.println(infos);// 打印标题和菜单

		boolean loop = true;
		while (loop) {
			System.out.println("请选择菜单");
			int num = scanner.nextInt();// 选择菜单
			switch (num) {

			case 5: {
				exitSystem();// 退出，谢谢使用
				loop = false;// 跳出循环
				break;
			}

			case 1: {// 上传文件
				System.out.println("上传文件");
				System.out.println("请输入源文件路径:");
				String Spath = scanner.next();// 路径
				System.out.println("请输入源文件名:");
				String Sfile = scanner.next();// 文件名
				System.out.println("请输入档案号：");
				String filenum = scanner.next();// 档案号
				System.out.println("请输入档案描述：");
				String filedes = scanner.next();// 档案描述
				if (uploadFile(Spath, Sfile, filenum, filedes) == true)
					System.out.println("上传成功！");
				else
					System.out.println("上传失败！");

				break;
			}
			case 2: {// 下载文件
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

			case 3: {// 文件列表
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

			case 4: {// 修改密码
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
		new OperatorFrame("档案录入员菜单",parentFrame,user);
	}


}
