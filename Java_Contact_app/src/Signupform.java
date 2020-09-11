import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signupform extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField usenameTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	String filename=null;
	byte[] image=null;
	private JTextField addressField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signupform frame = new Signupform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public  Signupform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 440, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel smallpanel = new JPanel();
		smallpanel.setBackground(Color.PINK);
		smallpanel.setBounds(0, 0, 440, 51);
		contentPane.add(smallpanel);
		smallpanel.setLayout(null);
		
		JLabel createNewAccountLabel = new JLabel("Create New Account");
		createNewAccountLabel.setForeground(Color.DARK_GRAY);
		createNewAccountLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		createNewAccountLabel.setBackground(Color.WHITE);
		createNewAccountLabel.setBounds(10, 12, 260, 28);
		smallpanel.add(createNewAccountLabel);
		
		JLabel crossLabel = new JLabel("X");
		crossLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		crossLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crossLabel.setBackground(Color.WHITE);
		crossLabel.setForeground(Color.DARK_GRAY);
		crossLabel.setHorizontalAlignment(SwingConstants.CENTER);
		crossLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		crossLabel.setBounds(410, 12, 30, 28);
		smallpanel.add(crossLabel);
		
		JLabel minimizeLabel = new JLabel("-");
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		minimizeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizeLabel.setForeground(Color.DARK_GRAY);
		minimizeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		minimizeLabel.setBounds(389, 13, 30, 28);
		smallpanel.add(minimizeLabel);
		
		JPanel largepanel = new JPanel();
		largepanel.setBackground(Color.ORANGE);
		largepanel.setBounds(0, 51, 440, 468);
		contentPane.add(largepanel);
		largepanel.setLayout(null);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setForeground(Color.DARK_GRAY);
		firstNameTextField.setBounds(138, 36, 186, 20);
		firstNameTextField.setColumns(10);
		firstNameTextField.setBackground(Color.LIGHT_GRAY);
		largepanel.add(firstNameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setForeground(Color.DARK_GRAY);
		lastNameTextField.setBounds(138, 81, 186, 20);
		lastNameTextField.setColumns(10);
		lastNameTextField.setBackground(Color.LIGHT_GRAY);
		largepanel.add(lastNameTextField);
		
		usenameTextField = new JTextField();
		usenameTextField.setForeground(Color.DARK_GRAY);
		usenameTextField.setBounds(138, 131, 186, 20);
		usenameTextField.setColumns(10);
		usenameTextField.setBackground(Color.LIGHT_GRAY);
		largepanel.add(usenameTextField);
		
		JLabel firstNamelabel = new JLabel("First Name:");
		firstNamelabel.setHorizontalAlignment(SwingConstants.RIGHT);
		firstNamelabel.setForeground(Color.DARK_GRAY);
		firstNamelabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstNamelabel.setBounds(41, 28, 87, 28);
		largepanel.add(firstNamelabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lastNameLabel.setForeground(Color.DARK_GRAY);
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastNameLabel.setBounds(41, 73, 87, 28);
		largepanel.add(lastNameLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameLabel.setBounds(41, 123, 87, 28);
		largepanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setBounds(41, 173, 87, 28);
		largepanel.add(passwordLabel);
		
		JLabel retypePasswordlabel = new JLabel("Retype Password:");
		retypePasswordlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		retypePasswordlabel.setForeground(Color.DARK_GRAY);
		retypePasswordlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		retypePasswordlabel.setBounds(10, 218, 118, 28);
		largepanel.add(retypePasswordlabel);
		
		JButton cancelButton = new JButton("Cancel");
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		cancelButton.setForeground(Color.DARK_GRAY);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(237, 377, 87, 22);
		largepanel.add(cancelButton);
		
		

		JButton loginButton = new JButton("Create");
		loginButton.addActionListener(new ActionListener() {
			
			public boolean verifData()
			{
				if(firstNameTextField.getText().equals("") && lastNameTextField.getText().equals("")
						|| usenameTextField.getText().equals("")
						|| String.valueOf(passwordField.getPassword()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "one more field are empty");
				return false;
			    }
				else if(!String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword())))
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password");
					return false;
				}
				else if(addressField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Address field empty");
					return false;
				}
				else
				{
					return true;
				}
			}
			
			
			public void actionPerformed(ActionEvent e) {
				
				if(verifData())
				{
					try
					{
						Connection con=myConnection .getConnection();
					
						
						PreparedStatement ps=con.prepareStatement("INSERT INTO user (fname,lname,username,pass,address) VALUES (?,?,?,?,?)");
						
						ps.setString(1, firstNameTextField.getText());
						ps.setString(2, lastNameTextField.getText());
						ps.setString(3, usenameTextField.getText());
						ps.setString(4, String.valueOf(passwordField.getPassword()));
						ps.setString(5, addressField.getText());
						
						
						
						if(ps.executeUpdate() != 0)
						{
							JOptionPane.showMessageDialog(null, "Account Created");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Something wrong ");
						}
					}
					catch(SQLException ex)
					{
						Logger.getLogger(Signupform.class.getName()).log(Level.SEVERE, null, ex);
						
					}
				}
			
				
			}	
		});
		loginButton.setForeground(Color.DARK_GRAY);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginButton.setBackground(Color.BLUE);
		loginButton.setBounds(139, 377, 89, 23);
		largepanel.add(loginButton);
		
		JLabel alreadyHaveAnLabel = new JLabel("Already have an Account? Click Here to Login");
		alreadyHaveAnLabel.addMouseListener(new MouseAdapter() {
			private JLabel username;

			@Override
			public void mouseClicked(MouseEvent e) {
				
				loginform lgf=new loginform();
				try {
				lgf.setVisible(true);
				dispose();
				}
				catch(Exception ex)
				{
					System.out.println("error");
				}
				
			}
			
			public boolean isUsernameExist(String un)
			{
				boolean uExit= false;
				Connection con = myConnection.getConnection();
				PreparedStatement ps;
				ResultSet rs;
				
				try {
					ps=con.prepareStatement("select * from user WHERE username=?");
				    ps.setString(1,username.getText());
				  
				    rs=ps.executeQuery();
				    
				    if(rs.next())
				    {
				    	uExit=true;
				    }
				   
				    
				
				} catch (SQLException e1) {
					
					Logger.getLogger(Signupform.class.getName()).log(Level.SEVERE, null, e1);
				}
			
				
				return uExit;
			}
			
			
			
		});
		
		
		alreadyHaveAnLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alreadyHaveAnLabel.setForeground(Color.DARK_GRAY);
		alreadyHaveAnLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		alreadyHaveAnLabel.setBounds(98, 427, 259, 20);
		largepanel.add(alreadyHaveAnLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.DARK_GRAY);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(138, 178, 186, 20);
		largepanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(Color.DARK_GRAY);
		passwordField_1.setBackground(Color.LIGHT_GRAY);
		passwordField_1.setBounds(138, 223, 186, 20);
		largepanel.add(passwordField_1);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(10, 267, 118, 28);
		largepanel.add(lblAddress);
		
		addressField = new JTextField();
		addressField.setForeground(Color.DARK_GRAY);
		addressField.setColumns(10);
		addressField.setBackground(Color.LIGHT_GRAY);
		addressField.setBounds(138, 275, 186, 64);
		largepanel.add(addressField);
		
		
		setUndecorated(true);
		
	}
}
