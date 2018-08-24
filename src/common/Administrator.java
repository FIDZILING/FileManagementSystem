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






public class Administrator extends User {// �̳�User
	public Administrator(String name, String password, String role) {
		super(name, password, role);// ���ø���Ĺ��캯��
	}

	public static boolean downloadFile(String filenum) throws IOException {
		// double ranValue=Math.random();
		// if (ranValue>0.5)
		// throw new IOException( "Error in accessing file" );
		System.out.println("�����ļ�... ...");
		// return true;
		Doc doc = null;
		try {
			doc = DataProcessing.searchDoc(filenum);
		} catch (SQLException e) {
			System.out.println("����" + "���ݿ����");
			return false;
		}

		byte[] buffer = new byte[2048];
		File fileRead = new File(filenum +"\\" + doc.getFilename());// Դ
		File fileWrite = new File(downloadfile +"\\" + doc.getFilename());// Ŀ�ĵ�
		try {
			FileInputStream infile = new FileInputStream(fileRead);
			BufferedInputStream in = new BufferedInputStream(infile);// ��������
			FileOutputStream outfile = new FileOutputStream(fileWrite);
			BufferedOutputStream out = new BufferedOutputStream(outfile);// �������
			if (fileRead.exists()) {
				while (true) {

					int byteRead = in.read(buffer);// ���ļ�
					if (byteRead == -1)
						break;
					out.write(buffer, 0, byteRead);// д�ļ�
				}
				in.close();
				out.close();
				return true;
			} else {
				System.out.println("Ŀ¼������");
				DataProcessing.deleteDoc(filenum);
				return false;
			}
		} catch (Exception e) {
			System.out.println("����" + "�ļ����ʴ���");
			return false;
		}

	}

	
	
	public void listUsers() {// �����г��û��ķ���
		do {
			try {
				Enumeration<User> e = DataProcessing.getAllUser();
				User user;
				while (e.hasMoreElements()) {
					user = e.nextElement();// ��һ����
					String infomat = "����:" + user.getName() + "\t���룺" + user.getPassword() + "\t���:" + user.getRole();
					System.out.println(infomat);
					// �г��û�
				}
			} catch (SQLException e) {// �쳣����
				System.out.println("����" + "���ݿ����");
				continue;
			}
		} while (false);// �쳣��������ֱ�������������

	}
	public User user;
	
	public void showMenu() {
		Scanner scanner = new Scanner(System.in);// �����

		
		String tip_system = "����Ա�˵�";
		String infos = "****��ӭ����" + tip_system + "****\n" + "\t1.�޸��û�\n" + "\t2.ɾ���û�\n" + "\t3.�����û�\n" + "\t4.�г��û�\n"
				+ "\t5.�����ļ�\n" + "\t6.�ļ��б�\n" + "\t7.�޸ģ����ˣ�����\n" + "\t8.��       ��\n" + "******************";
		System.out.println(infos);// ��ӡ����Ͳ˵�

		boolean loop = true;
		while (loop) {
			System.out.println("��ѡ��˵�");
			int num = scanner.nextInt();// ѡ��˵�
			switch (num) {

			case 8: {
				exitSystem();// �˳���ллʹ��
				loop = false;// �˳�ѭ��
				break;
			}

			case 1: {// �޸��û�
				System.out.println("�޸��û�");
				System.out.println("�������û���");
				String name = scanner.next();
				System.out.println("���������");
				String pass = scanner.next();
				System.out.println("�������ɫ");
				do {
					try {
						String role = scanner.next();
						if (DataProcessing.updateUser(name, pass, role) == true)// ���쳣����Ϣƥ��ɹ�
							System.out.println("�޸ĳɹ���");
						else
							System.out.println("�޸�ʧ�ܣ�");// ��Ϣƥ��ʧ��
					} catch (SQLException e) {// �쳣����
						System.out.println("����" + "���ݿ����");
						continue;
					}
				} while (false);// �쳣��������ֱ�������������
				break;
			}

			case 2: {// ɾ���û�
				System.out.println("ɾ���û�");
				System.out.println("�������û���");
				do {
					try {
						String name = scanner.next();
						if (DataProcessing.deleteUser(name) == true)// ���쳣������ƥ��ɹ�
							System.out.println("ɾ���ɹ���");
						else
							System.out.println("ɾ��ʧ�ܣ�");// ƥ��ʧ��
					} catch (SQLException e) {// �쳣����
						System.out.println("����" + "���ݿ����");
						continue;
					}
				} while (false);// �쳣��������ֱ�������������
				break;
			}

			case 3: {// ����û�
				System.out.println("�����û�");
				System.out.println("�������û���");
				String name = scanner.next();
				System.out.println("���������");
				String pass = scanner.next();
				System.out.println("�������ɫ");
				do {
					try {
						String role = scanner.next();
						if (DataProcessing.insertUser(name, pass, role) == true)
							System.out.println("�����ɹ���");// ���쳣����ӳɹ�
						else
							System.out.println("����ʧ�ܣ�");// ���ʧ��
					} catch (SQLException e) {// �쳣����
						System.out.println("����" + "���ݿ����");
						continue;
					}
				} while (false);// �쳣��������ֱ�������������
				break;
			}

			case 4: {// �г��û�
				System.out.println("�г��û�");
				listUsers();// �г��û�
				break;
			}

			case 5: {// �����ļ�
				do {
					try {

						System.out.println("�����ļ�");
						System.out.println("�����뵵����:");
						String filenum = scanner.next();
						if (downloadFile(filenum)) {// �����ļ�
							System.out.println("���سɹ���");
						} else {
							System.out.println("����ʧ�ܣ�");
						}
					} catch (IOException e) {
						System.out.println("����:" + "�ļ����ʴ���");
						continue;
					}
				} while (false);
				break;
			}

			case 6: {// �ļ��б�
				System.out.println("�ļ��б�");
				do {
					try {
						showFileList();// �ļ��б�
					} catch (SQLException e) {// �쳣����
						System.out.println("����:" + "���ݿ����");
						continue;
					}
				} while (false);// �쳣��������ֱ�������������
				break;
			}

			case 7: {// �޸�����
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
			new AdministratorFrame("����Ա�˵�",parentFrame,user);
		}
		
	





}