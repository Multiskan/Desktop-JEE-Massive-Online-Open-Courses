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
import java.awt.event.ActionEvent;

public class DeleteComitee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ManageUserDelegate manager = new ManageUserDelegate() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteComitee frame = new DeleteComitee();
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
	public DeleteComitee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deleting  Member");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(156, 11, 154, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(132, 66, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User user = new User();
					int a = Integer.parseInt(textField.getText());
					
					
				 user =	manager.findusereById(a);
					manager.deleteuser(user) ;
						
					} catch ( Exception ex) {
						
					}
				new AdminMenu().setVisible(true);
				
					DeleteComitee.this.dispose();
				}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(139, 113, 120, 23);
		contentPane.add(btnNewButton);
	}

}
