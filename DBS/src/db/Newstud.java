package db;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Newstud extends JFrame {

	private JPanel contentPane;
	private JTextField reg;
	private JTextField fname;
	private JTextField lname;
	private JTextField gender;
	private JTextField contact;
	private JTextField block;
	private JTextField roomno;
	private JTextField roomid;
	private JTextField cgpa;
	private JTextField fees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newstud frame = new Newstud();
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
	public Newstud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		JLabel lblRegistrationNumber = new JLabel("REGISTRATION NUMBER");
		lblRegistrationNumber.setBounds(60, 99, 134, 23);
		contentPane.add(lblRegistrationNumber);
		
		reg = new JTextField();
		reg.setBounds(276, 100, 86, 20);
		contentPane.add(reg);
		reg.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strreg = reg.getText();
				  try {
						
				        // step1 load the driver class			
				        Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@VEDANT:1521:XE", "SYSTEM", "c028");			
				        // step3 create the statement object			
				        Statement stmt = con.createStatement();			
				        // step4 execute query					        
				        ResultSet rs = stmt.executeQuery("select * from stud where regno ="+strreg);
				       // System.out.println("connected");
				        rs.next();
				        fname.setText(rs.getString(2));
				        lname.setText(rs.getString(3));
				        gender.setText(rs.getString(4));
				        contact.setText(rs.getString(5));
				        block.setText(rs.getString(6));
				        roomno.setText(rs.getString(7));
				        roomid.setText(rs.getString(8));
				        cgpa.setText(rs.getString(9));
				        fees.setText(rs.getString(10));
				        fname.setEditable(false);
				        lname.setEditable(false);
				        gender.setEditable(false);
				        contact.setEditable(false);
				        block.setEditable(false);
				        roomno.setEditable(false);
				        roomid.setEditable(false);
				        cgpa.setEditable(false);
				        fees.setEditable(false);
				        
				        // step5 close the connection object			
				        con.close();
				    } catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnSearch.setBounds(273, 142, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setBounds(540, 121, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnBook = new JButton("BOOK");
		btnBook.setBounds(81, 142, 89, 23);
		contentPane.add(btnBook);
		
		JLabel lblFirstName = new JLabel("First name :");
		lblFirstName.setBounds(60, 219, 69, 23);
		contentPane.add(lblFirstName);
		
		fname = new JTextField();
		fname.setBounds(180, 220, 86, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name :");
		lblLastName.setBounds(60, 282, 69, 23);
		contentPane.add(lblLastName);
		
		lname = new JTextField();
		lname.setBounds(180, 283, 86, 20);
		contentPane.add(lname);
		lname.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(60, 345, 69, 20);
		contentPane.add(lblGender);
		
		gender = new JTextField();
		gender.setBounds(180, 345, 86, 20);
		contentPane.add(gender);
		gender.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setBounds(60, 408, 69, 20);
		contentPane.add(lblContact);
		
		contact = new JTextField();
		contact.setBounds(180, 408, 86, 20);
		contentPane.add(contact);
		contact.setColumns(10);
		
		JLabel lblBlock = new JLabel("Block :");
		lblBlock.setBounds(60, 467, 69, 23);
		contentPane.add(lblBlock);
		
		block = new JTextField();
		block.setBounds(180, 468, 86, 20);
		contentPane.add(block);
		block.setColumns(10);
		
		JLabel lblRoomNumber = new JLabel("Room number :");
		lblRoomNumber.setBounds(452, 219, 86, 18);
		contentPane.add(lblRoomNumber);
		
		roomno = new JTextField();
		roomno.setBounds(606, 220, 86, 20);
		contentPane.add(roomno);
		roomno.setColumns(10);
		
		JLabel lblRoomId = new JLabel("Room id :");
		lblRoomId.setBounds(452, 282, 69, 18);
		contentPane.add(lblRoomId);
		
		roomid = new JTextField();
		roomid.setBounds(606, 283, 86, 20);
		contentPane.add(roomid);
		roomid.setColumns(10);
		
		JLabel lblCgpa = new JLabel("CGPA");
		lblCgpa.setBounds(452, 345, 69, 17);
		contentPane.add(lblCgpa);
		
		cgpa = new JTextField();
		cgpa.setBounds(606, 345, 86, 20);
		contentPane.add(cgpa);
		cgpa.setColumns(10);
		
		JLabel lblFeesDue = new JLabel("Fees due :");
		lblFeesDue.setBounds(452, 408, 69, 17);
		contentPane.add(lblFeesDue);
		
		fees = new JTextField();
		fees.setBounds(606, 408, 86, 20);
		contentPane.add(fees);
		fees.setColumns(10);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 fname.setEditable(true);
			        lname.setEditable(true);
			        gender.setEditable(true);
			        contact.setEditable(true);
			        block.setEditable(true);
			        roomno.setEditable(true);
			        roomid.setEditable(true);
			        cgpa.setEditable(true);
			        fees.setEditable(true);
			        fname.setText("");
			        lname.setText("");
			        gender.setText("");
			        contact.setText("");
			        block.setText("");
			        roomno.setText("");
			        roomid.setText("");
			        cgpa.setText("");
			        fees.setText("");
			}
		});
		btnClear.setBounds(420, 99, 89, 23);
		contentPane.add(btnClear);
		pack();
	}
}
