package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class User extends JFrame {

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
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;

	/**
	 * Create the frame.
	 */
	public User() {
		con =link.dataConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUserName = new JButton("User Name ");
		btnUserName.setForeground(new Color(102, 205, 170));
		btnUserName.setBackground(Color.BLUE);
		btnUserName.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUserName.setBounds(35, 140, 136, 40);
		contentPane.add(btnUserName);
		
		JButton btnPassword = new JButton("Password");
		btnPassword.setForeground(new Color(233, 150, 122));
		btnPassword.setBackground(new Color(47, 79, 79));
		btnPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPassword.setBounds(35, 213, 131, 40);
		contentPane.add(btnPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setBackground(new Color(210, 105, 30));
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String check = "select * from LoginTable where userName=? and password=? ";
					PreparedStatement pst=con.prepareStatement(check);
					pst.setString(1, textField.getText());
					pst.setString(2, String.valueOf(passwordField.getPassword()));
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count++;
					}
					if(count == 1)
					{
						setVisible(false);
						dispose();
						UserInterface userinterface = new UserInterface();
						userinterface.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "InCorrcet");
					}
					rs.close();
					pst.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}


			}
		});
		btnSignIn.setBounds(25, 304, 131, 44);
		contentPane.add(btnSignIn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Access ac = new Access();
				ac.frame.setVisible(true);
				
				 
				 
				
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(new Color(0, 255, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnBack.setBounds(353, 304, 123, 44);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(253, 143, 136, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(253, 216, 136, 40);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Java Project\\Picture\\Kamlan.jpg"));
		lblNewLabel.setBounds(-23, -51, 770, 493);
		contentPane.add(lblNewLabel);
	}
}
