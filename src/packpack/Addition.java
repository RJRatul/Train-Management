package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Addition extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addition frame = new Addition();
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
	public Addition() {
		con = link.dataConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(245, 28, 107, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(245, 329, 107, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(245, 75, 107, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 131, 107, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(245, 180, 107, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(245, 226, 107, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(245, 281, 107, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(28, 29, 95, 14);
		contentPane.add(lblName);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(28, 78, 95, 14);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTo.setBounds(28, 132, 95, 14);
		contentPane.add(lblTo);
		
		JLabel lblLeavingTime = new JLabel("Leaving Time");
		lblLeavingTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeavingTime.setBounds(28, 181, 95, 14);
		contentPane.add(lblLeavingTime);
		
		JLabel lblSeatCapasity = new JLabel("Seat Capacity");
		lblSeatCapasity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeatCapasity.setBounds(28, 227, 107, 20);
		contentPane.add(lblSeatCapasity);
		
		JLabel lblTrainNo = new JLabel("Train No");
		lblTrainNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrainNo.setBounds(28, 282, 95, 14);
		contentPane.add(lblTrainNo);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCost.setBounds(28, 330, 95, 14);
		contentPane.add(lblCost);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
				    	String check = "insert into DataTable values(?,?,?,?,?,?,?)";
					    PreparedStatement pst=con.prepareStatement(check);
					    pst.setString(1, textField.getText());
					    pst.setString(2, textField_2.getText());
					    pst.setString(3, textField_3.getText());
					    pst.setString(4, textField_4.getText());
					    pst.setString(5, textField_5.getText());
					    pst.setString(6, textField_7.getText());
					    pst.setString(7, textField_1.getText());
					    pst.execute();
					
					    JOptionPane.showMessageDialog(null, "Successfully Added");
					    //setVisible(false);
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
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAdd.setBounds(483, 329, 89, 45);
		contentPane.add(btnAdd);
	}

}
