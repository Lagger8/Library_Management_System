import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Login{
	

	private JFrame frmLibraryManagementSystem;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void Return() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLibraryManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLibraryManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibraryManagementSystem = new JFrame();
		frmLibraryManagementSystem.setTitle("Library Management System");
		frmLibraryManagementSystem.getContentPane().setForeground(Color.WHITE);
		frmLibraryManagementSystem.setBounds(100, 100, 624, 448);
		frmLibraryManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryManagementSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Goudy Stout", Font.BOLD, 15));
		lblNewLabel.setBounds(75, 45, 483, 101);
		frmLibraryManagementSystem.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(142, 152, 102, 36);
		frmLibraryManagementSystem.getContentPane().add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(227, 154, 173, 35);
		frmLibraryManagementSystem.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(142, 197, 89, 43);
		frmLibraryManagementSystem.getContentPane().add(lblNewLabel_2);
		
		pass = new JPasswordField();
		pass.setBounds(227, 201, 173, 36);
		frmLibraryManagementSystem.getContentPane().add(pass);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\msasi\\Downloads\\iconfinder_thefreeforty_register_1243707.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup s = new Signup();
				s.setVisible(true);
				frmLibraryManagementSystem.dispose();
			}
		});
		btnNewButton_1.setBounds(193, 352, 119, 36);
		frmLibraryManagementSystem.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Or Create a new account");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(193, 322, 173, 26);
		frmLibraryManagementSystem.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\msasi\\OneDrive\\Pictures\\Icons\\iconfinder_lock_511942.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
					Statement s = c.createStatement();
					String sql = "select * from employee where username='"+user.getText()+"' and password = '"+pass.getText()+"' ";
					ResultSet r = s.executeQuery(sql);
					if(r.next()) {
						Menu m = new Menu();
						m.setVisible(true);
						frmLibraryManagementSystem.dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null," incorrect username or password");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					 JOptionPane.showMessageDialog(null, "Server Down");
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(193, 253, 119, 36);
		frmLibraryManagementSystem.getContentPane().add(btnNewButton);
	}
}
