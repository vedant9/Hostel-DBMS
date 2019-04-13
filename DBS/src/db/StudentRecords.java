package db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class StudentRecords extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jt1;
	private JScrollPane scrollPane;
	private JButton btnExit;
	private JTextField jt2;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRecords frame = new StudentRecords();
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
	public StudentRecords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		pack();
		
		
		JButton btnFetch = new JButton("FETCH");
		btnFetch.setBounds(10, 48, 89, 23);
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				  try {
						
				        // step1 load the driver class			
				        Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@VEDANT:1521:XE", "SYSTEM", "c028");			
				        // step3 create the statement object			
				        Statement stmt = con.createStatement();			
				        // step4 execute query					        
				        ResultSet rs = stmt.executeQuery("select * from stud");
				       // System.out.println("connected");
				        jt1.setModel(DbUtils.resultSetToTableModel(rs));
				      
				        // step5 close the connection object			
				        con.close();
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnFetch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 23, 1227, 214);
		contentPane.add(scrollPane);
		jt1 = new JTable();
		scrollPane.setViewportView(jt1);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 176, 89, 23);
		contentPane.add(btnExit);
		
		JComboBox jc1 = new JComboBox();
		jc1.setModel(new DefaultComboBoxModel(new String[] {"regno", "fname", "lname", "gender", "block", "roomno", "room_id", "contact", "feesdue", "gpa"}));
		jc1.setBounds(134, 365, 83, 20);
		contentPane.add(jc1);
		
		jt2 = new JTextField();
		jt2.setBounds(23, 365, 101, 20);
		contentPane.add(jt2);
		jt2.setColumns(10);
		
		JButton btnOk = new JButton("APPLY");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = jt2.getText();
				String str2 = jc1.getSelectedItem().toString();

				  try {
						
				        // step1 load the driver class			
				        Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@VEDANT:1521:XE", "SYSTEM", "c028");			
				        // step3 create the statement object			
				        Statement stmt = con.createStatement();			
				        // step4 execute query					        
				        ResultSet rs = stmt.executeQuery("select * from stud where "+str2+" "+str1);
				       // System.out.println("connected");
				        jt1.setModel(DbUtils.resultSetToTableModel(rs));
				      
				        // step5 close the connection object			
				        con.close();
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnOk.setBounds(80, 416, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblConstraints = new JLabel("CONSTRAINTS :");
		lblConstraints.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConstraints.setBounds(23, 283, 146, 33);
		contentPane.add(lblConstraints);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(10, 115, 89, 23);
		contentPane.add(btnBack);
	}
}
