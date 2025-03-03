package Employer.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class View_Employee extends JFrame implements ActionListener{
	JButton searchbtn,update,print,back;
	JTable table;
	Choice choiceEMP;
	View_Employee(){
		getContentPane().setBackground(new Color(255,131,122));
		JLabel search=new JLabel("Search By Employee ID");
		search.setBounds(20,20,150,20);
		add(search);
		
		choiceEMP=new Choice();
		choiceEMP.setBounds(180,20,150,20);
		add(choiceEMP);
		
		try {
			conn c=new conn();
			ResultSet resultSet=c.statement.executeQuery("Select*from employee");
			while(resultSet.next()) {
				choiceEMP.add(resultSet.getString("empID"));	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		table=new JTable();
		try {
			conn c=new conn();
			ResultSet resultSet=c.statement.executeQuery("Select*from employee");
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(0,100,900,600);
		add(jp);
		
		searchbtn=new JButton("Search");
		searchbtn.setBounds(20,70,80,20);
		searchbtn.addActionListener(this);
		add(searchbtn);
		
		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		update=new JButton("Update");
		update.setBounds(220,70,80,20);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setBounds(320,70,80,20);
		back.addActionListener(this);
		add(back);
		
		setSize(900,700);
		setLayout(null);
		setLocation(300,100);
		setVisible(true);
	}
	
	
	public static void main(String args[]) {
		new View_Employee();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==searchbtn) {
			String query="Select*from employee where empID='"+choiceEMP.getSelectedItem()+"'";
			try {
				conn c=new conn();
				ResultSet resultSet=c.statement.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(resultSet));
				
			}
			catch(Exception E) {
				E.printStackTrace();
			}
		}
		else if(e.getSource()==print) {
			try {
				table.print();
			}
			catch(Exception E) {
				E.printStackTrace();
			}
		}
		else if(e.getSource()== update) {
			setVisible(false);
			new UpdateEmployee(choiceEMP.getSelectedItem());
		}
		else{
			setVisible(false);
			new Main_class();
		}
		
		
	}
}
