package Employer.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_class extends JFrame{
	Main_class(){
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(0,0,1120,630);
		add(img);
		
		JLabel heading=new JLabel("Hello Manager Welcomes You");
		heading.setBounds(360,155,400,40);
		heading.setFont(new Font("Raleway",Font.BOLD,25));
		img.add(heading);
		
		JButton add=new JButton("Add Employee");
		add.setBounds(335,270,150,40);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddEmployee();
				setVisible(false);
				
			}
		});
		img.add(add);
		
		JButton view=new JButton("View Employee");
		view.setBounds(565,270,150,40);
		view.setBackground(Color.black);
		view.setForeground(Color.white);
		view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new View_Employee();
				setVisible(false);
				
			}});
		img.add(view);
		
		JButton rem=new JButton("Remove Employee");
		rem.setBounds(440,370,150,40);
		rem.setBackground(Color.black);
		rem.setForeground(Color.white);
		rem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RemoveEmployee();
			}
		});
		img.add(rem);
		
		
		setSize(1120,630);
		setLocation(250,100);
		setLayout(null);
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		new Main_class();
	}
}
