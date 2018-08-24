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

import common.User;
import common.Operator;

public class UploadFile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame; // 父窗口
	private User user; // 当前用户

	public UploadFile(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		JLabel Lpath = new JLabel("文件路径：");
		JLabel Lname = new JLabel("文件名：");
		JLabel Lnum = new JLabel("档案号：");
		JLabel Ldes = new JLabel("档案描述：");
		
//		JButton btnpath = new JButton("浏览~~~~");

		JButton btnyes = new JButton("确认");
		JButton btnout = new JButton("退出");

		JTextField txtpath = new JTextField(10);
		JTextField txtname = new JTextField(10);
		JTextField txtnum = new JTextField(10);
		JTextField txtdes = new JTextField(10);

		JPanel pn1 = new JPanel();// 主面板
		JPanel pn2 = new JPanel();
//		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();
//		JPanel pn5 = new JPanel();
		JPanel pn6 = new JPanel();
		pn1.setLayout(new BorderLayout());

		pn2.add(Lpath);
		pn2.add(txtpath);
		
		pn2.add(Lname);
		pn2.add(txtname);
		
		pn4.add(Lnum);
		pn4.add(txtnum);
		
		pn4.add(Ldes);
		pn4.add(txtdes);
		
		pn6.add(btnyes);
		pn6.add(btnout);
		

		pn1.add(pn2,BorderLayout.NORTH);
//		pn1.add(pn3);
		pn1.add(pn4,BorderLayout.CENTER);
//		pn1.add(pn5);
		pn1.add(pn6,BorderLayout.SOUTH);
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
				String Spath = txtpath.getText().trim();
				String Sfile = txtname.getText().trim();
				String filenum = txtnum.getText().trim();
				String filedes = txtdes.getText().trim();
				if (Operator.uploadFile(Spath, Sfile, filenum, filedes) == true){
					JOptionPane.showMessageDialog(UploadFile.this, "上传成功！", "成功",
							JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(UploadFile.this, "上传失败！", "失败", JOptionPane.ERROR_MESSAGE);
				}
				UploadFile.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见

			}
		});

		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UploadFile.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见

			}
		});

	}

}
