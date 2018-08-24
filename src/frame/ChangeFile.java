package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.Doc;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import common.DataProcessing;
import common.User;


public class ChangeFile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame; // ������
	private User user; // ��ǰ�û�


	private JTable filelist;

	public ChangeFile(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;


		JLabel list = new JLabel("�ļ��б�:");
		JPanel pn1 = new JPanel();// �����
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();

		// 1
		// String[] titles = { "�ļ����", "�ļ���", "�ϴ���","�ϴ�ʱ��","�ĵ�����"};
		// Object [][] obj = new Object[100][5];
		//
		// filelist = new JTable(obj,titles);
		// TableColumn columns = null;
		// int colunms = filelist.getColumnCount();
		// for(int i = 0; i < colunms; i++)
		// {
		// columns = filelist.getColumnModel().getColumn(i);
		//
		// columns.setPreferredWidth(200);
		// }
		// JScrollPane scroll = new JScrollPane(filelist);
		// scroll.setSize(30, 200);
		//// add(scroll);
		// 2
		// String[] titles = {"�ļ����", "�ļ���", "�ϴ���","�ϴ�ʱ��","�ĵ�����"};
		// Object [][] cellData = null;
		// DefaultTableModel model = new DefaultTableModel(cellData, titles) {
		// public boolean isCellEditable(int row, int column) {
		// return false;
		// }
		// };
		// filelist = new JTable(model);
		
		String[] titles = {"�ļ����", "�ļ���", "�ϴ���","�ϴ�ʱ��","�ĵ�����"};
		int  k = DataProcessing.docs.size();
		Object[][] cellData = new Object[k][5];
//		Doc value = (Doc) DataProcessing.docs.values();
//		int i = 0;
//		for(;i<k;i++){
//
//			cellData[i][0] = value.getID();
//			cellData[i][1] = value.getFilename();
//			cellData[i][2] = value.getCreator();
//			cellData[i][3] = value.getTimestamp();
//			cellData[i][4] = value.getDescription();
//
//		}

		int i = 0;
		for(common.Doc value:DataProcessing.docs.values()){
			cellData[i][0] = value.getID();
			cellData[i][1] = value.getFilename();
			cellData[i][2] = value.getCreator();
			cellData[i][3] = value.getTimestamp();
			cellData[i][4] = value.getDescription();
			i++;
		}
		filelist = new JTable(cellData,titles);
		JScrollPane scroll = new JScrollPane(filelist);
		pn3.add(scroll, BorderLayout.CENTER);
		
		
		JButton btnup = new JButton("�ϴ��ļ�");
		JButton btnout = new JButton("�˳�");
		pn1.setLayout(new BorderLayout());
		pn2.add(list);
		pn4.add(btnup);
		pn4.add(btnout);

		pn1.add(pn2, BorderLayout.NORTH);
		pn1.add(pn3, BorderLayout.CENTER);
		
		pn1.add(pn4, BorderLayout.SOUTH);
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(1500, 900); // ���ô��ڵĴ�С
		setLocationRelativeTo(null); // ���ô��ڵ���ʾλ��Ϊ��Ļ���м�

		setVisible(true); // ���ô��ڿɼ�
		
		
		
		btnup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new UploadFile("�ϴ��ļ�ѡ��",ChangeFile.this,user);
				ChangeFile.this.setVisible(false); // ���ô��ڲ��ɼ�
				
			}
		});
		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {                 
				// TODO Auto-generated method stub
				ChangeFile.this.dispose(); // �ͷŴ�����Դ���رմ���
				parentFrame.setVisible(true); // ���ø����ڿɼ�
			}
		});

	}

}
