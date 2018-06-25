package school;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class JCourseInfo {
	public static final String dbdriver = "com.mysql.jdbc.Driver";
    public static final String dburl = "jdbc:mysql://localhost:3306/school?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String dbuser = "root";
    public static final String dbpass = "lanshuai2468";
    public static Connection conn,conn1;
	public static Statement stmt,stmt1;
	public static ResultSet rs,rs1;
	public static String sql,sql1;
	
	public static JFrame f;
	//�γ̱�ţ��γ����ƣ��޶�������ƽ���ɼ����ɼ���׼�ͨ���ʣ�
	public static JLabel l1,l2,l3,l4,l5,l6,l7;
	public static JLabel l22,l33,l44,l55,l66,l77;
	public static JButton b1,b2;
	public static Font font;
	
	public JCourseInfo(String cname_cno,boolean withcname){
		f = new JFrame("�γ���Ϣ");
		f.setSize(660, 450);
		f.setLocation(340, 170);
		f.setLayout(null);
		
		l1 = new JLabel("�γ���",JLabel.CENTER);
		l1.setSize(230, 40);
		l1.setLocation(200, 30);
		font = new Font("����",Font.BOLD,24);
		l1.setForeground(Color.BLUE);
		l1.setFont(font);
		//l1.setOpaque(true);
		//l1.setBackground(Color.red);
		
		//l1.setOpaque(true);
		//l1.setBackground(Color.BLUE);
		
		l2 = new JLabel("�γ̺�");
		l2.setSize(100, 30);
		l2.setLocation(100,100 );
		//l2.setOpaque(true);
		//l2.setBackground(Color.red);
		
		l22 = new JLabel("XXXX");
		l22.setSize(100, 30);
		l22.setLocation(200, 100);
		
		l3 = new JLabel("�޶�����");
		l3.setSize(100, 30);
		l3.setLocation(350, 100);
		
		l33 = new JLabel("XX");
		l33.setSize(100, 30);
		l33.setLocation(450, 100);
		
		l4 = new JLabel("ƽ���ɼ�");
		l4.setSize(100, 30);
		l4.setLocation(100, 150);
		
		l44 = new JLabel("95.0");
		l44.setSize(100, 30);
		l44.setLocation(200, 150);
		
		l5 = new JLabel("��׼��");
		l5.setSize(100, 30);
		l5.setLocation(350, 150);
		
		l55 = new JLabel("4.5");
		l55.setSize(100, 30);
		l55.setLocation(450, 150);
		
		l6 = new JLabel("ͨ����");
		l6.setSize(100, 30);
		l6.setLocation(100, 200);
		
		l66 = new JLabel("98.5%");
		l66.setSize(100, 30);
		l66.setLocation(200, 200);
		
		l7 = new JLabel("ѧ��");
		l7.setSize(100, 30);
		l7.setLocation(350, 200);
		
		l77 = new JLabel("");
		l77.setSize(100, 30);
		l77.setLocation(450, 200);
		
		b1 = new JButton("��ѯȫ��ѧ���ɼ�");
		b1.setSize(150,30);
		b1.setLocation(150, 300);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.dispose();
				JGradeList gl = new JGradeList(l22.getText());
			}
		});
		
		b2 = new JButton("����");
		b2.setSize(150, 30);
		b2.setLocation(350, 300);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.dispose();
				JSearchCourse sc = new JSearchCourse();
			}
		});
		
		//��ʼʹ�����ݿ⴦��
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
    	
    	double sumGrade = 0,aveGrade = 0,sd = 0 ;//��׼��
		int sumST = 0;//���б���Ŀ�ɼ�֮���Լ�ѡ����Ŀ��������
		int sumpassST = 0;//ͨ����Ŀ������
    	
    	try{
    		if(withcname)
    			sql = "select * from course where cname = '" + cname_cno + "'";
    		else
    			sql = "select * from course where cno = '" + cname_cno + "'";
        	System.out.println(sql);
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    		while(rs.next()){
    			l1.setText(rs.getString("cname"));//�γ�����
    			l22.setText(rs.getString("cno"));//�γ̱��
    			l77.setText(rs.getString("ccredit"));
    		}

    		//��ȡ�޶�����Ŀ��������
    		sql = "select count(*) from sc where cno = '" + l22.getText() + "'";
    		System.out.println(sql);
    		rs = stmt.executeQuery(sql);
    		while(rs.next()){
    			sumST = rs.getInt(1);
    			//sumGrade +=rs.getInt("grade");
    		}
    		
    		//����޵ı���Ŀ���˵��ܳɼ�
    		sql = "select * from sc where cno = '" + l22.getText() + "'";
    		System.out.println(sql);
    		rs = stmt.executeQuery(sql);
    		while(rs.next()){
    			sumGrade +=rs.getInt("grade");
    			if(rs.getInt("grade") >=60)
    				++sumpassST;
    		}
    		
    		aveGrade = sumGrade/sumST;//ƽ���ɼ�
    		//�����׼��
    		sql = "select * from sc where cno = '" + l22.getText() + "'";
    		System.out.println(sql);
    		rs = stmt.executeQuery(sql);
    		while(rs.next()){
    			sd += Math.pow(aveGrade-rs.getInt("grade"), 2); 
    			
    		}
    		sd = Math.sqrt(sd/sumST);
    		System.out.println("sumST:" + sumST);
    		System.out.println("sumGrade:" + sumGrade);
    		System.out.println("sumpassST:" + sumpassST);
    		stmt.close();
    		
    		//����ƽ����
    	System.out.println("Success to execute update");
    	}catch( Exception e){
    		e.printStackTrace();
    	}
		
    	l33.setText(String.valueOf(sumST));
    	//ͬ�����ս����Ŀγ�
    	if(sumST!=0)
    		l44.setText(String.valueOf(aveGrade));
    	else
    		l44.setText("0");
    	
    	
    	l55.setText(String.valueOf(sd));
		//�ս��Ŀγ�û��ѧ��ѡ��ֱ�ӳ���0�ص��½��̱���
		if(sumST != 0)
			l66.setText(String.valueOf(100*sumpassST/sumST)+"%");
		else
			l66.setText("0");
		
		
		
		f.add(l1);
		f.add(l2);f.add(l22);f.add(l3);f.add(l33);
		f.add(l4);f.add(l44);f.add(l5);f.add(l55);
		f.add(l6);f.add(l66);f.add(l7);f.add(l77);
		f.add(b1);f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}
}
