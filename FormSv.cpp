package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class FormSV extends JFrame {
	private JTextField tfTim;

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
		getContentPane().setLayout(null);
		
		JLabel lblTim = new JLabel("    Tim Kiem");
		lblTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTim.setBounds(10, 39, 106, 48);
		getContentPane().add(lblTim);
		
		tfTim = new JTextField();
		tfTim.setBounds(112, 51, 149, 28);
		getContentPane().add(tfTim);
		tfTim.setColumns(10);
		
		JButton btnTim = new JButton("Tim Kiem");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTim.setBounds(271, 54, 89, 23);
		getContentPane().add(btnTim);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(378, 54, 89, 23);
		getContentPane().add(btnNew);
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TaoSV obj = new TaoSV();
				obj.setVisible(true);
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
