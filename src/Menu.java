import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\msasi\\OneDrive\\Pictures\\Icons\\iconfinder_book_sans_add_103401.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add a = new Add();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(252, 54, 153, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Book");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\msasi\\OneDrive\\Pictures\\Icons\\iconfinder_book_sans_remove_103404.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Delete d = new Delete();
			d.setVisible(true);
			dispose();
			}
			
		});
		btnNewButton_1.setBounds(252, 130, 153, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Borrowed Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrow b = new Borrow();
				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\msasi\\OneDrive\\Pictures\\Icons\\iconfinder_Book_6785107.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(252, 212, 153, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Return Book");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return r = new Return();
				r.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\msasi\\OneDrive\\Pictures\\Icons\\iconfinder_Book_6785107.png"));
		btnNewButton_3.setBounds(252, 292, 153, 46);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\msasi\\OneDrive\\Pictures\\Icons\\iconfinder_icons_exit2_1564506.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.Return();
				dispose();
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(523, 13, 110, 46);
		contentPane.add(btnNewButton_4);
	}

}
