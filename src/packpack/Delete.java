package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
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
	Connection  con =null;

	/**
	 * Create the frame.
	 */
	public Delete() {
		con=link.dataConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String check = "delete from DataTable where Name='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(check);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Successfully Removed");
					setVisible(false);
					dispose();
					Boss boss=new Boss();
					boss.setVisible(true);
					pst.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}



			
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(137, 173, 135, 40);
		contentPane.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(145, 53, 264, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTrainName = new JLabel("Train Name");
		lblTrainName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTrainName.setBounds(21, 56, 114, 37);
		contentPane.add(lblTrainName);
	}

}
