package common;
import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		User user;
		Scanner scanner = new Scanner(System.in);// 输入打开
		String tip_system = "档案系统";
		String tip_menu = "请选择菜单";
		String tip_exit = "系统退出，谢谢使用。";
		String infos = "****欢迎进入" + tip_system + "****\n" + "\t1.登录\n" + "\t2.退出\n" + "******************";
		boolean loop = true;// 控制循环,检测是否退出
		while (loop) {
			System.out.println(infos);// 打印标题和菜单
			System.out.println(tip_menu);// 选择菜单
			int num = scanner.nextInt();// 菜单选项
			if (num == 1) {// 登录
				System.out.println("请输入用户名：");
				String yourname = scanner.next();// 输入用户名
				System.out.println("请输入口令：");
				String pass = scanner.next();// 输入密码
				do {
					try {

						user = DataProcessing.searchUser(yourname, pass);// 查找账户和密码核对信息
						if (user == null)
							;// 没有信息
						else {// 查找到信息登录成功
							loop = false;// 跳出循环
							user.showMenu();
						}

					} catch (SQLException e) {// 异常处理
						System.out.println("错误：" + "数据库错误。");
						continue;
					}
				} while (false);// 异常继续处理直到程序继续进行
			} else if (num == 2) {// 退出
				System.out.println(tip_exit);// 谢谢使用
				loop = false;// 跳出循环
			}
		}
		scanner.close();// 输入关闭
	}
}



