package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;

public class TaoSV extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoSV frame = new TaoSV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaoSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(28, 51, 46, 21);
		contentPane.add(lblID);
		
		tfID = new JTextField();
		tfID.setBounds(84, 51, 145, 21);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(28, 93, 46, 14);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(84, 86, 145, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(84, 135, 89, 23);
		contentPane.add(btnCreate);
		// tao Update
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connectDB();
					stmt =conn.createStatement();
					stmt.executeUpdate("Update sinhvien set Name ='"+tfName.getText()+"' " + " where ID ='"+tfID.getText()+"' ");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnUpdate.setBounds(183, 135, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(282, 135, 89, 23);
		contentPane.add(btnDelete);
		
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt =conn.createStatement();
					stmt.executeUpdate("Insert into sinhvien(ID,Name) "+"value('"+tfID.getText()+"','"+tfName.getText()+"')");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
	}
	
	//tao doi tuong connect
	Connection conn;
	Statement stmt;
	//tao ham connect DB
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/qlsv", "root", "");
			System.out.println("Connect Sucess");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}


