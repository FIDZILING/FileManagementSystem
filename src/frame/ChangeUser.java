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
	
	private JFrame parentFrame; // ������
	private User user; // ��ǰ�û�


	private JTable userlist;
	
	public ChangeUser(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;
		JLabel list = new JLabel("�û��б�:");
		
		JPanel pn1 = new JPanel();// �����
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();
		

		JButton btnchange = new JButton("�޸��û�");
		JButton btndel = new JButton("ɾ���û�");
		JButton btninput = new JButton("�����û�");
		JButton btnout = new JButton("�˳�");
		
		String[] titles = {"����", "����", "���"};
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
		pn1.setLayout(new BorderLayout());// ���á���¼��塱�Ĳ���
		pn1.add(pn2,BorderLayout.NORTH);
		pn1.add(pn3,BorderLayout.CENTER);
		pn1.add(pn4,BorderLayout.SOUTH);
		
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(1000, 600); // ���ô��ڵĴ�С
		setLocationRelativeTo(null); // ���ô��ڵ���ʾλ��Ϊ��Ļ���м�

		setVisible(true); // ���ô��ڿɼ�
		
		
		btnchange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ChaUser("�޸��û�",ChangeUser.this,user);
				ChangeUser.this.dispose(); // �ͷŴ�����Դ���رմ���
			}
		});
		
		btninput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new InUser("�����û�",ChangeUser.this,user);
				ChangeUser.this.dispose(); // �ͷŴ�����Դ���رմ���
			}
		});
		
		btndel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new OutUser("ɾ���û�",ChangeUser.this,user);
				ChangeUser.this.dispose(); // �ͷŴ�����Դ���رմ���
			}
		});
		
		
		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeUser.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�
			}
		});
		
	
	}
}
