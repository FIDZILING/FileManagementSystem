package common;
import java.util.*;

import javax.swing.JFrame;

import frame.BrowserFrame;

import java.io.IOException;
import java.sql.*;

public class Browser extends User {// �̳�User
	public Browser(String name, String password, String role) {
		super(name, password, role);// ���ø���Ĺ��캯��
	}

	public User user;
	public void showMenu() {

		boolean loop = true;// ����ѭ��,����Ƿ��˳�
		Scanner scanner = new Scanner(System.in);// �����
		String tip_system = "�������Ա�˵�";
		String infos = "****��ӭ����" + tip_system + "****\n" + "\t1.�����ļ�\n" + "\t2.�ļ��б�\n" + "\t3.�޸�����\n"
				+ "\t4.��       ��\n" + "******************";
		System.out.println(infos);// ��ӡ����Ͳ˵�

		while (loop) {
			System.out.println("��ѡ��˵�");
			int num = scanner.nextInt();// ѡ��˵�
			switch (num) {

			case 4: {
				exitSystem();// �˳�,ллʹ��
				loop = false;// ����ѭ��
				break;
			}

			case 1: {// �����ļ�
				do {
					System.out.println("�����ļ�");
					System.out.println("�����뵵����:");
					String filenum = scanner.next();
					try {
						if (Administrator.downloadFile(filenum)) {// �����ļ�
							System.out.println("���سɹ���");
						} else {
							System.out.println("����ʧ�ܣ�");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (false);
				break;
			}
			
			case 2: {// �ļ��б�
				System.out.println("�ļ��б�");
				do {
					try {
						showFileList();// �ļ��б�
					} catch (SQLException e) {// �쳣����
						System.out.println("����" + "���ݿ����");
						continue;
					}
				} while (false);// �쳣��������ֱ�������������
				break;
			}

			case 3: {// �޸�����
				System.out.println("�޸ı�������");
				System.out.println("�������¿���");
				do {
					try {
						String newpassword = scanner.next();// ������
						changeUserInfo(newpassword);// �޸�����
						System.out.println("�޸ĳɹ�!");// ���쳣�������޸ĳɹ�
					} catch (SQLException e) {// �쳣����
						System.out.println("����" + "���ݿ����");
						continue;
					}
				} while (false);// �쳣��������ֱ�������������
				break;
			}
			default: {
				System.out.println("�˵�ѡ��������������롣");
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
		new BrowserFrame("�������Ա�˵�",parentFrame,user);
	}
}
