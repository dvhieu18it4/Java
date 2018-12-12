package SinhVien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.Color;
import javax.swing.JButton;

public class FormSV extends JFrame {

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
					FormSV frame = new FormSV();
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
	public FormSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(34, 49, 44, 20);
		contentPane.add(lblID);
		
		tfID = new JTextField();
		tfID.setBounds(105, 49, 118, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(32, 93, 44, 20);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(105, 94, 118, 19);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		// BUTTON CREATE
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(71, 138, 89, 23);
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt=conn.createStatement();
					stmt.executeUpdate("insert into sinhvien(ID,Name) values ('"+tfID.getText()+"','"+tfName.getText()+"')");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		// BUTTON UPDATE
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(194, 138, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt = conn.createStatement();
					stmt.executeUpdate("Update SinhVien set Name ='"+tfName.getText()+"' " + "where ID='"+tfID.getText()+"' ");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		// Tim Kiem
		JButton btnTim = new JButton("Tim Kiem");
		btnTim.setBounds(307, 138, 89, 23);
		contentPane.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt =conn.createStatement();
					String sql ="SELECT Name From sinhvien Where ID= ?";
					conn.prepareStatement(sql);
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
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ql", "root", "");
				System.out.println("Connect Sucess");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
}
