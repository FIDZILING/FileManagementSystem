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
	private JFrame parentFrame; // ������
	private User user; // ��ǰ�û�

	public OutUser(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		
		JLabel Lname = new JLabel("�û�����");
		JTextField txtname = new JTextField(10);
		
		JButton btnyes = new JButton("ȷ��");
		JButton btnout = new JButton("�˳�");
		
		JPanel pn1 = new JPanel();// �����
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		
		pn2.add(Lname);
		pn2.add(txtname);
		pn3.add(btnyes);
		pn3.add(btnout);
		
		pn1.add(pn2,BorderLayout.NORTH);
		
		pn1.add(pn3,BorderLayout.SOUTH);
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(500, 300); // ���ô��ڵĴ�С
		setLocationRelativeTo(null); // ���ô��ڵ���ʾλ��Ϊ��Ļ���м�
		setVisible(true); // ���ô��ڿɼ�
		
		btnyes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = txtname.getText().trim();
				
				
				try {
					if (DataProcessing.deleteUser(name) == true)
						JOptionPane.showMessageDialog(OutUser.this, "ɾ���ɹ���", "�ɹ�",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(OutUser.this, "ɾ��ʧ�ܣ�", "����",
								JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(OutUser.this, "���ݿ����" + e.getMessage(), "����",
							JOptionPane.ERROR_MESSAGE); // ����������Ϣ��ʾ��
				}

			}
		});
		
		
		
		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OutUser.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�

			}
		});
		
	}

}
