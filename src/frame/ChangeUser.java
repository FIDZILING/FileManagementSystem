package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import common.DataProcessing;
import common.User;

public class ChangeUser extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame parentFrame; // 父窗口
	private User user; // 当前用户


	private JTable userlist;
	
	public ChangeUser(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		JLabel list = new JLabel("用户列表:");
		
		JPanel pn1 = new JPanel();// 主面板
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();
		

		JButton btnchange = new JButton("修改用户");
		JButton btndel = new JButton("删除用户");
		JButton btninput = new JButton("新增用户");
		JButton btnout = new JButton("退出");
		
		String[] titles = {"姓名", "密码", "身份"};
		int  k = DataProcessing.users.size();
		Object[][] cellData = new Object[k][3];
		int i = 0;
		for(User value:DataProcessing.users.values()){
			cellData[i][0] = value.getName();
			cellData[i][1] = value.getPassword();
			cellData[i][2] = value.getRole();
			i++;
		}
//		User value:DataProcessing.users.values()
		userlist = new JTable(cellData,titles) ;
		JScrollPane scroll = new JScrollPane(userlist);
		pn3.add(scroll, BorderLayout.CENTER);
		pn2.add(list);
		pn4.add(btnchange);
		pn4.add(btndel);
		pn4.add(btninput);
		pn4.add(btnout);
		pn1.setLayout(new BorderLayout());// 设置“登录面板”的布局
		pn1.add(pn2,BorderLayout.NORTH);
		pn1.add(pn3,BorderLayout.CENTER);
		pn1.add(pn4,BorderLayout.SOUTH);
		
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(1000, 600); // 设置窗口的大小
		setLocationRelativeTo(null); // 设置窗口的显示位置为屏幕的中间

		setVisible(true); // 设置窗口可见
		
		
		btnchange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ChaUser("修改用户",ChangeUser.this,user);
				ChangeUser.this.dispose(); // 释放窗口资源，关闭窗口
			}
		});
		
		btninput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new InUser("增加用户",ChangeUser.this,user);
				ChangeUser.this.dispose(); // 释放窗口资源，关闭窗口
			}
		});
		
		btndel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new OutUser("删除用户",ChangeUser.this,user);
				ChangeUser.this.dispose(); // 释放窗口资源，关闭窗口
			}
		});
		
		
		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeUser.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
			}
		});
		
	
	}
}
