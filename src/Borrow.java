import java.awt.BorderLayout;
import java.util.*;
import java.text.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Borrow extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JLabel lblStudentName;
	private JTextField name;
	private JLabel lblClass;
	private JTextField cl;
	private JTextField div;
	private JTextField bname;
	private JLabel lblDivision;
	private JLabel lblBookName;
	private JLabel lblAurther;
	private JTextField ar;
	private JTextField dt;
	private JLabel lblIssueDate;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrow frame = new Borrow();
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
	public Borrow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		
		JLabel lblNewLabel = new JLabel("Student id :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 39, 97, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root" , "");
					Statement s = c.createStatement();
					String s1 = "INSERT INTO borrow VALUES ('"+id.getText()+"' ,'"+name.getText()+"', '"+cl.getText()+"', '"+div.getText()+"','"+bname.getText()+"','"+ar.getText()+"','"+dt.getText()+"')";
					s.executeUpdate(s1);
					JOptionPane.showMessageDialog(null, "Data has been successfully added");
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnNewButton.setBounds(208, 369, 114, 38);
		contentPane.add(btnNewButton);
		
		id = new JTextField();
		id.setBounds(236, 36, 168, 30);
		contentPane.add(id);
		id.setColumns(10);
		
		lblStudentName = new JLabel("Student name :");
		lblStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentName.setBounds(128, 88, 97, 25);
		contentPane.add(lblStudentName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(236, 85, 168, 30);
		contentPane.add(name);
		
		lblClass = new JLabel("Class :");
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setBounds(141, 135, 97, 25);
		contentPane.add(lblClass);
		
		cl = new JTextField();
		cl.setColumns(10);
		cl.setBounds(236, 132, 168, 30);
		contentPane.add(cl);
		
		div = new JTextField();
		div.setColumns(10);
		div.setBounds(236, 175, 168, 30);
		contentPane.add(div);
		
		bname = new JTextField();
		bname.setColumns(10);
		bname.setBounds(236, 218, 168, 30);
		contentPane.add(bname);
		
		lblDivision = new JLabel("Division :");
		lblDivision.setHorizontalAlignment(SwingConstants.CENTER);
		lblDivision.setBounds(141, 182, 97, 25);
		contentPane.add(lblDivision);
		
		lblBookName = new JLabel("Book name :");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setBounds(141, 225, 97, 25);
		contentPane.add(lblBookName);
		
		lblAurther = new JLabel("Aurther :");
		lblAurther.setHorizontalAlignment(SwingConstants.CENTER);
		lblAurther.setBounds(141, 263, 97, 25);
		contentPane.add(lblAurther);
		
		ar = new JTextField();
		ar.setColumns(10);
		ar.setBounds(236, 261, 168, 30);
		contentPane.add(ar);
		
		dt = new JTextField(""+sdf.format(date));
		dt.setColumns(10);
		dt.setBounds(236, 304, 168, 30);
		contentPane.add(dt);
		
		lblIssueDate = new JLabel("Issue date:");
		lblIssueDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssueDate.setBounds(141, 311, 97, 25);
		contentPane.add(lblIssueDate);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("back1.png"));
		btnBack.setBounds(465, 369, 114, 38);
		contentPane.add(btnBack);
		 
	}

}
