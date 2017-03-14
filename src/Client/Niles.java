package Client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.UIManager;

import Server.TransactionObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JPasswordField;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JPasswordField;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/*
0:error!
1:administer sign up checking
2:administer sign up saving
14:administer sign up checking and saving
3:administer already sign up saving
4:administer already sign up checking
5:user check balance
6:transfer from checking to saving
7:transfer from saving to checking
8:withdraw
9:deposit
10:transfer from checking to another's checking
11:transfer from checking to another's saving
12:transfer from saving to another's checking
13:transfer from saving to another's saving

*/

public class Niles extends JFrame {
	public String supass = "123";
	public int flag = 0;
	private int currentCard = 1;
	private JPanel cardPanel;
	private CardLayout cl;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField__2;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_4;
	private JPasswordField passwordField_5;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private JLabel lblSuperkeyword;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JLabel lblRetype;
	private JTextField textField2;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnTransferFromSaving;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnChecking;
	private JRadioButton rdbtnSaving;
	private JButton btnNewButton;
	private JPanel jp1;
	private JLabel lblAdministerMode;
	private JLabel lblUserMode;
	private JButton firstBtn;
	private JButton ThiBtn;
	private JButton SecBtn;
	private JButton FouBtn;
	private JButton FifBtn;
	private JLabel lblNewLabel_2;
	private JLabel jl2;
	private JLabel jl1;
	private JLabel lblUserName_1;
	private JLabel lblPassword_1;
	private JRadioButton rdbtnSaving_1;
	private JRadioButton rdbtnChecking_1;
	private JButton btnDone_1;
	private JLabel jl3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel jl4;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel lblAmount_1;
	private JButton btnDone_2;
	private JLabel lblAccount;
	private JLabel lblAmount;
	private JButton btnDone;

