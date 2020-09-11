import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class loginform extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginform frame = new loginform();
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
	public loginform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//center form
		this.setLocationRelativeTo(null);
		
		setUndecorated(true);
		
		JLabel crossLabel = new JLabel("X");
		crossLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		crossLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crossLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		crossLabel.setBounds(422, 11, 30, 28);
		contentPane.add(crossLabel);
		
		
		
		JLabel loginFormPanel = new JLabel("Login Form");
		loginFormPanel.setBackground(Color.WHITE);
		loginFormPanel.setForeground(Color.DARK_GRAY);
		loginFormPanel.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginFormPanel.setBounds(10, 11, 109, 28);
		contentPane.add(loginFormPanel);
		
		JLabel minimizeLabel = new JLabel("-");
		minimizeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			
			}
		});
		minimizeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		minimizeLabel.setBounds(392, 11, 30, 28);
		contentPane.add(minimizeLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 450, 51);
		contentPane.add(panel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameLabel.setBounds(50, 95, 87, 28);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(50, 134, 87, 28);
		contentPane.add(passwordLabel);
		
		username = new JTextField();
		username.setForeground(Color.DARK_GRAY);
		username.setBackground(new Color(192, 192, 192));
		username.setBounds(141, 101, 186, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setForeground(Color.DARK_GRAY);
		password.setBackground(new Color(192, 192, 192));
		password.setBounds(141, 140, 186, 20);
		contentPane.add(password);
		
		JCheckBox checkBoxShowPass = new JCheckBox("show pass");
		checkBoxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxShowPass.isSelected()) {
					password.setEchoChar((char)0);
				}
				else
				{
					password.setEchoChar('*');
				}
			}
		});
		checkBoxShowPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBoxShowPass.setForeground(Color.DARK_GRAY);
		checkBoxShowPass.setBackground(new Color(0, 206, 209));
		checkBoxShowPass.setBounds(333, 139, 97, 23);
		contentPane.add(checkBoxShowPass);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con = myConnection.getConnection();
				PreparedStatement ps;
				ResultSet rs;
				
			
					ps=con.prepareStatement("select username,pass,id from user WHERE username=? AND pass=?");
				    ps.setString(1,username.getText());
				    ps.setString(2, String.valueOf(password.getPassword()));
				    rs=ps.executeQuery();
				    
				    if(rs.next())
				    {
				    	//get the current user id
				    	MyContactForm.currentUserId=rs.getInt("id");
						
				    	System.out.println(rs.getInt("id")+"form login");
				    	MyContactForm mcf=new MyContactForm();
						
						
						mcf.setVisible(true);
						mcf.setLocationRelativeTo(null);
						
						
						dispose();
						
						
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "Login Failed");
				    	
				    }
				    
				
				} catch (SQLException e1) {
					
					Logger.getLogger(Signupform.class.getName()).log(Level.SEVERE, null, e1);
				}
				
				
				//condition to link to other form
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginButton.setForeground(Color.DARK_GRAY);
		loginButton.setBackground(Color.BLUE);
		loginButton.setBounds(238, 182, 89, 23);
		contentPane.add(loginButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		cancelButton.setForeground(Color.DARK_GRAY);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(141, 183, 87, 22);
		contentPane.add(cancelButton);
		
		JLabel newUserCreateLabel = new JLabel("New User? Click Here to Create an Account");
		newUserCreateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signupform supf=new Signupform();
				try {
				
				supf.setVisible(true);
				
				dispose();
				}
				catch (Exception ex)
		        {
		            System.out.println("error");
		        }
			}
		});
		newUserCreateLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newUserCreateLabel.setForeground(Color.DARK_GRAY);
		newUserCreateLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		newUserCreateLabel.setBounds(110, 229, 259, 14);
		contentPane.add(newUserCreateLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 50, 450, 250);
		contentPane.add(panel_1);
	}
}
