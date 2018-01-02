package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminMenu = new JLabel("Admin Menu");
		lblAdminMenu.setForeground(new Color(0, 0, 139));
		lblAdminMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAdminMenu.setBounds(164, 11, 149, 29);
		contentPane.add(lblAdminMenu);
		
		JButton btnNewButton = new JButton("Add Comitee Member");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  new AdminaddComitee().setVisible(true);
				     AdminMenu.this.dispose();
				
			}
		});
		btnNewButton.setBounds(26, 83, 163, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Remove Comitee Member");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new DeleteComitee().setVisible(true);
				 AdminMenu.this.dispose();
			}
		});
		btnNewButton_2.setBounds(26, 133, 163, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("EXIT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Authentification().setVisible(true);
				 AdminMenu.this.dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.setForeground(new Color(255, 0, 0));
		btnNewButton_4.setBounds(274, 122, 89, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnAccessLibraries = new JButton("access libraries");
		btnAccessLibraries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new library().setVisible(true);
				AdminMenu.this.dispose();
			}
		});
		btnAccessLibraries.setBounds(26, 192, 163, 23);
		contentPane.add(btnAccessLibraries);
	}

}
