package net.jason.chat;

import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class Server extends JFrame {

	Server(){
		
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(53, 69, 67));
		p1.setBounds(0, 0, 450, 70);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/arrow2.png"));
		Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back = new JLabel(i3);
		back.setBounds(10, 20, 25, 25);
		p1.add(back);
		
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.out.println("마우스클릭");
				System.exit(0);
			}
		});
		
		//본인 대화 아이콘
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel profile = new JLabel(i6);
		profile.setBounds(50, 10, 50, 50);
		p1.add(profile);
		
		//영상 아이콘
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel video = new JLabel(i9);
		video.setBounds(300, 20, 30, 30);
		p1.add(video);
		
		//전화기 아이콘
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
		Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		JLabel phone = new JLabel(i12);
		phone.setBounds(360, 20, 30, 30);
		p1.add(phone);
		
		//메뉴 아이콘
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3btn.png"));
		Image i14 = i13.getImage().getScaledInstance(7, 25, Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14);
		JLabel moreev = new JLabel(i15);
		moreev.setBounds(410, 25, 7, 25);
		p1.add(moreev);
		
		JLabel name = new JLabel("Jason Hur");
		name.setBounds(110, 18, 100, 18);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		p1.add(name);
		
		JLabel status = new JLabel("Active Now");
		status.setBounds(110, 35, 100, 18);
		status.setForeground(Color.WHITE);
		status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
		p1.add(status);
		
		setSize(450, 700);
		setLocation(200, 50);
		getContentPane().setBackground(Color.WHITE);

		setVisible(true);
	}
	public static void main(String[] args) {
		new Server();
	}
}
