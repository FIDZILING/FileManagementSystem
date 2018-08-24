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
	private JFrame parentFrame; // ������
	private User user; // ��ǰ�û�

	public DownloadFile(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		JLabel Lnum = new JLabel("ѡ�񵵰��ţ�");
//		JLabel Lpath = new JLabel("ѡ���ļ�·����");
		// JButton btnpath = new JButton("���~~~~");

		JButton btnyes = new JButton("ȷ��");
		JButton btnout = new JButton("�˳�");

		JTextField txtnum = new JTextField(10);
//		JTextField txtpath = new JTextField(10);

		JPanel pn1 = new JPanel();// �����
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
		setSize(500, 300); // ���ô��ڵĴ�С
		setLocationRelativeTo(null); // ���ô��ڵ���ʾλ��Ϊ��Ļ���м�
		setVisible(true); // ���ô��ڿɼ�

		// btnpath.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // TODO Auto-generated method stub
		// Frame fe;
		// fe = new Frame();
		// if(e.getSource() == btnpath){
		// FileDialog fd1 = new FileDialog(fe,"���~~~~",FileDialog.LOAD);
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
						JOptionPane.showMessageDialog(DownloadFile.this, "���سɹ���", "�ɹ�",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(DownloadFile.this, "����ʧ�ܣ�", "ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(DownloadFile.this, "�ļ����ʴ���" + e.getMessage(), "����",
							JOptionPane.ERROR_MESSAGE);
				}
				DownloadFile.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�
				
			}
		});

		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DownloadFile.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�

			}
		});

	}

}
