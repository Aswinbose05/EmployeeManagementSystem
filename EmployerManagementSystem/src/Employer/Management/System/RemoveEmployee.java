package Employer.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener {
	
	Choice choiceEMPID;
	JButton delete,back;
	
	RemoveEmployee(){
		
		JLabel label=new JLabel("Employee Id");
		label.setBounds(50,50,100,30);
		label.setFont(new Font("Tahoma",Font.BOLD,15));
		add(label);
		
		choiceEMPID=new Choice();
		choiceEMPID.setBounds(200,50,150,30);
		add(choiceEMPID);
		
		try {
			conn c=new conn();
			ResultSet resultSet=c.statement.executeQuery("select*from employee");
			while(resultSet.next()) {
				choiceEMPID.add(resultSet.getString("empId"));
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50,100,100,30);
		labelname.setFont(new Font("Tahoma",Font.BOLD,15));
		add(labelname);
		
		JLabel textname=new JLabel();
		textname.setBounds(200,100,100,30);
		add(textname);
		
		JLabel labelphone=new JLabel("Phone");
		labelphone.setBounds(50,150,100,30);
		labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
		add(labelphone);
		
		JLabel textphone=new JLabel();
		textphone.setBounds(200,150,100,30);
		add(textphone);
		
		JLabel labelemail=new JLabel("Email");
		labelemail.setBounds(50,200,100,30);
		labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
		add(labelemail);
		
		JLabel textemail=new JLabel();
		textemail.setBounds(200,200,100,30);
		add(textemail);
		try {
			conn c=new conn();
			ResultSet resultSet=c.statement.executeQuery("select*from employee where empID='"+choiceEMPID.getSelectedItem()+"'");
			while(resultSet.next()) {
				textname.setText(resultSet.getString("name"));
				textphone.setText(resultSet.getString("phone"));
				textemail.setText(resultSet.getString("mail"));
				
			}
		}
		catch(Exception E) {
			E.printStackTrace();
			
		}
		
		choiceEMPID.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				try {
					conn c=new conn();
					ResultSet resultSet=c.statement.executeQuery("select*from employee where empID='"+choiceEMPID.getSelectedItem()+"'");
					while(resultSet.next()) {
						textname.setText(resultSet.getString("name"));
						textphone.setText(resultSet.getString("phone"));
						textemail.setText(resultSet.getString("mail"));
					}
				}
				catch(Exception E) {
					E.printStackTrace();
				}
				
			}
			
		});
		
		delete=new JButton("Delete");
		delete.setBounds(80,300,100,30);
		delete.setBackground(Color.black);
		delete.setForeground(Color.white);
		delete.addActionListener(this);
		add(delete);
		
		back=new JButton("Back");
		back.setBounds(220,300,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(700,80,200,200);
		add(img);
		
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
		Image i22=i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
		ImageIcon i33=new ImageIcon(i22);
		JLabel imgg=new JLabel(i33);
		imgg.setBounds(0,0,1120,630);
		add(imgg);

		
		
		setSize(1000,400);
		setLocation(300,150);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String args[]) {
		new RemoveEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==delete) {
			try {
				conn c=new conn();
				String  query="delete from employee where empid='"+choiceEMPID.getSelectedItem()+"'";
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
				setVisible(false);
				new Main_class();
				
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
		
		
	}

}
