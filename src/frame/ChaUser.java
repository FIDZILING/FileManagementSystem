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


public class ChaUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame; // ������
	private User user; // ��ǰ�û�

	public ChaUser(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		
		JLabel Lname = new JLabel("�û�����");
		JLabel Lpass = new JLabel("���룺");
		JLabel Lrole = new JLabel("��ݣ�");
		
		JTextField txtname = new JTextField(10);
		JTextField txtpass = new JTextField(10);
		JTextField txtrole = new JTextField(10);
		
		JPanel pn1 = new JPanel();// �����
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();
//		JPanel pn5 = new JPanel();
		
		JButton btnyes = new JButton("ȷ��");
		JButton btnout = new JButton("�˳�");
		
		pn2.add(Lname);
		pn2.add(txtname);
		pn2.add(Lpass);
		pn2.add(txtpass);
		pn3.add(Lrole);
		pn3.add(txtrole);
		pn4.add(btnyes);
		pn4.add(btnout);
		
		pn1.add(pn2,BorderLayout.NORTH);
		pn1.add(pn3,BorderLayout.CENTER);
		pn1.add(pn4,BorderLayout.SOUTH);
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(500, 300); // ���ô��ڵĴ�С
		setLocationRelativeTo(null); // ���ô��ڵ���ʾλ��Ϊ��Ļ���м�
		setVisible(true); // ���ô��ڿɼ�
		
		
		
		btnyes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = txtname.getText().trim();
				String pass = txtpass.getText().trim();
				String role = txtrole.getText().trim();
				
				
				try {
					if (DataProcessing.updateUser(name, pass, role) == true)
						JOptionPane.showMessageDialog(ChaUser.this, "�޸ĳɹ���", "�ɹ�",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(ChaUser.this, "�޸�ʧ�ܣ�", "����",
								JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(ChaUser.this, "���ݿ����" + e.getMessage(), "����",
							JOptionPane.ERROR_MESSAGE); // ����������Ϣ��ʾ��
				}

			}
		});
		
		
		
		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChaUser.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�

			}
		});
		
	}
}