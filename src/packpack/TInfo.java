package packpack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;


public class TInfo extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TInfo frame = new TInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con =null;
	private JLabel lblNoOfBooking;
	private JTextField textField_7;

	/**
	 * Create the frame.
	 */
	public TInfo() {
		con=link.dataConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(24, 27, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblTrainNo = new JLabel("Train No");
		lblTrainNo.setBounds(24, 252, 60, 14);
		contentPane.add(lblTrainNo);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(24, 67, 46, 14);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(24, 114, 46, 14);
		contentPane.add(lblTo);
		
		JLabel lblLeaveTime = new JLabel("Leave Time");
		lblLeaveTime.setBounds(24, 162, 94, 14);
		contentPane.add(lblLeaveTime);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(24, 206, 46, 14);
		contentPane.add(lblCost);
		
		JLabel lblCapasity = new JLabel("Capacity");
		lblCapasity.setBounds(24, 304, 66, 14);
		contentPane.add(lblCapasity);
		
		textField = new JTextField();
		textField.setBounds(138, 24, 128, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 64, 128, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 111, 128, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 159, 128, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(138, 203, 128, 20); 
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(138, 249, 128, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(138, 301, 128, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnConfirmTicket = new JButton("Confirm Ticket");
		btnConfirmTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double fare = Double.parseDouble(textField_4.getText());
				
				int i = Integer.parseInt(textField_7.getText());
				int a = Integer.parseInt(textField_6.getText());
				if(a>0 && a>=i){
					if(i>0 && i<=4 )
					{
						try
						{
							
							int d = Integer.parseInt(textField_6.getText());
							
							int seat = d-i;
							
							String check = "Update DataTable set Capasity='"+seat+"' where TrainNo='"+textField_5.getText()+"'";
							PreparedStatement pst=con.prepareStatement(check);
							
							pst.execute();
							JOptionPane.showMessageDialog(null, "Ticket Confirmed");
							dispose();
							User user=new User();
							user.setVisible(true);
							pst.close();
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You can Confirm Maximum 4 seat");	
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Seat Not Available Now");
				}
				
				File file = new File("D:\\Ticket.txt");
				try
				{
					PrintWriter Output = new PrintWriter(file);
					Output.println("Start : "+textField_1.getText());
					Output.println("End : "+textField_2.getText());
					Output.println("Train Name : "+textField.getText());
					Output.println("Journey Time : "+textField_3.getText());
					Output.println("Train No : "+textField_5.getText());
					Output.println("Expense : "+fare*i+" Tk" );
					Output.close();
			    }
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnConfirmTicket.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConfirmTicket.setBounds(325, 332, 183, 41);
		contentPane.add(btnConfirmTicket);
		
		lblNoOfBooking = new JLabel("No of Booking");
		lblNoOfBooking.setBounds(26, 348, 92, 14);
		contentPane.add(lblNoOfBooking);
		
		textField_7 = new JTextField();
		textField_7.setBounds(141, 345, 125, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
	}

}
