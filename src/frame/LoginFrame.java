package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField txtUserName; // ���û������ı���
	private JPasswordField txtPassword;// �����롱�ı���

	private JButton btnLogin; // ����¼����ť
	private JButton btnReset; // �����á���ť

	private JPanel pnlLogin; // ��¼���
	private JPanel pnlInput1;
	private JPanel pnlInput2;// ���á��û������͡�����"�ı�������
	private JPanel pnlButton; // ���á���¼���͡����á���ť�����

	public LoginFrame(String frameTitle) {
		// TODO Auto-generated constructor stub
		super(frameTitle);

		lblUserName = new JLabel("��       ��:  ");
		lblPassword = new JLabel("��       ��:  ");

		txtUserName = new JTextField(10);
		txtPassword = new JPasswordField(10);

		btnLogin = new JButton("��¼");
		btnReset = new JButton("����");

		pnlLogin = new JPanel(); // ��¼���
		pnlLogin.setLayout(new BorderLayout());// ���á���¼��塱�Ĳ���

		pnlInput1 = new JPanel(); 
		pnlInput2 = new JPanel(); // ���á��û������͡�����"�ı�������1\2
		
		pnlInput1.add(lblUserName);
		pnlInput1.add(txtUserName);
		pnlInput2.add(lblPassword);
		pnlInput2.add(txtPassword);

		pnlLogin.add(pnlInput1, BorderLayout.NORTH); // �����pnlInput1�����ڡ���¼��塱�ı���
		pnlLogin.add(pnlInput2, BorderLayout.CENTER);// �����pnlInput2�����ڡ���¼��塱���м�
		pnlButton = new JPanel(); // ���á���¼���͡����á���ť�����
		pnlButton.add(btnLogin);
		pnlButton.add(btnReset);
		pnlLogin.add(pnlButton, BorderLayout.SOUTH); // �����pnlButton�����ڡ���¼��塱������

		getContentPane().add(pnlLogin, BorderLayout.CENTER); // ������¼��塱�����ڴ��ڵ����������м�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���õ�����������Ͻǵġ��رա�ͼ����˳�Ӧ�ó���
		setSize(350, 200); // ���ô��ڵĴ�С
		setResizable(false); // ���ò��ɵ������ڵĴ�С
		setLocationRelativeTo(null); // ���ô��ڵ���ʾλ��Ϊ��Ļ���м�
		setVisible(true); // ���ô��ڿɼ�

		// �������á���ť�ϵ��¼�
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtUserName.setText("");
				txtPassword.setText("");
			}
		});

		// ������¼����ť�ϵ��¼�
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String name = txtUserName.getText().trim();
					String password = String.valueOf(txtPassword.getPassword()).trim();
					User user = DataProcessing.searchUser(name, password); 
					if (user != null) {
						user.showFrame(LoginFrame.this);
						txtPassword.setText("");
						LoginFrame.this.setVisible(false); // ���ô��ڲ��ɼ�
					} else {
						JOptionPane.showMessageDialog(LoginFrame.this, "�û�����������", "����", JOptionPane.ERROR_MESSAGE);// ����������Ϣ��ʾ��
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(LoginFrame.this, "���ݿ����" + ex.getMessage(), "����",
							JOptionPane.ERROR_MESSAGE); // ����������Ϣ��ʾ��
				}
			}
		});
	}
}