	public Niles() {

		setTitle("Welcome to Niles' bank system!");
		setSize(658, 491);
		cardPanel = new JPanel();
		cardPanel.setBounds(0, 24, 640, 322);

		// getContentPane().add(cardPanel);
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		jp1 = new JPanel();
		jl1 = new JLabel("Administer");
		jl1.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		jl1.setBounds(193, 13, 252, 58);
		textField2 = new JTextField();
		textField2.setBounds(279, 142, 209, 24);
		textField2.setText("");
		jp1.setLayout(null);
		jp1.add(jl1);
		jp1.add(textField2);
		cardPanel.add(jp1, "1");
		lblUserName = new JLabel("user name");
		lblUserName.setBounds(146, 145, 88, 18);
		jp1.add(lblUserName);

		lblPassword = new JLabel("password");
		lblPassword.setBounds(146, 194, 88, 18);
		jp1.add(lblPassword);

		lblRetype = new JLabel("retype ");
		lblRetype.setBounds(146, 242, 88, 18);
		jp1.add(lblRetype);

		rdbtnChecking = new JRadioButton("checking");
		rdbtnChecking.setSelected(true);
		rdbtnChecking.setBounds(208, 279, 113, 34);
		jp1.add(rdbtnChecking);

		rdbtnSaving = new JRadioButton("saving");
		rdbtnSaving.setBounds(348, 283, 97, 27);
		jp1.add(rdbtnSaving);

		btnNewButton = new JButton("done");

		btnNewButton.setBounds(513, 283, 113, 27);
		jp1.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(279, 191, 209, 24);
		jp1.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(279, 236, 209, 24);
		jp1.add(passwordField_1);

		lblSuperkeyword = new JLabel("super keywords");
		lblSuperkeyword.setBounds(146, 97, 121, 18);
		jp1.add(lblSuperkeyword);

		passwordField_4 = new JPasswordField();
		passwordField_4.setBounds(279, 94, 209, 24);
		jp1.add(passwordField_4);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String username = textField2.getText();
				String password = passwordField.getText();
				String password1 = passwordField_1.getText();
				String su_pass = passwordField_4.getText();
				if (!su_pass.equals(supass)) {
					JOptionPane.showMessageDialog(null, "the administer's password is wrong!");
					return;
				}
				if (!password.equals(password1)) {
					JOptionPane.showMessageDialog(null, "please retype your password!");
					return;
				}
				try {
					Socket socketToServer = new Socket("127.0.0.1", 3307);
					TransactionObject myObject = new TransactionObject();
					myObject.setName(username);
					myObject.setMessage(password);

					if (rdbtnChecking.isSelected() && rdbtnSaving.isSelected()) {
						myObject.setType("14");
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome! your id is  " + myObject.getMessage());
						} else {
							JOptionPane.showMessageDialog(null, "error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}

					if (rdbtnChecking.isSelected()) {
						myObject.setType("1");
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome! your id is  " + myObject.getMessage());
						} else {
							JOptionPane.showMessageDialog(null, "error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}
					if (rdbtnSaving.isSelected()) {
						myObject.setType("2");
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome! your id is  " + myObject.getMessage());
						} else {
							JOptionPane.showMessageDialog(null, "error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}

				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});
		JPanel jp2 = new JPanel();
		jl2 = new JLabel("Administer");
		jl2.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		jl2.setBounds(193, 13, 252, 58);
		jp2.setLayout(null);
		jp2.add(jl2);
		cardPanel.add(jp2, "2");

		lblUserName_1 = new JLabel("user name");
		lblUserName_1.setBounds(150, 158, 72, 18);
		jp2.add(lblUserName_1);

		textField__2 = new JTextField();
		textField__2.setBounds(300, 155, 167, 24);
		jp2.add(textField__2);
		textField__2.setColumns(10);

		lblPassword_1 = new JLabel("password");
		lblPassword_1.setBounds(150, 210, 72, 18);
		jp2.add(lblPassword_1);

		rdbtnChecking_1 = new JRadioButton("checking");
		rdbtnChecking_1.setSelected(true);
		buttonGroup_1.add(rdbtnChecking_1);
		rdbtnChecking_1.setBounds(208, 279, 113, 34);
		jp2.add(rdbtnChecking_1);

		rdbtnSaving_1 = new JRadioButton("saving");
		buttonGroup_1.add(rdbtnSaving_1);
		rdbtnSaving_1.setBounds(348, 283, 97, 27);
		jp2.add(rdbtnSaving_1);

		btnDone_1 = new JButton("done");
		btnDone_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String username = textField__2.getText();
				String password = passwordField_2.getText();
				String su_pass = passwordField_5.getText();
				if (!su_pass.equals(supass)) {
					JOptionPane.showMessageDialog(null, "the administer's password is wrong!");
					return;
				}

				try {
					Socket socketToServer = new Socket("127.0.0.1", 3307);
					TransactionObject myObject = new TransactionObject();
					myObject.setName(username);
					myObject.setMessage(password);

					if (rdbtnChecking_1.isSelected()) {
						myObject.setType("3");
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome! your id is  " + myObject.getMessage());
						}else if(myObject.getType().equals("0")){
							
						}else {
							JOptionPane.showMessageDialog(null, "error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}
					if (rdbtnSaving_1.isSelected()) {
						myObject.setType("4");
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome! your id is  " + myObject.getMessage());
						} else {
							JOptionPane.showMessageDialog(null, "error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}
					
					

				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});

		btnDone_1.setBounds(513, 283, 113, 27);
		jp2.add(btnDone_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(300, 207, 166, 24);
		jp2.add(passwordField_2);

		lblNewLabel_2 = new JLabel("super keywords");
		lblNewLabel_2.setBounds(150, 108, 136, 18);
		jp2.add(lblNewLabel_2);

		passwordField_5 = new JPasswordField();
		passwordField_5.setBounds(300, 105, 167, 24);
		jp2.add(passwordField_5);
		JPanel jp3 = new JPanel();
		jl3 = new JLabel("User");
		jl3.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		jl3.setBounds(263, 24, 109, 38);
		jp3.setLayout(null);
		jp3.add(jl3);
		cardPanel.add(jp3, "3");

		lblNewLabel = new JLabel("user name");
		lblNewLabel.setBounds(150, 122, 72, 18);
		jp3.add(lblNewLabel);

		textField_4 = new JTextField();
		textField_4.setBounds(285, 119, 156, 24);
		jp3.add(textField_4);
		textField_4.setColumns(10);

		lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(150, 184, 72, 18);
		jp3.add(lblNewLabel_1);

		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(285, 181, 156, 24);
		jp3.add(passwordField_3);

		JPanel jp4 = new JPanel();
		jl4 = new JLabel("User");
		jl4.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		jl4.setBounds(263, 24, 109, 38);
		jp4.setLayout(null);
		jp4.add(jl4);
		cardPanel.add(jp4, "4");

		rdbtnNewRadioButton = new JRadioButton("check balance");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup_2.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(60, 91, 157, 27);
		jp4.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("transfer from checking to saving");
		
		buttonGroup_2.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(60, 121, 321, 27);
		jp4.add(rdbtnNewRadioButton_1);

		rdbtnTransferFromSaving = new JRadioButton("transfer from saving to checking");
		buttonGroup_2.add(rdbtnTransferFromSaving);
		rdbtnTransferFromSaving.setBounds(60, 153, 309, 27);
		jp4.add(rdbtnTransferFromSaving);

		rdbtnNewRadioButton_2 = new JRadioButton("withdraw");
		buttonGroup_2.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(60, 185, 157, 27);
		jp4.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("deposit");
		buttonGroup_2.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(60, 216, 157, 27);
		jp4.add(rdbtnNewRadioButton_3);

		textField_6 = new JTextField();
		textField_6.setBounds(489, 124, 123, 24);
		jp4.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(489, 156, 123, 24);
		jp4.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(489, 188, 123, 24);
		jp4.add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(489, 219, 123, 24);
		jp4.add(textField_9);
		textField_9.setColumns(10);

		btnDone_2 = new JButton("done");
		btnDone_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				String username = textField_4.getText();
				String password = passwordField_3.getText();
				try {
					Socket socketToServer = new Socket("127.0.0.1", 3307);
					TransactionObject myObject = new TransactionObject();
					myObject.setName(username);
					myObject.setMessage(password);
					if (rdbtnNewRadioButton.isSelected()) {
						myObject.setType("5");
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "" + myObject.getMessage());
						} else  if(myObject.getType().equals("1")){
							JOptionPane.showMessageDialog(null, "Password is wrong!");
						}
						else{
							JOptionPane.showMessageDialog(null, "Error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}
					
					
					if (rdbtnNewRadioButton_1.isSelected()) {
						myObject.setType("6");
						float tmp_num = Float.parseFloat(textField_6.getText()); 
						myObject.setAmount(tmp_num);
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome!" +"\n"+ myObject.getMessage());
						} else  if(myObject.getType().equals("1")){
							JOptionPane.showMessageDialog(null, "Password is wrong!");
						}
						else if (myObject.getType().equals("100")){
							JOptionPane.showMessageDialog(null, "Not enough money!");
						}
						else{
							JOptionPane.showMessageDialog(null, "Error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}
					
					
					
					if (rdbtnTransferFromSaving.isSelected()) {
						myObject.setType("7");
						float tmp_num = Float.parseFloat(textField_7.getText()); 
						myObject.setAmount(tmp_num);
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome!" +"\n"+ myObject.getMessage());
						} else  if(myObject.getType().equals("1")){
							JOptionPane.showMessageDialog(null, "Password is wrong!");
						}
						else if (myObject.getType().equals("100")){
							JOptionPane.showMessageDialog(null, "Not enough money!");
						}
						else{
							JOptionPane.showMessageDialog(null, "Error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}

					
					if (rdbtnNewRadioButton_2.isSelected()) {
						myObject.setType("8");
						float tmp_num = Float.parseFloat(textField_8.getText()); 
						myObject.setAmount(tmp_num);
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome!" +"\n"+ myObject.getMessage());
						} else  if(myObject.getType().equals("1")){
							JOptionPane.showMessageDialog(null, "Password is wrong!");
						}
						else if (myObject.getType().equals("100")){
							JOptionPane.showMessageDialog(null, "Not enough money!");
						}
						else{
							JOptionPane.showMessageDialog(null, "Error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}
					
					
					
					if (rdbtnNewRadioButton_3.isSelected()) {
						myObject.setType("9");
						float tmp_num = Float.parseFloat(textField_9.getText()); 
						myObject.setAmount(tmp_num);
						ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
						ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
						myOutputStream.writeObject(myObject);
						myObject = (TransactionObject) myInputStream.readObject();
						System.out.println(myObject);
						if (myObject.getType().equals("0")) {
							JOptionPane.showMessageDialog(null, "Awesome!" +"\n"+ myObject.getMessage());
						} else  if(myObject.getType().equals("1")){
							JOptionPane.showMessageDialog(null, "Password is wrong!");
						}
						
						else{
							JOptionPane.showMessageDialog(null, "Error!");
						}
						myOutputStream.close();
						myInputStream.close();
						socketToServer.close();
						return;
					}
					
					

				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
				
				
				
				
			
		btnDone_2.setBounds(513, 283, 113, 27);
		jp4.add(btnDone_2);
		
		lblAmount_1 = new JLabel("amount");
		lblAmount_1.setBounds(564, 91, 48, 18);
		jp4.add(lblAmount_1);
		JPanel jp5 = new JPanel();
		cardPanel.add(jp5, "5");
		jp5.setLayout(null);

		JLabel lblUser = new JLabel("user");
		lblUser.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		lblUser.setBounds(263, 24, 109, 38);
		jp5.add(lblUser);

		lblAccount = new JLabel("target user name");
		lblAccount.setBounds(146, 107, 153, 18);
		jp5.add(lblAccount);

		textField = new JTextField();
		textField.setBounds(313, 104, 209, 24);
		jp5.add(textField);
		textField.setColumns(10);

		btnDone = new JButton("done");
		btnDone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				String username = textField_4.getText();
				String password = passwordField_3.getText();
				String targetname=textField.getText();
				
				try {
					Socket socketToServer = new Socket("127.0.0.1", 3307);
					TransactionObject myObject = new TransactionObject();
					myObject.setName(username);
					myObject.setMessage(password);
					myObject.setNum(targetname);
				myObject.setType("10");
				float tmp_num = Float.parseFloat(textField_1.getText()); 
				myObject.setAmount(tmp_num);
				ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());
				ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
				myOutputStream.writeObject(myObject);
				myObject = (TransactionObject) myInputStream.readObject();
				System.out.println(myObject);
				if (myObject.getType().equals("0")) {
					JOptionPane.showMessageDialog(null, "Awesome!" +"\n"+ myObject.getMessage());
				} else  if(myObject.getType().equals("1")){
					JOptionPane.showMessageDialog(null, "Password is wrong!");
				}else if(myObject.getType().equals("2")){
					JOptionPane.showMessageDialog(null, "Cannot find target user!");
				}else if(myObject.getType().equals("3")){
					JOptionPane.showMessageDialog(null, "Not enough money!");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Error!");
				}
				myOutputStream.close();
				myInputStream.close();
				socketToServer.close();
				return;
				}
				catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		btnDone.setBounds(513, 283, 113, 27);
		jp5.add(btnDone);

		lblAmount = new JLabel("amount");
		lblAmount.setBounds(146, 159, 72, 18);
		jp5.add(lblAmount);

		textField_1 = new JTextField();
		textField_1.setBounds(313, 156, 209, 24);
		jp5.add(textField_1);
		textField_1.setColumns(10);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 361, 640, 83);
		firstBtn = new JButton("Administer");
		firstBtn.setBounds(187, 5, 113, 27);
		SecBtn = new JButton("Administer for already registered");
		SecBtn.setBounds(329, 5, 297, 27);
		ThiBtn = new JButton("User");
		ThiBtn.setBounds(187, 43, 113, 27);
		FouBtn = new JButton("Personal Options");
		FouBtn.setBounds(329, 43, 161, 27);
		FifBtn = new JButton("send money");
		FifBtn.setBounds(513, 43, 113, 27);
		buttonPanel.setLayout(null);

		buttonPanel.add(firstBtn);
		buttonPanel.add(SecBtn);
		buttonPanel.add(ThiBtn);
		buttonPanel.add(FouBtn);
		buttonPanel.add(FifBtn);

		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.first(cardPanel);
				currentCard = 1;
			}
		});

		FouBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				currentCard = 4;
				cl.show(cardPanel, "" + (currentCard));

			}
		});

		SecBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentCard = 2;
				cl.show(cardPanel, "" + (currentCard));
			}
		});

		ThiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				currentCard = 3;
				cl.show(cardPanel, "" + (currentCard));
			}
		});

		getContentPane().setLayout(null);
		getContentPane().add(cardPanel);
		getContentPane().add(buttonPanel);

		lblUserMode = new JLabel("User mode");
		lblUserMode.setBounds(14, 49, 72, 18);
		buttonPanel.add(lblUserMode);

		lblAdministerMode = new JLabel("Administer mode");
		lblAdministerMode.setBounds(14, 9, 125, 18);
		buttonPanel.add(lblAdministerMode);

		FifBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentCard = 5;
				cl.show(cardPanel, "" + (currentCard));
			}
		});

	}
}