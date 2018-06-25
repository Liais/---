package school;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JDeleteCourse {
	//���ݿ����
	public static final String dbdriver = "com.mysql.jdbc.Driver";
    public static final String dburl = "jdbc:mysql://localhost:3306/school?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String dbuser = "root";
    public static final String dbpass = "lanshuai2468";
    public static Connection conn;
	public static Statement stmt;
	public static ResultSet rs;
	public static String sql;
	
	//����ؼ�
	public static JFrame f;
	public static JLabel l1;
	public static JTextField t1;
	public static JButton b1,b2;
	public static boolean withcno = true;
	public JDeleteCourse(){
		//***********��ʼ�����ݿ����****************
		try{
    		Class.forName(dbdriver);
    		System.out.println("Success loading MySQL driver!");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("Error to loading MySQL driver");
    	}
    	
    	try{
    		System.out.println("Success to connect mysql");
    		conn = DriverManager.getConnection(dburl, dbuser, dbpass);
    	}
    	catch(SQLException e){
    		System.out.println("Error to connect mysql");
    		e.printStackTrace();
    	}
    	//***************************************
    	

    	
		f = new JFrame("ɾ���γ�");
		f.setSize(400, 300);
		f.setLocation(540, 280);
		f.setLayout(null);
		
		l1 = new JLabel("������γ̺�");
		l1.setSize(90, 30);
		l1.setLocation(50, 100);
		
		t1 = new JTextField("");
		t1.setSize(150, 30);
		t1.setLocation(140, 100);
		
		String[] Jinquiry_mode = new String[] {"��ѧ�Ų���","����������"};
		JComboBox cb = new JComboBox(Jinquiry_mode);
		cb.setBounds(150, 30, 100, 30);
		cb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("cb.selectedIndex:" + cb.getSelectedIndex());
				if(cb.getSelectedIndex() == 1){
					//ʹ�ÿγ̺Ų�ѯ
					withcno = false;
					l1.setText("������γ���");
				}
				else{
					//ʹ�ÿγ�����ѯ
					withcno = true;
					l1.setText("������γ̺�");
				}
			}
		});
		b1 = new JButton("ɾ��");
		b1.setSize(80, 30);
		b1.setLocation(80, 200);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				/*if(exist(withsno,t1.getText())){
				f.dispose();
				JstudentInfo st = new JstudentInfo(t1.getText(),withsno, false);
				}
				else{
					JOptionPane.showMessageDialog(null, "�޴��û�");
				}*/
				deleteCourse(t1.getText(),withcno);
				f.dispose();
				JOpera_manager om = new JOpera_manager();
			}
		});
		
		b2 = new JButton("����");
		b2.setSize(80, 30);
		b2.setLocation(230, 200);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.dispose();
				JOpera_manager om = new JOpera_manager();
			}
		});
		
		
		f.add(l1);
		f.add(t1);
		f.add(cb);
		f.add(b1);
		f.add(b2);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void deleteCourse(String cno_cname,boolean withcno){
		try{
			if(withcno)
				sql = "delete from course where cno = '" + cno_cname + "'";
			else
				sql = "delete from course where cname = '" + cno_cname + "'";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e){

			e.printStackTrace();
		}
	}
}
