package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 353);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogin = new JButton("Sign In");
		btnLogin.setBackground(new Color(204, 102, 102));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btnLogin.setBounds(10, 158, 125, 53);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String un=textField.getText();
				String pw=String.valueOf(passwordField.getPassword());
				
				if(un.equals("rubaet") && pw.equals("5456"))
				{
					setVisible(false);
					dispose();
					Boss boss=new Boss();
					boss.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Access");
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setBackground(new Color(51, 204, 204));
		btnCancel.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Access access=new Access();
				access.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(10, 234, 125, 53);
		contentPane.add(btnCancel);
		
		JLabel lblUserName = new JLabel("UserName  :");
		lblUserName.setForeground(new Color(135, 206, 235));
		lblUserName.setBackground(new Color(51, 153, 51));
		lblUserName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblUserName.setBounds(316, 29, 142, 45);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setForeground(new Color(64, 224, 208));
		lblPassword.setBackground(new Color(204, 0, 0));
		lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblPassword.setBounds(319, 77, 125, 33);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(437, 43, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(437, 85, 116, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Java Project\\Picture\\Giclee-Canvas-Prints-Stretched-Framed-Fine-Art-Artwork-For-Wall-Decor-Shanghai-Freight-font-b-Train.jpg"));
		lblNewLabel.setBounds(0, 0, 575, 314);
		contentPane.add(lblNewLabel);
	}
}
