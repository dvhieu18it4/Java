package SinhVien;

import java.awt.Button;
import java.awt.Container;
import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;


class SinhVien extends JFrame {
	JLabel  lblID;
	JLabel  lblName;
	JTextField tfID;
	JTextField tfName;
	Button btnCreate;
	Button btnUpdate;
	
	//tao doi tuong connect
			Connection conn;
			Statement stmt;
	//tao ham connect DB
			public void connectDB() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "root", "");
					System.out.println("Connect Sucess");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
	
	public SinhVien()
	{
		Label lblID = new Label("ID");
		Label lblName = new Label("Name");
		TextField tfID = new TextField(10);
		TextField tfName = new TextField(10);
		Button btnCreate = new Button("Create");
		Button btnUpdate = new Button("Update");
		
		// thiet lap cho nut'
		btnCreate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt=conn.createStatement();
					stmt.executeUpdate("insert into SinhVien(ID,Name) ID ='"+tfID.getText()+"','"+tfName.getText()+"')");
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		String sql ="Update SinhVien set Name ='"+tfName.getText()+"' " + "where ID='"+tfID.getText()+"' ";
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt=conn.createStatement();
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// Tao contain chua lb tf button
		Container cont =this.getContentPane();
		setSize(500, 400);
		
		// tao nut'
		setLayout(new FlowLayout());
		add(lblID);
		add(lblName);
		add(tfID);
		add(tfName);
		add(btnCreate);
		add(btnUpdate);
	
	}
	

	
	
	public static void main(String[] args) {
		new SinhVien();
	}
}
