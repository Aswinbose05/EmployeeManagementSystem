package Employer.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
	JButton add,back;
	Random ran=new Random();
	int number=ran.nextInt(999999999);
	
	JTextField tname,tfname,tphone,taddress,tmail,taadhar,tsalary,tfield,tdesignation;
	JDateChooser tdob;
	JComboBox Boxeducation;
	JLabel tempid;
	
	AddEmployee(){
		getContentPane().setBackground(new Color(163,255,188));
		
		JLabel headings=new JLabel("Add Employee Details");
		headings.setBounds(320,30,500,50);
		headings.setFont(new Font("serif",Font.BOLD,25));
		setSize(900,700);
		setLayout(null);
		setLocation(300,50);
		setVisible(true);
		add(headings);
		
		JLabel name=new JLabel("Name");
		name.setBounds(50,150,150,30);
		name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(name);
		
		tname=new JTextField();
		tname.setBounds(200,150,150,30);
		tname.setBackground(new Color(177,252,197));
		add(tname);
		
		JLabel Fname=new JLabel("Father Name");
		Fname.setBounds(400,150,150,30);
		Fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(Fname);
		
		tfname=new JTextField();
		tfname.setBounds(600,150,150,30);
		tfname.setBackground(new Color(177,252,197));
		add(tfname);
		
		JLabel dob=new JLabel("Date Of Birth");
		dob.setBounds(50,200,150,30);
		dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(dob);
		
		tdob=new JDateChooser();
		tdob.setBounds(200,200,150,30);
		tdob.setBackground(new Color(177,252,197));
		add(tdob);
		
		JLabel salary =new JLabel("Salary");
		salary.setBounds(400,200,150,30);
		salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(salary);
		
		tsalary=new JTextField();
		tsalary.setBounds(600,200,150,30);
		tsalary.setBackground(new Color(177,252,197));
		add(tsalary);
		
		JLabel address =new JLabel("Address");
		address.setBounds(50,250,150,30);
		address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(address);
		
		taddress=new JTextField();
		taddress.setBounds(200,250,150,30);
		taddress.setBackground(new Color(177,252,197));
		add(taddress);
		
		JLabel phone =new JLabel("Phone");
		phone.setBounds(400,250,150,30);
		phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(phone);
		
		tphone=new JTextField();
		tphone.setBounds(600,250,150,30);
		tphone.setBackground(new Color(177,252,197));
		add(tphone);
		
		JLabel mail =new JLabel("E-Mail");
		mail.setBounds(50,300,150,30);
		mail.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(mail);
		
		tmail=new JTextField();
		tmail.setBounds(200,300,150,30);
		tmail.setBackground(new Color(177,252,197));
		add(tmail);
		
		JLabel education =new JLabel("Highest Degree");
		education.setBounds(400,300,150,30);
		education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(education);
		
		String items[]= {"B.Tech","M.Tech","B.E","M.E","BBA","BCA","BSC","MSC","MBA","Diplomo","MCA","MA","PHD","BA"};
		Boxeducation =new JComboBox(items);
		Boxeducation.setBackground(new Color(177,252,197));
		Boxeducation.setBounds(600,300,150,30);
		add(Boxeducation);
		
		JLabel aadhar =new JLabel("Aadhar Number");
		aadhar.setBounds(400,350,150,30);
		aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(aadhar);
		
		taadhar=new JTextField();
		taadhar.setBounds(600,350,150,30);
		taadhar.setBackground(new Color(177,252,197));
		add(taadhar);
		
		JLabel empid =new JLabel("Employee ID");
		empid.setBounds(50,400,150,30);
		empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(empid);
		
		tempid=new JLabel(" "+number);
		tempid.setBounds(200,400,150,30);
		tempid.setBackground(new Color(177,252,197));
		tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		tempid.setForeground(Color.RED);
		add(tempid);
		
		JLabel designation =new JLabel("Designation");
		designation.setBounds(50,350,150,30);
		designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(designation);
		
		tdesignation=new JTextField();
		tdesignation.setBounds(200,350,150,30);
		tdesignation.setBackground(new Color(177,252,197));
		add(tdesignation);
		
		add=new JButton("ADD");
		add.setBounds(450,550,150,30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("BACK");
		back.setBounds(250,550,150,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
	}
	public static void main(String args[]) {
		new AddEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			String name=tname.getText();
			String fname=tfname.getText();
			String dob=((JTextField) tdob.getDateEditor().getUiComponent()).getText();
			String salary=tsalary.getText();
			String address=taddress.getText();
			String phone=tphone.getText();
			String mail=tmail.getText();
			String education=(String) Boxeducation.getSelectedItem();
			String designation=tdesignation.getText();
			String empid=tempid.getText();
			String aadhar=taadhar.getText();
			
			try {
				conn c=new conn();
				String query="Insert into employee values ('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+mail+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Details added successfully");
				setVisible(false);
				new Main_class();
				
			}catch(Exception E) {
				E.printStackTrace();			
			}
			
		}
		else {
			setVisible(false);
			new Main_class();
		}
		
		
	}
	
}
