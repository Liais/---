package school;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Jlogin {
	public static JFrame f;
	public static JLabel l;
	public static Font font;
	public static JButton b1,b2;
	public Jlogin(){
		f = new JFrame("ѧ����Ϣ����ϵͳ");
		f.setSize(400, 300);
		f.setLocation(540, 280);
		f.setLayout(null);
		
		//���õ�¼�������
		l = new JLabel("�û���¼");
		l.setSize(300, 50);
		l.setLocation(120, 40);
		l.setForeground(Color.red);
		font = new Font("Monospaced",Font.BOLD,32);
		l.setFont(font);
		
		b1 = new JButton("ѧ���û�");
		b1.setBounds(140, 120, 100, 40);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e ){
				studentlanding();
			}
		});
		
		b2 = new JButton("����Ա");
		b2.setBounds(140, 190, 100, 40);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerlanding();
			}
		});
		
		f.add(l);
		f.add(b1);
		f.add(b2);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
	
	//��ѧ����¼����
	public static void studentlanding(){
		f.dispose();
		JSTlogin st = new JSTlogin();
		
	}
	
	//�򿪹���Ա��¼����
	public static void managerlanding(){
		f.dispose();
		JMNlogin mn = new JMNlogin();
	}
	
	public static void main (String[] args){
		Jlogin l = new Jlogin();
		
	}
	
	
}
