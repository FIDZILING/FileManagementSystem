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

public class Operator extends User {// �̳�User
	public Operator(String name, String password, String role) {
		super(name, password, role);// ���ø���Ĺ��캯��
	}

	public User user;
	public static boolean uploadFile(String Spath, String Sfile, String filenum, String filedes) {

		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (DataProcessing.insertDoc(filenum, getName(), timestamp, filedes, Sfile) == false) {

				System.out.println("�������ظ���");
				
				return false;
			}
		} catch (SQLException e) {
			System.out.println("����" + "���ݿ����");
			return false;
		}

		byte[] buffer = new byte[2048];

		try {
			File fileRead = new File(Spath  +"\\" +Sfile);// Դ
			File fileWrite = new File(uploadfile  +"\\"+ Sfile);// Ŀ�ĵ�

			FileInputStream infile = new FileInputStream(fileRead);
			BufferedInputStream in = new BufferedInputStream(infile);// ��������
			FileOutputStream outfile = new FileOutputStream(fileWrite);
			BufferedOutputStream out =new BufferedOutputStream(outfile);// �������
			if (fileRead.exists()) {
				while (true) {

					int byteRead = in.read(buffer);// ���ļ�
					if (byteRead == -1)
						break;
					out.write(buffer, 0, byteRead);// д�ļ�
				}
				in.close();// ����ر�
				out.close();// ����ر�
				return true;
			} else {
				System.out.println("Ŀ¼������");
				DataProcessing.deleteDoc(filenum);
				return false;
			}
		} catch (Exception e) {
			System.out.println("����" + "�ļ����ʴ���");
			e.printStackTrace();
			return false;
		}

	}

	public void showMenu() {
		Scanner scanner = new Scanner(System.in);// �����
		String tip_system = "����¼��Ա�˵�";
		String infos = "****��ӭ����" + tip_system + "****\n" + "\t1.�ϴ��ļ�\n" + "\t2.�����ļ�\n" + "\t3.�ļ��б�\n" + "\t4.�޸�����\n"
				+ "\t5.��       ��\n" + "******************";
		System.out.println(infos);// ��ӡ����Ͳ˵�

		boolean loop = true;
		while (loop) {
			System.out.println("��ѡ��˵�");
			int num = scanner.nextInt();// ѡ��˵�
			switch (num) {

			case 5: {
				exitSystem();// �˳���ллʹ��
				loop = false;// ����ѭ��
				break;
			}

			case 1: {// �ϴ��ļ�
				System.out.println("�ϴ��ļ�");
				System.out.println("������Դ�ļ�·��:");
				String Spath = scanner.next();// ·��
				System.out.println("������Դ�ļ���:");
				String Sfile = scanner.next();// �ļ���
				System.out.println("�����뵵���ţ�");
				String filenum = scanner.next();// ������
				System.out.println("�����뵵��������");
				String filedes = scanner.next();// ��������
				if (uploadFile(Spath, Sfile, filenum, filedes) == true)
					System.out.println("�ϴ��ɹ���");
				else
					System.out.println("�ϴ�ʧ�ܣ�");

				break;
			}
			case 2: {// �����ļ�
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

			case 3: {// �ļ��б�
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

			case 4: {// �޸�����
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


	public void showFrame(JFrame parentFrame){
		this.user = user;
		new OperatorFrame("����¼��Ա�˵�",parentFrame,user);
	}


}
