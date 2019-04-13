package db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;


public class Mainpage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jt1;
	private JTextField jt2;
	public static int admin=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage();
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
	public Mainpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		pack();
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(293, 276, 114, 46);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(293, 388, 114, 46);
		contentPane.add(lblPassword);
		
		jt1 = new JTextField();
		jt1.setBounds(818, 276, 174, 37);
		contentPane.add(jt1);
		jt1.setColumns(10);
		
		jt2 = new JTextField();
		jt2.setBounds(818, 388, 174, 37);
		contentPane.add(jt2);
		jt2.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = jt1.getText();
				String b = jt2.getText();
				String c="SYSTEM";
				String d="c028";
				String e="Student";
				String f="Stud";
				if(a.equals(c) && b.equals(d))
				{
					JOptionPane.showMessageDialog(null,"ADMINISTRATOR LOGIN SUCCESSFUL!");
					Studdetails s1= new Studdetails();
					s1.setVisible(true);
					admin=1;
				}
				else if(a.equals(e) && b.equals(f))
				{
					JOptionPane.showMessageDialog(null,"STUDENT LOGIN SUCCESSFUL!");
					Studdetails s1= new Studdetails();
					s1.setVisible(true);
					admin=0;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"ACCESS DENIED!");
					jt1.setText("");
					jt2.setText("");
				}
			}
		});
		btnLogin.setBounds(568, 616, 132, 37);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1034, 629, 89, 23);
		contentPane.add(btnExit);
	}
}
