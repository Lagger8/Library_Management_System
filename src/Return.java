import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Return extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField stid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return frame = new Return();
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
	public Return() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 38, 651, 293);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student id", "Student name", "Class", "Division", "Book name", "aurther", "Issue date"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				while(model.getRowCount() > 0) {
					for(int i = 0; i < model.getRowCount(); i++) {
						model.removeRow(i);
					}
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
					Statement s = c.createStatement();
					String sql = "select * from borrow";
				ResultSet	r = s.executeQuery(sql);
					
					while(r.next()) {
						String i = r.getString("id");
						String n = r.getString("name");
						String c1 = r.getString("class");
						String d = r.getString("division");
						String b = r.getString("book name");
						String a = r.getString("aurther");
						String id = r.getString("issue date");
					String tbData[] = {i,n,c1,d,b,a,id};
					
					model.addRow(tbData);
					
					
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(12, 428, 111, 33);
		contentPane.add(btnNewButton);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
					Statement s = c.createStatement();
					String sql = "DELETE FROM `borrow` WHERE `id`= '"+stid.getText()+"'";
					s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Book has been successfully returned");
					
					}
					
				 catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReturn.setBounds(263, 428, 111, 33);
		contentPane.add(btnReturn);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("back1.png"));
		btnNewButton_2.setBounds(552, 428, 111, 33);
		contentPane.add(btnNewButton_2);
		
		stid = new JTextField();
		stid.setBounds(211, 382, 217, 33);
		contentPane.add(stid);
		stid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Student id to return the book :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 344, 293, 33);
		contentPane.add(lblNewLabel);
	}
}
