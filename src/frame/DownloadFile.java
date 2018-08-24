package frame;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.Administrator;
import common.User;

public class DownloadFile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame; // 父窗口
	private User user; // 当前用户

	public DownloadFile(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		JLabel Lnum = new JLabel("选择档案号：");
//		JLabel Lpath = new JLabel("选择文件路径：");
		// JButton btnpath = new JButton("浏览~~~~");

		JButton btnyes = new JButton("确认");
		JButton btnout = new JButton("退出");

		JTextField txtnum = new JTextField(10);
//		JTextField txtpath = new JTextField(10);

		JPanel pn1 = new JPanel();// 主面板
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();
		pn1.setLayout(new BorderLayout());

		pn2.add(Lnum);
		pn2.add(txtnum);
//		pn3.add(Lpath);
//		pn3.add(txtpath);
		pn4.add(btnyes);
		pn4.add(btnout);

		pn1.add(pn2, BorderLayout.NORTH);
		pn1.add(pn3, BorderLayout.CENTER);
		pn1.add(pn4, BorderLayout.SOUTH);
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(500, 300); // 设置窗口的大小
		setLocationRelativeTo(null); // 设置窗口的显示位置为屏幕的中间
		setVisible(true); // 设置窗口可见

		// btnpath.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // TODO Auto-generated method stub
		// Frame fe;
		// fe = new Frame();
		// if(e.getSource() == btnpath){
		// FileDialog fd1 = new FileDialog(fe,"浏览~~~~",FileDialog.LOAD);
		// fd1.show();
		// System.out.println(fd1);
		// System.out.println(fd1.getFile());
		// }
		// }
		// });

		btnyes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String filenum = txtnum.getText().trim();
				try {
					if (Administrator.downloadFile(filenum)) {
						JOptionPane.showMessageDialog(DownloadFile.this, "下载成功！", "成功",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(DownloadFile.this, "下载失败！", "失败", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(DownloadFile.this, "文件访问错误" + e.getMessage(), "错误",
							JOptionPane.ERROR_MESSAGE);
				}
				DownloadFile.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
				
			}
		});

		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DownloadFile.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见

			}
		});

	}

}
