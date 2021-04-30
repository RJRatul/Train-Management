package packpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TSearch frame = new TSearch();
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
	public TSearch() {
		con=link.dataConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStation = new JLabel("Station");
		lblStation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStation.setBounds(25, 43, 87, 37);
		contentPane.add(lblStation);
		
		textField = new JTextField();
		textField.setBounds(137, 54, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(new Color(25, 25, 112));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String check = "select * from DataTable where Goal=?";
					PreparedStatement pst=con.prepareStatement(check);
					pst.setString(1, textField.getText());
					
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					pst.close();
					rs.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}


			}
		});
		btnSearch.setBounds(333, 53, 89, 23);
		contentPane.add(btnSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(10, 106, 412, 210);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TInfo tInfo=new TInfo();
				tInfo.setVisible(true);
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				int row = table_1.getSelectedRow();
				
				tInfo.textField.setText(model.getValueAt(row, 0).toString());
				tInfo.textField_1.setText(model.getValueAt(row, 1).toString());
				tInfo.textField_2.setText(model.getValueAt(row, 2).toString());
				tInfo.textField_3.setText(model.getValueAt(row, 3).toString());
				tInfo.textField_4.setText(model.getValueAt(row, 4).toString());
				tInfo.textField_5.setText(model.getValueAt(row, 5).toString());
				tInfo.textField_6.setText(model.getValueAt(row, 6).toString());


			}
		});
		scrollPane.setViewportView(table_1);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(new Color(210, 105, 30));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBounds(436, 312, 103, 48);
		contentPane.add(btnBack);
	}

}
