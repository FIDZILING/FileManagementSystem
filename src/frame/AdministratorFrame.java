package frame;

//import java.awt.BorderLayout;
//import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;

import common.User;

public class AdministratorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame parentFrame; // ������
	private User user; // ��ǰ�û�

	// private JButton btnChangeUsers;// �޸��û���ť
	// private JButton btnDelUsers;// ɾ���û���ť
	// private JButton btnAddUsers;// �����û���ť
	// private JButton btnShowUers;// �г��û���ť
	// private JButton btnDownloadFile; // �����ļ���ť
	// private JButton btnShowFileList; // ��ʾ�ļ��б�ť
	// private JButton btnModiPsd; // �޸����밴ť
	// private JButton btnExit; // �˳���ť
	//
	// private JPanel panel; // ���
	//
	//
	// public AdministratorFrame(String frameTilte, JFrame parentframe, User
	// user) {
	// // TODO Auto-generated constructor stub
	// super(frameTilte);
	// this.parentFrame = parentframe;
	// this.user = user;
	//
	// btnChangeUsers = new JButton("�� �� �� ��");
	// btnDelUsers = new JButton("ɾ �� �� ��");
	// btnAddUsers = new JButton("�� �� �� ��");
	// btnShowUers = new JButton("�� �� �� ��");
	// btnDownloadFile = new JButton("�� �� �� ��");
	// btnShowFileList = new JButton("�� �� �� ��");
	// btnModiPsd = new JButton("�� �� �� ��");
	// btnExit = new JButton("�� �� �� ¼");
	//
	// panel = new JPanel();
	// panel.setLayout(new GridLayout(8, 1)); // ������岼��Ϊ���񲼾֣���8��1��
	// panel.add(btnChangeUsers);
	// panel.add(btnDelUsers);
	// panel.add(btnAddUsers);
	// panel.add(btnShowUers);
	// panel.add(btnDownloadFile);
	// panel.add(btnShowFileList);
	// panel.add(btnModiPsd);
	// panel.add(btnExit);
	//
	// getContentPane().add(panel, BorderLayout.CENTER);// ��panel�����ڴ��ڵ����������м�
	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
	// ���õ�����������Ͻǵġ��رա�ͼ����˳�Ӧ�ó���
	// setSize(350, 250);// ���ô��ڵĴ�С
	// this.setResizable(false);// ���ò��ɵ������ڵĴ�С
	// this.setLocationRelativeTo(null);// ���ô��ڵ���ʾλ��Ϊ��Ļ���м�
	// this.setVisible(true);// ���ô��ڿɼ�
	//
	// // �����˳�����ť�¼�
	// btnExit.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// AdministratorFrame.this.dispose(); // �ͷŴ�����Դ���رմ���
	// parentFrame.setVisible(true); // ���ø����ڿɼ�
	// }
	// });
	//
	// // �����޸��û�����ť�¼�
	// btnChangeUsers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // new ChangeUserInfoFrame("�޸��û�",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // ����ɾ���û�����ť�¼�
	// btnDelUsers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("ɾ���û�",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // ���������û�����ť�¼�
	// btnAddUsers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("�����û�",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // �����г��û�����ť�¼�
	// btnShowUers.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("�г��û�",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // ���������ļ�����ť�¼�
	// btnDownloadFile.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new DownLoadFileFrame("�����ļ�",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // �����ļ��б���ť�¼�
	// btnShowFileList.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new ShowFileListFrame("�ļ��б�",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	//
	// // �����޸����롱��ť�¼�
	// btnModiPsd.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// // TODO Auto-generated method stub
	// // new ModiPsdFrame("�޸�����",AdministratorFrame.this,user);
	// AdministratorFrame.this.setVisible(false);
	// }
	// });
	// }
	//
	//
	//
	//
	//
	//
	//

	public AdministratorFrame(String frameTilte, JFrame parentframe, User user) {
		// TODO Auto-generated constructor stub
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;

		setLocationRelativeTo(null);// ���ô��ڵ���ʾλ��Ϊ��Ļ���м�

		MenuBar mBar = new MenuBar();
		Menu menu1 = new Menu("����");
		Menu menu2 = new Menu("�ļ�");
		Menu menu3 = new Menu("�û�");
		Menu menu4 = new Menu("ϵͳ");
		MenuItem mi11 = new MenuItem("�޸�����");
		MenuItem mi21 = new MenuItem("�ϴ��ļ�");
		MenuItem mi22 = new MenuItem("�����ļ�");
		MenuItem mi31 = new MenuItem("�޸��û�");
		MenuItem mi32 = new MenuItem("ɾ���û�");
		MenuItem mi33 = new MenuItem("�����û�");
		MenuItem mi41 = new MenuItem("ע����¼");
		MenuItem mi42 = new MenuItem("����");

		menu1.add(mi11);
		menu2.add(mi21);
		// menu2.addSeparator();//�ó�= =
		menu2.add(mi22);
		mi21.setEnabled(false);
		menu3.add(mi31);
		menu3.add(mi32);
		menu3.add(mi33);
		menu4.add(mi41);
		menu4.add(mi42);
		// menu4.setEnabled(false);//�����˳���
		mBar.add(menu1);
		mBar.add(menu2);
		mBar.add(menu3);
		mBar.add(menu4);
		setMenuBar(mBar);
		setSize(400, 250);
		setVisible(true);

		mi11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeInfoSelf("�޸ĸ��˵���Ϣ", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeFile2("�����ļ�", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi31.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeUser("�û���Ϣ", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi32.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeUser("�û���Ϣ", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi33.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangeUser("�û���Ϣ", AdministratorFrame.this, user);
				AdministratorFrame.this.setVisible(false);
			}

		});

		mi41.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdministratorFrame.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�
			}

		});

		// mi42.addActionListener(new ActionListener(){
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // TODO Auto-generated method stub
		// new About("����",AdministratorFrame.this,user);
		// AdministratorFrame.this.setVisible(false);
		// }
		//
		// });

	}
}