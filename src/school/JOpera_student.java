package school;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JOpera_student {
	public static String sno;
	public static String sname;
	public static String ssex;
	public static int sage;
	public static String sid;
	public static String sdept;
	
	public static JFrame f;
	//public static JTextField t1,t2,t3;
	public static JButton b1,b2,b3,b4;
	
	public JOpera_student(String account){
		//System.out.println("in opera my sno " + account);
		f = new JFrame("ѧ���û�");
		f.setSize(400, 300);
		f.setLocation(540, 280);
		f.setLayout(null);
		
		b1 = new JButton("��ѯѧ��������Ϣ");
		b1.setSize(200, 30);
		b1.setLocation(50, 30);
		b1.addActionListener(new ActionListener(){
			//ȷ�ϵ�¼��Ϣ
			public void actionPerformed(ActionEvent e){
				f.setVisible(false);
				JstudentInfo st = new JstudentInfo(account,true,true);
				f.dispose();
			}
		});
		
		b2 = new JButton("�޶��γ̲�ѯ");
		b2.setSize(200,30);
		b2.setLocation(50, 80);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.setVisible(false);
				JSTCourseInfo c = new JSTCourseInfo(account);
				f.dispose();
			}
		});
		
		b3 = new JButton("�޸�����");
		b3.setSize(200, 30);
		b3.setLocation(50, 130);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.dispose();
				JSTPasswdUpdate st = new JSTPasswdUpdate(account);
				
			}
		});
		
		b4 = new JButton("ע����¼");
		b4.setSize(200,30);
		b4.setLocation(50, 180);
		b4.addActionListener(new ActionListener(){
			//ȷ�ϵ�¼��Ϣ
			public void actionPerformed(ActionEvent e){
				f.dispose();
				JSTlogin st = new JSTlogin();
			}
		});
		
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);

	}
}
