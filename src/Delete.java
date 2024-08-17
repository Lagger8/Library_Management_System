import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
public class Delete extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	
	private JTextField txb;
	private JButton btnBack;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
					String sql = "select * from books";
				ResultSet	r = s.executeQuery(sql);
					
					while(r.next()) {
						String i = r.getString("id");
						String n = r.getString("name");
						String a = r.getString("aurther");
						String t = r.getString("title");
						String d = r.getString("description");
					String tbData[] = {i,n,a,t,d};
					
					model.addRow(tbData);
					
					
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		btnNewButton.setBounds(23, 414, 112, 37);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 24, 498, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Aurther", "Title", "Description"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		}) ;
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
					Statement s = c.createStatement();
					String sql = "DELETE FROM `books` WHERE `id`= '"+txb.getText()+"'";
					s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Data is successfully removed");
					
					}
					
				 catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
				
			
	
		btnDelete.setBounds(210, 414, 112, 37);
		contentPane.add(btnDelete);
		
		txb = new JTextField();
		txb.setBounds(185, 351, 176, 37);
		contentPane.add(txb);
		txb.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Id of the book to delete it");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 306, 397, 45);
		contentPane.add(lblNewLabel);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("back1.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(409, 414, 112, 37);
		contentPane.add(btnBack);
		
	}
}
