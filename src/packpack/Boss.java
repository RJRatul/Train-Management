package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Boss extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boss frame = new Boss();
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
	public Boss() {
		con =link.dataConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 206, 209));
		btnAdd.setBackground(new Color(47, 79, 79));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Addition addition=new Addition();
				addition.setVisible(true);
			}
		});
		btnAdd.setBounds(403, 48, 121, 48);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setForeground(new Color(218, 165, 32));
		btnRemove.setBackground(new Color(139, 0, 0));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Delete delete=new Delete();
				delete.setVisible(true);
				
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemove.setBounds(403, 148, 121, 48);
		contentPane.add(btnRemove);
		
		JButton btnView = new JButton("View");
		btnView.setForeground(Color.BLACK);
		btnView.setBackground(new Color(105, 105, 105));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from DataTable";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rst = pst.executeQuery();
					setVisible(true);
					View view = new View();
					view.table.setModel(DbUtils.resultSetToTableModel(rst));
					view.setVisible(true);
					setVisible(false);
					dispose();
					
					pst.close();
					rst.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}


			
		});
		btnView.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnView.setBounds(403, 259, 121, 48);
		contentPane.add(btnView);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Java Project\\Picture\\03_a.jpg"));
		lblNewLabel.setBounds(0, 0, 570, 349);
		contentPane.add(lblNewLabel);
	}

}
