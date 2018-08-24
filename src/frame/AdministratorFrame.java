package frame;

//import java.awt.BorderLayout;
//import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;

import common.User;

public class AdministratorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame parentFrame; // 父窗口
	private User user; // 当前用户

	// private JButton btnChangeUsers;// 修改用户按钮
	// private JButton btnDelUsers;// 删除用户按钮
	// private JButton btnAddUsers;// 新增用户按钮
	// private JButton btnShowUers;// 列出用户按钮
	// private JButton btnDownloadFile; // 下载文件按钮
	// private JButton btnShowFileList; // 显示文件列表按钮
	// private JButton btnModiPsd; // 修改密码按钮
	// private JButton btnExit; // 退出按钮
	//
	// private JPanel panel; // 面板
	//
	//
	// public AdministratorFrame(String frameTilte, JFrame parentframe, User
	// user) {
	// // TODO Auto-generated constructor stub
	// super(frameTilte);
	// this.parentFrame = parentframe;
	// this.user = user;
	//
	// btnChangeUsers = new JButton("修 改 用 户");
	// btnDelUsers = new JButton("删 除 用 户");
	// btnAddUsers = new JButton("新 增 用 户");
	// btnShowUers = new JButton("列 出 用 户");
	// btnDownloadFile = new JButton("下 载 文 件");
	// btnShowFileList = new JButton("文 件 列 表");
	// btnModiPsd = new JButton("修 改 密 码");
	// btnExit = new JButton("退 出 登 录");
	//
	// panel = new JPanel();
	// panel.setLayout(new GridLayout(8, 1)); // 设置面板布局为网格布局，即8行1列
	// panel.add(btnChangeUsers);
	// panel.add(btnDelUsers);
	// panel.add(btnAddUsers);
	// panel.add(btnShowUers);
	// panel.add(btnDownloadFile);
	// panel.add(btnShowFileList);
	// panel.add(btnModiPsd);
	// panel.add(btnExit);
	//
	// getContentPane().add(panel, BorderLayout.CENTER);// 将panel放置在窗口的内容面板的中间
	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
	// 设置当点击窗口右上角的“关闭”图标后，退出应用程序
	// setSize(350, 250);// 设置窗口的大小
	// this.setResizable(false);// 设置不可调整窗口的大小
	// this.setLocationRelativeTo(null);// 设置窗口的显示位置为屏幕的中间
	// this.setVisible(true);// 设置窗口可见
	//
	// // 处理“退出”按钮事件
	// btnExit.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// AdministratorFrame.this.dispose(); // 释放窗口资源，关闭窗口
	// parentFrame.setVisible(true); // 设置父窗口可见
	// }
	// });
	//
	// // 处理“修改用户”按钮事件
	// btnChangeUsers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // new ChangeUserInfoFrame("修改用户",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // 处理“删除用户”按钮事件
	// btnDelUsers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("删除用户",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // 处理“新增用户”按钮事件
	// btnAddUsers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("新增用户",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // 处理“列出用户”按钮事件
	// btnShowUers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("列出用户",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // 处理“下载文件”按钮事件
	// btnDownloadFile.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("下载文件",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // 处理“文件列表”按钮事件
	// btnShowFileList.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new ShowFileListFrame("文件列表",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // 处理“修改密码”按钮事件
	// btnModiPsd.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new ModiPsdFrame("修改密码",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	// }
	//
	//
	//
	//
	//
	//
	//

	public AdministratorFrame(String frameTilte, JFrame parentframe, User user) {
		// TODO Auto-generated constructor stub
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;

		setLocationRelativeTo(null);// 设置窗口的显示位置为屏幕的中间

		MenuBar mBar = new MenuBar();
		Menu menu1 = new Menu("个人");
		Menu menu2 = new Menu("文件");
		Menu menu3 = new Menu("用户");
		Menu menu4 = new Menu("系统");
		MenuItem mi11 = new MenuItem("修改密码");
		MenuItem mi21 = new MenuItem("上传文件");
		MenuItem mi22 = new MenuItem("下载文件");
		MenuItem mi31 = new MenuItem("修改用户");
		MenuItem mi32 = new MenuItem("删除用户");
		MenuItem mi33 = new MenuItem("新增用户");
		MenuItem mi41 = new MenuItem("注销登录");
		MenuItem mi42 = new MenuItem("关于");

		menu1.add(mi11);
		menu2.add(mi21);
		// menu2.addSeparator();//好丑= =
		menu2.add(mi22);
		mi21.setEnabled(false);
		menu3.add(mi31);
		menu3.add(mi32);
		menu3.add(mi33);
		menu4.add(mi41);
		menu4.add(mi42);
		// menu4.setEnabled(false);//不能退出！
		mBar.add(menu1);
		mBar.add(menu2);
		mBar.add(menu3);
		mBar.add(menu4);
		setMenuBar(mBar);
		setSize(400, 250);
		setVisible(true);

		mi11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeInfoSelf("修改个人的信息", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeFile2("下载文件", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi31.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeUser("用户信息", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi32.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeUser("用户信息", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi33.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeUser("用户信息", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi41.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdministratorFrame.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
			}

		});

		// mi42.addActionListener(new ActionListener(){
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // TODO Auto-generated method stub
		// new About("关于",AdministratorFrame.this,user);
		// AdministratorFrame.this.setVisible(false);
		// }
		//
		// });

	}
}