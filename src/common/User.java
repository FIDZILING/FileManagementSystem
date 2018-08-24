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
		//写用户信息到存储
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("修改成功");
			return true;
		}else
			return false;
	}
	

//	public boolean downloadFile(String filenum) throws IOException {
//		// double ranValue=Math.random();
//		// if (ranValue>0.5)
//		// throw new IOException( "Error in accessing file" );
//		System.out.println("下载文件... ...");
//		// return true;
//		Doc doc = null;
//		try {
//			doc = DataProcessing.searchDoc(filenum);
//		} catch (SQLException e) {
//			System.out.println("错误：" + "数据库错误。");
//			return false;
//		}
//
//		byte[] buffer = new byte[2048];
//		File fileRead = new File(filenum +"\\" + doc.getFilename());// 源
//		File fileWrite = new File(downloadfile +"\\" + doc.getFilename());// 目的地
//		try {
//			FileInputStream infile = new FileInputStream(fileRead);
//			BufferedInputStream in = new BufferedInputStream(infile);// 创造输入
//			FileOutputStream outfile = new FileOutputStream(fileWrite);
//			BufferedOutputStream out = new BufferedOutputStream(outfile);// 创造输出
//			if (fileRead.exists()) {
//				while (true) {
//
//					int byteRead = in.read(buffer);// 读文件
//					if (byteRead == -1)
//						break;
//					out.write(buffer, 0, byteRead);// 写文件
//				}
//				in.close();
//				out.close();
//				return true;
//			} else {
//				System.out.println("目录不存在");
//				DataProcessing.deleteDoc(filenum);
//				return false;
//			}
//		} catch (Exception e) {
//			System.out.println("错误：" + "文件访问错误。");
//			return false;
//		}
//
//	}




	public void showFileList() throws SQLException {
		// double ranValue = Math.random();
		// if (ranValue > 0.5)
		System.out.println("文件编号\t文件名\t\t上传者\t上传时间\t\t\t文档描述");
		for (Doc value : DataProcessing.docs.values())
			System.out.println(value.getID() + "\t" + value.getFilename() + "\t" + value.getCreator() + "\t"
					+ value.getTimestamp() + "\t" + value.getDescription());
	}

	public abstract void showMenu();
	
	public abstract void showFrame(JFrame parentFrame);
	
	
	public void exitSystem() {
		System.out.println("系统退出, 谢谢使用 ! ");
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
