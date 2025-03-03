package Employer.Management.System;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
	private static final Color Black = null;
	private static final Color white = null;
	JTextField tusername;
	JPasswordField tpassword;
	JButton login,back;
	
	Login(){
		
		JLabel username=new JLabel("USERNAME");
		username.setBounds(40,20,100,30);
		add(username);
		
		tusername=new JTextField();
		tusername.setBounds(150,20,150,30);
		add(tusername);
		
		JLabel password=new JLabel("PASSWORD");
		password.setBounds(40,70,100,30);
		add(password);
		
		tpassword =new JPasswordField();
		tpassword.setBounds(150,70,150,30);
		add(tpassword);
		
		login=new JButton("LOGIN");
		login.setBounds(150,140,150,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		back=new JButton("BACK");
		back.setBounds(150,180,150,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back); 
		
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i22=i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
		ImageIcon i33=new ImageIcon(i22);
		JLabel imgg=new JLabel(i33);
		imgg.setBounds(350,10,600,400);
		add(imgg);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
		Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(0,0,600,300);
		add(img);
		
		setSize(600,300);
		setLocation(450,200);
		setLayout(null);
		setVisible(true);
	
		
	}
	public static void main(String args[]) {
		new Login();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== login) {
			try {
				String username=tusername.getText();
				String password=tpassword.getText();
				
				conn conn=new conn();
				String query="select*from login where username = '"+username+"'and password = '"+password+"'";
				ResultSet resultSet=conn.statement.executeQuery(query);
				if(resultSet.next()) {
					setVisible(false);
					new Main_class();
				}
				else {
					JOptionPane.showMessageDialog(null,"Ivalid Username and Password");
				}
			}
			catch(Exception E) {
				E.printStackTrace();
			}
			
		}
		else if(e.getSource()== back) {
			System.exit(0);
		}
		
	}

}
