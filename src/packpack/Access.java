package packpack;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.sun.javafx.font.Disposer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;

public class Access {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Access window = new Access();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Access() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBackground(new Color(0, 153, 51));
		btnAdmin.setForeground(Color.GREEN);
		btnAdmin.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin admin=new Admin();
				admin.setVisible(true);
				
			}
		});
		btnAdmin.setBounds(33, 298, 152, 58);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnUser = new JButton("User");
		btnUser.setForeground(new Color(0, 204, 204));
		btnUser.setBackground(new Color(0, 102, 204));
		btnUser.setFont(new Font("Microsoft Tai Le", Font.BOLD, 26));
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				User user=new User();
				user.setVisible(true);
			}
		});
		btnUser.setBounds(258, 295, 164, 64);
		frame.getContentPane().add(btnUser);
		
		JButton btnQuery = new JButton("Query");
		btnQuery.setBackground(new Color(153, 51, 102));
		btnQuery.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 23));
		btnQuery.setForeground(new Color(204, 153, 255));
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"For more details,Build this project yourself");
			}
		});
		btnQuery.setBounds(479, 296, 138, 64);
		frame.getContentPane().add(btnQuery);
		
		JLabel lblCastleRailwayStation = new JLabel("Capital Railway Station");
		lblCastleRailwayStation.setBackground(new Color(0, 204, 255));
		lblCastleRailwayStation.setForeground(new Color(0, 102, 204));
		lblCastleRailwayStation.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblCastleRailwayStation.setBounds(300, 24, 349, 46);
		frame.getContentPane().add(lblCastleRailwayStation);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(153, 51, 51));
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setIcon(new ImageIcon("D:\\Java Project\\Picture\\train-wallpaper-10.jpg"));
		lblNewLabel.setBounds(-288, -326, 1970, 1080);
		frame.getContentPane().add(lblNewLabel);
	}

	

	
}
