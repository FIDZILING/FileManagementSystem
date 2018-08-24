package frame;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.DataProcessing;
import common.User;


public class OutUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame; // 父窗口
	private User user; // 当前用户

	public OutUser(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		
		JLabel Lname = new JLabel("用户名：");
		JTextField txtname = new JTextField(10);
		
		JButton btnyes = new JButton("确认");
		JButton btnout = new JButton("退出");
		
		JPanel pn1 = new JPanel();// 主面板
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		
		pn2.add(Lname);
		pn2.add(txtname);
		pn3.add(btnyes);
		pn3.add(btnout);
		
		pn1.add(pn2,BorderLayout.NORTH);
		
		pn1.add(pn3,BorderLayout.SOUTH);
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(500, 300); // 设置窗口的大小
		setLocationRelativeTo(null); // 设置窗口的显示位置为屏幕的中间
		setVisible(true); // 设置窗口可见
		
		btnyes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = txtname.getText().trim();
				
				
				try {
					if (DataProcessing.deleteUser(name) == true)
						JOptionPane.showMessageDialog(OutUser.this, "删除成功！", "成功",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(OutUser.this, "删除失败！", "错误",
								JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(OutUser.this, "数据库错误" + e.getMessage(), "错误",
							JOptionPane.ERROR_MESSAGE); // 弹出出错信息提示框
				}

			}
		});
		
		
		
		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OutUser.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见

			}
		});
		
	}

}
