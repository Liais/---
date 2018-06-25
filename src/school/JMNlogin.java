package school;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


//ѧ���û���¼����
public class JMNlogin {
	//����ؼ�
	public static JFrame f;
	public static JLabel l1,l2,l3,l4,l5,l6;
	public static JTextField t1;
	public static JPasswordField t2;
	public static JButton b1,b2;
	public static Font font,font1;
	
	//���ݿ����
	public static final String dbdriver = "com.mysql.jdbc.Driver";
    public static final String dburl = "jdbc:mysql://localhost:3306/school?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String dbuser = "root";
    public static final String dbpass = "lanshuai2468";
    public static Connection conn;
	public static Statement stmt;
	public static ResultSet rs;
	
	
	public JMNlogin(){
		f = new JFrame("����Ա�û���¼");
		f.setSize(400, 300);
		f.setLocation(540, 280);
		f.setLayout(null);
		
		l1 = new JLabel("�û���:");
		l1.setSize(50, 30);
		l1.setLocation(50, 30);
		
		t1 = new JTextField("");
		//t1.setText("Ĭ��Ϊѧ��");
		t1.setBounds(120, 30, 150, 30);
		
		l5 = new JLabel("���û�������");
		l5.setSize(80, 30);
		l5.setLocation(280, 30);
		font1 = new Font("����",Font.PLAIN,10);
		l5.setFont(font1);
		l5.setForeground(Color.red);
		l5.setVisible(false);
		
		font1 = new Font("����",Font.PLAIN,10);
		
		//l3 = new JLabel("(Ĭ��Ϊѧ��)");
		//l3.setSize(80,30);
		//l3.setLocation(120, 60);
		//font = new Font("Monospaced",Font.BOLD,10);
		//l3.setFont(font);
		
		l2 = new JLabel("����:");
		l2.setSize(50, 30);
		l2.setLocation(50, 100);
		
		t2 = new JPasswordField("");
		//t2.setText("Ĭ��ΪSt+���֤����λ");
		t2.setBounds(120, 100, 150, 30);
		
		l6 = new JLabel("���벻��ȷ");
		l6.setSize(80, 30);
		l6.setLocation(280, 100);
		font1 = new Font("����",Font.PLAIN,10);
		l6.setFont(font1);
		l6.setForeground(Color.red);
		l6.setVisible(false);
		
		//l4 = new JLabel("(Ĭ��ΪSt+���֤�ź���λ)");
		//l4.setSize(160,30);
		//l4.setLocation(120, 130);
		//font = new Font("Monospaced",Font.BOLD,10);
		//l4.setFont(font);
		
		
		
		b1 = new JButton("ȷ��");
		b1.setSize(80, 30);
		b1.setLocation(50, 200);
		b1.addActionListener(new ActionListener(){
			//ȷ�ϵ�¼��Ϣ
			public void actionPerformed(ActionEvent e){
				l5.setVisible(false);
				l6.setVisible(false);
				MNlanding();
				f.dispose();
			}
		});
		
		b2 = new JButton("����");
		b2.setSize(80, 30);
		b2.setLocation(200, 200);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				backlanding();
			}
		});
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		//f.add(l3);
		f.add(t2);
		//f.add(l4);
		f.add(b1);
		f.add(b2);
		f.add(l5);
		f.add(l6);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
	}
	
	//���ص�¼������
	public static void backlanding(){
		f.dispose();
		Jlogin l = new Jlogin();
	}
	
	//ʹ��������û����������¼
	public static void MNlanding(){
		
		String account = t1.getText().toString();
		String passwd = t2.getText().toString();
		String sql = null;
		rs = null;
		
		//System.out.println(t1.getText().toString());
		//System.out.println(t2.getText().toString());
		
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
    	
    	try{
    		sql = "select password from mnlogin where account = '" + account + "'";
    		System.out.println("sql:"+sql);
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    		if(rs!=null&&rs.next()){
    			//�д��û�
    			//System.out.println("fought");
    			String realpasswd = rs.getString("password");
    			
    			if(realpasswd.equals(passwd))
    			{
    				//��¼�ɹ�
    				System.out.println("��¼�ɹ�");
    				JOpera_manager jm = new JOpera_manager();
    			}
    			else
    			{
    				System.out.println("�û��������벻ƥ��");
    				l6.setVisible(true);
    			}
    		}
    		else{
    			//System.out.println("not fought");
    			//�޴��û�
    			System.out.println("�޴��û�");
    			l5.setVisible(true);
    		}
    		
    		
    		//System.out.println(rs.getString("account"));
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
	}
}
