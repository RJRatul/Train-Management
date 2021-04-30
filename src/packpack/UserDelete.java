package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class UserDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDelete frame = new UserDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con =null;
	

	/**
	 * Create the frame.
	 */
	public UserDelete() {
		con=link.dataConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNoOfTicket = new JLabel("No of Booking");
		lblNoOfTicket.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoOfTicket.setBounds(38, 43, 145, 25);
		contentPane.add(lblNoOfTicket);
		
		JLabel lblTrainNo = new JLabel("Train No");
		lblTrainNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrainNo.setBounds(38, 91, 145, 14);
		contentPane.add(lblTrainNo);
		
		textField = new JTextField();
		textField.setBounds(211, 45, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 88, 119, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.setForeground(Color.BLACK);
		btnDone.setBackground(new Color(218, 165, 32));
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int amount=Integer.parseInt(textField.getText());
					String check = "select Capasity from DataTable where TrainNo=? ";
					PreparedStatement pst=con.prepareStatement(check);
					pst.setString(1, textField_1.getText());
				    ResultSet rs = pst.executeQuery();
				    int count= rs.getInt("Capasity");
				    int returnSeat = amount+count;
				    
				    String check1 = "Update DataTable set Capasity='"+returnSeat+"' where TrainNo='"+textField_1.getText()+"'";
					PreparedStatement pst1=con.prepareStatement(check1);
					
					pst1.execute();
					JOptionPane.showMessageDialog(null, "Ticket Canceled");
					dispose();
					
					rs.close();
					pst.close();
					pst1.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Fill up all information" );
				}

			}
		});
		btnDone.setBounds(94, 178, 89, 34);
		contentPane.add(btnDone);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			UserInterface userInterface=new UserInterface();
			userInterface.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(240, 178, 89, 34);
		contentPane.add(btnBack);
	}
}
