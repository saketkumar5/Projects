import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class MyContactForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldfname;
	private JTextField jTextFieldLname;
	private JTextField JTextFieldPhone;
	private JTextField JTextFieldAddress;
	public JLabel lblUsername;
	private JTextField jTextFieldEmail;
	private JTable table;
	private JTable table_1;
	public static int currentUserId;

	/**
	 * Launch the application.
	 */


	public void populateJtable()
	{
		
		DefaultTableModel tablemodel=(DefaultTableModel) table_1.getModel();
		
		
		contactQuery cq= new contactQuery();
		
		ArrayList<contact> ctList =cq.contactList(currentUserId);
		
		
		String[] colNames= {"Id","First Name","Last Name", "groupc","Phone","Email","Address"};
		Object[][] rows = new Object[ctList.size()][7];
		
		for(int i=0;i< ctList.size(); i++)
		{
			rows[i][0]=ctList.get(i).getCid();
			rows[i][1]=ctList.get(i).getFname();
			rows[i][2]=ctList.get(i).getLname();
			rows[i][3]=ctList.get(i).getGroupc();
			rows[i][4]=ctList.get(i).getPhone();
			rows[i][5]=ctList.get(i).getEmail();
			rows[i][6]=ctList.get(i).getAddress();
			
		
		}
		
		tablemodel.addRow(rows);
		
		MyModel mmd =new MyModel(rows, colNames);
	
		
		table_1.setModel(mmd);
		table_1.setRowHeight(40);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(150);
		table_1.setShowGrid(true);
		table_1.setGridColor(Color.GREEN);
		table_1.setSelectionBackground(Color.cyan);
		
    	System.out.println(currentUserId+"from Contact");

		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyContactForm frame = new MyContactForm();
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
	public MyContactForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JPanel smallpanel = new JPanel();
		smallpanel.setLayout(null);
		smallpanel.setBackground(Color.PINK);
		smallpanel.setBounds(0, 0, 455, 51);
		contentPane.add(smallpanel);
		
		JLabel lblMyContacts = new JLabel("My Contacts");
		lblMyContacts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMyContacts.setForeground(Color.DARK_GRAY);
		lblMyContacts.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMyContacts.setBackground(Color.WHITE);
		lblMyContacts.setBounds(116, 12, 154, 28);
		smallpanel.add(lblMyContacts);
		
		JLabel closeMouseClick = new JLabel("X");
		closeMouseClick.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeMouseClick.setHorizontalAlignment(SwingConstants.CENTER);
		closeMouseClick.setForeground(Color.DARK_GRAY);
		closeMouseClick.setFont(new Font("Tahoma", Font.BOLD, 20));
		closeMouseClick.setBackground(Color.WHITE);
		closeMouseClick.setBounds(410, 12, 30, 28);
		smallpanel.add(closeMouseClick);
		
		JLabel minMouseClick = new JLabel("-");
		minMouseClick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		minMouseClick.setForeground(Color.DARK_GRAY);
		minMouseClick.setFont(new Font("Tahoma", Font.BOLD, 25));
		minMouseClick.setBounds(389, 13, 30, 28);
		smallpanel.add(minMouseClick);
		
		JPanel largepanel = new JPanel();
		largepanel.setLayout(null);
		largepanel.setBackground(Color.ORANGE);
		largepanel.setBounds(0, 51, 455, 468);
		contentPane.add(largepanel);
		
		jTextFieldfname = new JTextField();
		jTextFieldfname.setForeground(Color.DARK_GRAY);
		jTextFieldfname.setColumns(10);
		jTextFieldfname.setBackground(Color.LIGHT_GRAY);
		jTextFieldfname.setBounds(138, 20, 186, 20);
		largepanel.add(jTextFieldfname);
		
		jTextFieldLname = new JTextField();
		jTextFieldLname.setForeground(Color.DARK_GRAY);
		jTextFieldLname.setColumns(10);
		jTextFieldLname.setBackground(Color.LIGHT_GRAY);
		jTextFieldLname.setBounds(138, 65, 186, 20);
		largepanel.add(jTextFieldLname);
		
		JTextFieldPhone = new JTextField();
		JTextFieldPhone.setForeground(Color.DARK_GRAY);
		JTextFieldPhone.setColumns(10);
		JTextFieldPhone.setBackground(Color.LIGHT_GRAY);
		JTextFieldPhone.setBounds(138, 115, 186, 20);
		largepanel.add(JTextFieldPhone);
		
		JLabel firstNamelabel = new JLabel("First Name:");
		firstNamelabel.setHorizontalAlignment(SwingConstants.RIGHT);
		firstNamelabel.setForeground(Color.DARK_GRAY);
		firstNamelabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstNamelabel.setBounds(41, 12, 87, 28);
		largepanel.add(firstNamelabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lastNameLabel.setForeground(Color.DARK_GRAY);
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastNameLabel.setBounds(41, 57, 87, 28);
		largepanel.add(lastNameLabel);
		
		JLabel usernameLabel = new JLabel("Phone:");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameLabel.setBounds(41, 107, 87, 28);
		largepanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Email:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setBounds(41, 157, 87, 28);
		largepanel.add(passwordLabel);
		
		JLabel retypePasswordlabel = new JLabel("Group:");
		retypePasswordlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		retypePasswordlabel.setForeground(Color.DARK_GRAY);
		retypePasswordlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		retypePasswordlabel.setBounds(10, 202, 118, 28);
		largepanel.add(retypePasswordlabel);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(10, 251, 118, 28);
		largepanel.add(lblAddress);
		
		JTextFieldAddress = new JTextField();
		JTextFieldAddress.setForeground(Color.DARK_GRAY);
		JTextFieldAddress.setColumns(10);
		JTextFieldAddress.setBackground(Color.LIGHT_GRAY);
		JTextFieldAddress.setBounds(138, 259, 186, 39);
		largepanel.add(JTextFieldAddress);
		
		JComboBox jcomboBoxGroup = new JComboBox();
		jcomboBoxGroup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jcomboBoxGroup.setModel(new DefaultComboBoxModel(new String[] {"Family", "Friends", "Work"}));
		jcomboBoxGroup.setToolTipText("");
		jcomboBoxGroup.setBackground(Color.LIGHT_GRAY);
		jcomboBoxGroup.setBounds(138, 207, 186, 22);
		largepanel.add(jcomboBoxGroup);
		
		JButton jButtonAddContact = new JButton("Add");
		jButtonAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname= jTextFieldfname.getText();
				String lname= jTextFieldLname.getText();
				String phone=JTextFieldPhone.getText();
				String address=JTextFieldAddress.getText();
				String groupc= jcomboBoxGroup.getSelectedItem().toString();
			
				String email=jTextFieldEmail.getText();
				
				
			contact c= new contact(null, fname, lname, groupc, email,phone, address,currentUserId);
			
			contactQuery cq=new contactQuery();
			cq.insertContact(c);
					
				
			}
		});
		jButtonAddContact.setForeground(Color.DARK_GRAY);
		jButtonAddContact.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jButtonAddContact.setBackground(Color.BLUE);
		jButtonAddContact.setBounds(356, 266, 89, 23);
		largepanel.add(jButtonAddContact);
		
		jTextFieldEmail = new JTextField();
		jTextFieldEmail.setForeground(Color.DARK_GRAY);
		jTextFieldEmail.setColumns(10);
		jTextFieldEmail.setBackground(Color.LIGHT_GRAY);
		jTextFieldEmail.setBounds(138, 162, 186, 20);
		largepanel.add(jTextFieldEmail);
		
		table = new JTable();
		table.setBounds(163, 401, -65, -26);
		largepanel.add(table);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//display selected table_1 row data 
			
				
				//get selected row index
				int rowIndex = table_1.getSelectedRow();
				jTextFieldfname.setText(table_1.getValueAt(rowIndex, 1).toString());
				jTextFieldLname.setText(table_1.getValueAt(rowIndex, 2).toString());

			    jcomboBoxGroup.setSelectedItem(table_1.getValueAt(rowIndex, 3));
				JTextFieldPhone.setText(table_1.getValueAt(rowIndex, 5).toString());
				jTextFieldEmail.setText(table_1.getValueAt(rowIndex, 4).toString());
				JTextFieldAddress.setText(table_1.getValueAt(rowIndex, 6).toString());


			
			
			
			}
		});
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setBounds(10, 319, 435, 127);
		largepanel.add(table_1);
		
		JButton jButtonEditContact = new JButton("Edit");
		jButtonEditContact.setForeground(Color.DARK_GRAY);
		jButtonEditContact.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jButtonEditContact.setBackground(Color.BLUE);
		jButtonEditContact.setBounds(356, 232, 89, 23);
		largepanel.add(jButtonEditContact);
		
		setUndecorated(true);
		
		populateJtable();
		
		
		
	}
}
