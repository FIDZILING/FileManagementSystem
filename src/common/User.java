package common;
import java.sql.SQLException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import javax.swing.JFrame;

public abstract class User {

	private static String name;
	private static String password;
	private static String role;

	User(String name, String password, String role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}

	Doc doc;
	static String uploadfile = "D:\\eclipse\\File management system\\oop\\uploadfile";
	static String downloadfile = "D:\\eclipse\\File management system\\oop\\downloadfile";

	public boolean changeUserInfo(String password) throws SQLException{
		//д�û���Ϣ���洢
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("�޸ĳɹ�");
			return true;
		}else
			return false;
	}
	

//	public boolean downloadFile(String filenum) throws IOException {
//		// double ranValue=Math.random();
//		// if (ranValue>0.5)
//		// throw new IOException( "Error in accessing file" );
//		System.out.println("�����ļ�... ...");
//		// return true;
//		Doc doc = null;
//		try {
//			doc = DataProcessing.searchDoc(filenum);
//		} catch (SQLException e) {
//			System.out.println("����" + "���ݿ����");
//			return false;
//		}
//
//		byte[] buffer = new byte[2048];
//		File fileRead = new File(filenum +"\\" + doc.getFilename());// Դ
//		File fileWrite = new File(downloadfile +"\\" + doc.getFilename());// Ŀ�ĵ�
//		try {
//			FileInputStream infile = new FileInputStream(fileRead);
//			BufferedInputStream in = new BufferedInputStream(infile);// ��������
//			FileOutputStream outfile = new FileOutputStream(fileWrite);
//			BufferedOutputStream out = new BufferedOutputStream(outfile);// �������
//			if (fileRead.exists()) {
//				while (true) {
//
//					int byteRead = in.read(buffer);// ���ļ�
//					if (byteRead == -1)
//						break;
//					out.write(buffer, 0, byteRead);// д�ļ�
//				}
//				in.close();
//				out.close();
//				return true;
//			} else {
//				System.out.println("Ŀ¼������");
//				DataProcessing.deleteDoc(filenum);
//				return false;
//			}
//		} catch (Exception e) {
//			System.out.println("����" + "�ļ����ʴ���");
//			return false;
//		}
//
//	}




	public void showFileList() throws SQLException {
		// double ranValue = Math.random();
		// if (ranValue > 0.5)
		System.out.println("�ļ����\t�ļ���\t\t�ϴ���\t�ϴ�ʱ��\t\t\t�ĵ�����");
		for (Doc value : DataProcessing.docs.values())
			System.out.println(value.getID() + "\t" + value.getFilename() + "\t" + value.getCreator() + "\t"
					+ value.getTimestamp() + "\t" + value.getDescription());
	}

	public abstract void showMenu();
	
	public abstract void showFrame(JFrame parentFrame);
	
	
	public void exitSystem() {
		System.out.println("ϵͳ�˳�, ллʹ�� ! ");
		System.exit(0);
	}
	

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
