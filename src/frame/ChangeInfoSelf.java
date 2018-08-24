package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.DataProcessing;
import common.User;

public class ChangeInfoSelf extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbnewpass;
	private JLabel lbnewpassagain;

	private JPasswordField txtpass;
	private JPasswordField txtpassagain;

	private JPanel pn1;// 主面板
	private JPanel pn2;
	private JPanel pn3;
	private JPanel pnbtn;

	private JButton btnyes; 
	private JButton btnout;

	private JFrame parentFrame; // 父窗口
	private User user; // 当前用户

	public ChangeInfoSelf(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;

		lbnewpass = new JLabel("新密码:");
		lbnewpassagain = new JLabel("确认新密码:");

		txtpass = new JPasswordField(10);
		txtpassagain = new JPasswordField(10);

		btnyes = new JButton("确认");
		btnout = new JButton("退出");

		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		pnbtn = new JPanel();

		pn1.add(pn2, BorderLayout.NORTH);
		pn1.add(pn3, BorderLayout.CENTER);

		pn2.add(lbnewpass);
		pn2.add(txtpass);
		pn3.add(lbnewpassagain);
		pn3.add(txtpassagain);
		pnbtn.add(btnyes);
		pnbtn.add(btnout);
		pn1.add(pnbtn, BorderLayout.SOUTH);

		getContentPane().add(pn1, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setSize(350, 200);
		// setResizable(false);
		setVisible(true); // 设置窗口可见

		btnyes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
					String pass1 = String.valueOf(txtpass.getPassword()).trim();

					String pass2 = String.valueOf(txtpassagain.getPassword()).trim();
					if (pass1.equals(pass2) == true) {
//						user.changeUserInfo(pass2);
//						for(User value : DataProcessing.users.values()){
//							value.setPassword(pass2);
//						}
						JOptionPane.showMessageDialog(ChangeInfoSelf.this, "修改成功!", "成功",
						 		JOptionPane.INFORMATION_MESSAGE);
						ChangeInfoSelf.this.dispose(); // 释放窗口资源，关闭窗口
						parentFrame.setVisible(true); // 设置父窗口可见
					} else {
						JOptionPane.showMessageDialog(ChangeInfoSelf.this, "输入的两个密码不相同！", "错误",
								JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
					}
				
				

			}

		});

		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeInfoSelf.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
			}
		});

	}

}
