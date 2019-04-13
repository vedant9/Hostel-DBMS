package db;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Studdetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studdetails frame = new Studdetails();
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
	public Studdetails() {
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
		pack();
		
		JButton btnStudentDetails = new JButton("Student Details");
		btnStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Mainpage.admin==1)
				 {
					StudentRecords r1 = new StudentRecords();
			        r1.setVisible(true);
				 }		
				else {
					Newstud ns1 = new Newstud();
					ns1.setVisible(true);
				}
			}
		});
		btnStudentDetails.setBounds(33, 72, 117, 23);
		contentPane.add(btnStudentDetails);
		
		JButton btnIncidents = new JButton("Incidents");
		btnIncidents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Incidents i1= new Incidents();
				i1.setVisible(true);
			}
		});
		btnIncidents.setBounds(33, 121, 117, 23);
		contentPane.add(btnIncidents);
		
		JButton btnLists = new JButton("Lists");
		btnLists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lists list1= new Lists();
				list1.setVisible(true);
			}
		});
		btnLists.setBounds(33, 170, 117, 23);
		contentPane.add(btnLists);
		
		JButton btnHostelDatabase = new JButton("Hostel Database");
		btnHostelDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Mainpage.admin==1)
				{
					HostelData h1 = new HostelData();
					h1.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"ACCESS DENIED! You need administrator privileges to view this file.");
				}
			}
		});
		btnHostelDatabase.setBounds(265, 72, 117, 23);
		contentPane.add(btnHostelDatabase);
		
		JButton btnMaintenance = new JButton("Maintenance");
		btnMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Mainpage.admin==1)
				{
					Maintenance m1= new Maintenance();
					m1.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"ACCESS DENIED! You need administrator privileges to view this file.");
				}
			}
		});
		btnMaintenance.setBounds(265, 121, 117, 23);
		contentPane.add(btnMaintenance);
		
		JButton btnRoomtype = new JButton("Roomtype");
		btnRoomtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Roomtype room1 = new Roomtype();
				room1.setVisible(true);
			}
		});
		btnRoomtype.setBounds(265, 170, 117, 23);
		contentPane.add(btnRoomtype);
		
		JButton btnCaretakerInfo = new JButton("Caretaker Info");
		btnCaretakerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Caretaker care1 = new Caretaker();
				care1.setVisible(true);
			}
		});
		btnCaretakerInfo.setBounds(33, 213, 117, 23);
		contentPane.add(btnCaretakerInfo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(265, 213, 117, 23);
		contentPane.add(btnExit);
		
		JButton btnBookARoom = new JButton("Book a room");
		btnBookARoom.setBounds(33, 258, 117, 23);
		contentPane.add(btnBookARoom);
	}

}
