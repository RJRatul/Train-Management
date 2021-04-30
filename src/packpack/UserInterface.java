package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class UserInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuyTicket = new JButton("Buy Ticket");
		btnBuyTicket.setBackground(new Color(0, 139, 139));
		btnBuyTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				TSearch tSearch=new TSearch();
				tSearch.setVisible(true);
			}
		});
		btnBuyTicket.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBuyTicket.setBounds(82, 40, 205, 46);
		contentPane.add(btnBuyTicket);
		
		JButton btnCancelTicket = new JButton("Cancel Ticket");
		btnCancelTicket.setBackground(new Color(100, 149, 237));
		btnCancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDelete userDelete =new UserDelete();
				userDelete.setVisible(true);
			}
		});
		btnCancelTicket.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCancelTicket.setBounds(82, 133, 205, 41);
		contentPane.add(btnCancelTicket);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(205, 92, 92));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				User user=new User();
				user.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(131, 221, 105, 46);
		contentPane.add(btnBack);
	}

}
