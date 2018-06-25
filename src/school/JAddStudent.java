package school;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

import java.util.regex.*;//������ʽ��

public class JAddStudent {
	public static final String dbdriver = "com.mysql.jdbc.Driver";
    public static final String dburl = "jdbc:mysql://localhost:3306/school?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String dbuser = "root";
    public static final String dbpass = "lanshuai2468";
    public static Connection conn;
	public static Statement stmt;
	public static ResultSet rs;
	public static String sql;
	
	public static JFrame f;
	public static JButton b1,b2;
	public static JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
	public static JComboBox cb1,cb2;
	public static JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	public static Font font,font1;
	
	String[] sexs = new String[] {"��","Ů"};
	String[] majors = new String[] {"�����","��Ϣ��ȫ","�������","����������"};
	
	
	public JAddStudent(){
		f = new JFrame("�½�ѧ��������Ϣ");
		f.setSize(1000, 600);
		f.setLocation(160, 80);
		f.setLayout(null);
		
		l0 = new JLabel("�½�ѧ��������Ϣ");
		l0.setSize(300,50);
		l0.setLocation(400, 10);
		font = new Font("����",Font.BOLD,25);
		l0.setFont(font);
		l0.setForeground(Color.BLUE);
		
		l1 = new JLabel("ѧ��:");
		l1.setSize(100,50);
		l1.setLocation(80, 50);
		font1 = new Font("����",Font.BOLD,20);
		l1.setFont(font1);
		l1.setForeground(Color.DARK_GRAY);
		
		t1 = new JTextField("");
		t1.setSize(100,30);
		t1.setLocation(180, 60);

		l2 = new JLabel("����:");
		l2.setSize(100, 50);
		l2.setLocation(80,100);
		l2.setFont(font1);
		l2.setForeground(Color.darkGray);
		
		t2 = new JTextField("");
		t2.setSize(100,30);
		t2.setLocation(180, 110);
		
		l3 = new JLabel("�Ա�:");
		l3.setSize(100, 50);
		l3.setLocation(80,150);
		l3.setFont(font1);
		l3.setForeground(Color.darkGray);
		
		cb1 = new JComboBox(sexs);
		cb1.setSize(100, 30);
		cb1.setLocation(180,160);
		
		l4 = new JLabel("����:");
		l4.setSize(100, 50);
		l4.setLocation(80,200);
		l4.setFont(font1);
		l4.setForeground(Color.darkGray);
		
		t4 = new JTextField("");
		t4.setSize(100, 30);
		t4.setLocation(180,210);
		
		l5 = new JLabel("���֤��:");
		l5.setSize(100, 50);
		l5.setLocation(80,250);
		l5.setFont(font1);
		l5.setForeground(Color.darkGray);
		
		t5 = new JTextField("");
		t5.setSize(300, 30);
		t5.setLocation(180,260);
		
		l6 = new JLabel("רҵ:");
		l6.setSize(100, 50);
		l6.setLocation(80,300);
		l6.setFont(font1);
		l6.setForeground(Color.darkGray);
		
		cb2 = new JComboBox(majors);
		cb2.setSize(200, 30);
		cb2.setLocation(180, 310);
		
		l7 = new JLabel("��ϵ�绰:");
		l7.setSize(100, 50);
		l7.setLocation(80,350);
		l7.setFont(font1);
		l7.setForeground(Color.darkGray);
		
		t7 = new JTextField("");
		t7.setSize(200, 30);
		t7.setLocation(180,360);
		
		l8 = new JLabel("��ͥסַ:");
		l8.setSize(100, 50);
		l8.setLocation(80,400);
		l8.setFont(font1);
		l8.setForeground(Color.darkGray);
		
		t8 = new JTextField("");
		t8.setSize(300, 30);
		t8.setLocation(180,410);
		
		b1 = new JButton("ȷ��");
		b1.setSize(100, 30);
		b1.setLocation(300,490);
		b1.addActionListener(new ActionListener(){
			//ȷ�ϵ�¼��Ϣ
			public void actionPerformed(ActionEvent e){
				AddST();
			}
		});
		
		b2= new JButton("����");
		b2.setSize(100, 30);
		b2.setLocation(500,490);
		b2.addActionListener(new ActionListener(){
			//ȷ�ϵ�¼��Ϣ
			public void actionPerformed(ActionEvent e){
				f.dispose();
				JOpera_manager jm = new JOpera_manager();
				
			}
		});
		
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
    	
		
		f.add(l0);
		f.add(l1);f.add(t1);
		f.add(l2);f.add(t2);
		f.add(l3);f.add(cb1);
		f.add(l4);f.add(t4);
		f.add(l5);f.add(t5);
		f.add(l6);f.add(cb2);
		f.add(l7);f.add(t7);
		f.add(l8);f.add(t8);
		f.add(b1);f.add(b2);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
	
	public static void AddST(){
		//�½�ѧ����Ϣ
		
		//�ж������Ƿ�Ϸ�
		if(!Reasonable_judgment())
			return;
		System.out.println("���е�����");
    	try{
    		sql = "insert into student values ('"
    				+ t1.getText() +"','"//sno
    				+ t2.getText() +"','"//sname
    				+ cb1.getSelectedItem() + "',"//ssex
    				+ t4.getText() + ",'"//sage
    				+ t5.getText() + "','"//sid
    				+ cb2.getSelectedItem() + "','"//sdept
    				+ t7.getText() + "','"//phonenumber
    				+ t8.getText() + "')";//address
    		
    		System.out.println("sql:"+sql);
    		stmt = conn.createStatement();
    		stmt.execute(sql);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	try{
    		stmt.close();
    		//System.out.println("Success to execute update");
    	}catch( Exception e){
    		e.printStackTrace();
    	}
    	
    	//д��ѧ����¼�����
    	try{
    		sql = "insert into stlogin values ('"
    				+ t1.getText() + "','"
    				+ "St" + t5.getText().substring(12, 18) + "')";//substring��start��stop-1��������stop
    		
    		System.out.println("sql:"+sql);
    		stmt = conn.createStatement();
    		stmt.execute(sql);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	try{
    		stmt.close();
    		//System.out.println("Success to execute update");
    	}catch( Exception e){
    		e.printStackTrace();
    	}

    	
    	try{
    		conn.close();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	
		f.setVisible(false);
		JOpera_manager jm = new JOpera_manager();
		f.dispose();
	}
	
	//������Ϣ�������ж�
	public static boolean Reasonable_judgment(){
		if(t1.getText().length() != 9){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "ѧ�ų���ӦΪ9λ", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(!exist(t1.getText())){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "ѧ���Ѵ���", "���ݿ⾯��", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		Pattern pattern1 = Pattern.compile("[a-zA-Z0-9]*");
		Matcher snoright = pattern1.matcher(t1.getText());
		if(!snoright.matches()){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "ѧ��ֻ�������ֺʹ�Сд��ĸ���", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(t2.getText().length() == 0){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "��������Ϊ��", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(t4.getText().length() == 0){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "���䲻��Ϊ��", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(t4.getText());
		if(!isNum.matches()){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "����Ӧ��������", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
			
		if(t5.getText().length() != 18){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "���֤�ų���Ϊ18λ", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(t7.getText().length() == 0){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "��ϵ�绰����Ϊ��", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(t8.getText().length() == 0){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "��ͥסַ����Ϊ��", "��ʽ����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
			
		
		return true;
	}
	
	//�ж�ѧ���Ƿ��Ѿ�����
	public static boolean exist(String sno){
		sql = "select count(*) from student where sno = '" + t1.getText() + "'";
		System.out.println(sql);
		int count = 0;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
	
			while(rs.next()){
				count = rs.getInt(1);
			}
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		if(count != 0)
			return false;
		return true;
	}
}
