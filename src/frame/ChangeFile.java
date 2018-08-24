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
	private JFrame parentFrame; // 父窗口
	private User user; // 当前用户


	private JTable filelist;

	public ChangeFile(String frameTilte, JFrame parentframe, User user) {
		super(frameTilte);
		this.parentFrame = parentframe;
		this.user = user;


		JLabel list = new JLabel("文件列表:");
		JPanel pn1 = new JPanel();// 主面板
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();

		// 1
		// String[] titles = { "文件编号", "文件名", "上传者","上传时间","文档描述"};
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
		// String[] titles = {"文件编号", "文件名", "上传者","上传时间","文档描述"};
		// Object [][] cellData = null;
		// DefaultTableModel model = new DefaultTableModel(cellData, titles) {
		// public boolean isCellEditable(int row, int column) {
		// return false;
		// }
		// };
		// filelist = new JTable(model);
		
		String[] titles = {"文件编号", "文件名", "上传者","上传时间","文档描述"};
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
		
		
		JButton btnup = new JButton("上传文件");
		JButton btnout = new JButton("退出");
		pn1.setLayout(new BorderLayout());
		pn2.add(list);
		pn4.add(btnup);
		pn4.add(btnout);

		pn1.add(pn2, BorderLayout.NORTH);
		pn1.add(pn3, BorderLayout.CENTER);
		
		pn1.add(pn4, BorderLayout.SOUTH);
		getContentPane().add(pn1, BorderLayout.CENTER);
		setSize(1500, 900); // 设置窗口的大小
		setLocationRelativeTo(null); // 设置窗口的显示位置为屏幕的中间

		setVisible(true); // 设置窗口可见
		
		
		
		btnup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new UploadFile("上传文件选项",ChangeFile.this,user);
				ChangeFile.this.setVisible(false); // 设置窗口不可见
				
			}
		});
		
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {                 
				// TODO Auto-generated method stub
				ChangeFile.this.dispose(); // 释放窗口资源，关闭窗口
				parentFrame.setVisible(true); // 设置父窗口可见
			}
		});

	}

}
