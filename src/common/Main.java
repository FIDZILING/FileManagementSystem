package common;
import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		User user;
		Scanner scanner = new Scanner(System.in);// �����
		String tip_system = "����ϵͳ";
		String tip_menu = "��ѡ��˵�";
		String tip_exit = "ϵͳ�˳���ллʹ�á�";
		String infos = "****��ӭ����" + tip_system + "****\n" + "\t1.��¼\n" + "\t2.�˳�\n" + "******************";
		boolean loop = true;// ����ѭ��,����Ƿ��˳�
		while (loop) {
			System.out.println(infos);// ��ӡ����Ͳ˵�
			System.out.println(tip_menu);// ѡ��˵�
			int num = scanner.nextInt();// �˵�ѡ��
			if (num == 1) {// ��¼
				System.out.println("�������û�����");
				String yourname = scanner.next();// �����û���
				System.out.println("��������");
				String pass = scanner.next();// ��������
				do {
					try {

						user = DataProcessing.searchUser(yourname, pass);// �����˻�������˶���Ϣ
						if (user == null)
							;// û����Ϣ
						else {// ���ҵ���Ϣ��¼�ɹ�
							loop = false;// ����ѭ��
							user.showMenu();
						}

					} catch (SQLException e) {// �쳣����
						System.out.println("����" + "���ݿ����");
						continue;
					}
				} while (false);// �쳣��������ֱ�������������
			} else if (num == 2) {// �˳�
				System.out.println(tip_exit);// ллʹ��
				loop = false;// ����ѭ��
			}
		}
		scanner.close();// ����ر�
	}
}



