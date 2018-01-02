package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.mooc.client.BuisnessDeligator.ManageUserDelegate;
import edu.esprit.mooc.domain.Entity.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.awt.event.ActionEvent;

public class AdminaddComitee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	ManageUserDelegate manager = new ManageUserDelegate();
	ComiteeMembre co = new ComiteeMembre() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminaddComitee frame = new AdminaddComitee();
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
	public AdminaddComitee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adding a new Comitee Member");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(104, 11, 298, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(39, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(39, 97, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mail");
		lblNewLabel_3.setBounds(39, 125, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(39, 150, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Photo");
		lblNewLabel_5.setBounds(39, 175, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Resume");
		lblNewLabel_6.setBounds(39, 200, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Votes");
		lblNewLabel_7.setBounds(39, 225, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(105, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 94, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 122, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(105, 147, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 172, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(105, 197, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(105, 222, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
			    String ac = textField_3.getText();
					    
				MessageDigest m=MessageDigest.getInstance("MD5");
					    
			   m.update(ac.getBytes(),0,ac.length());
					    
			   co.setMdp("."+new BigInteger(1,m.digest()).toString(16));
						
					    
					    
					    co.setNom_user(textField.getText());
						co.setPrenom_user(textField_1.getText());
						
						co.setEmail(textField_2.getText());
						co.setPhoto(textField_4.getText());
						co.setResume(textField_5.getText());
						co.setNbre_vote(Integer.parseInt(textField_6.getText()));
						
					    manager.adduser(co) ;

						
					} catch ( Exception ex) {
						
					}
				 
				
				}
			
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(282, 97, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminMenu().setVisible(true);
				 AdminaddComitee.this.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(283, 171, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
