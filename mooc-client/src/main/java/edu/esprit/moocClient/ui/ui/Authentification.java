package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.mooc.domain.Entity.*;


import edu.esprit.mooc.client.BuisnessDeligator.ManageUserDelegate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField name;
    static ManageUserDelegate manager = new ManageUserDelegate();
    private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setTitle("identification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 429, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("identification");
		lblNewLabel.setBounds(157, 11, 86, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(21, 71, 76, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(21, 152, 76, 14);
		panel.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(138, 68, 86, 20);
		panel.add(name);
		name.setColumns(10);
		
		JButton btnExit = new JButton("exit\r\n");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Authentification.this.dispose();
			}
		});
		btnExit.setBounds(301, 145, 95, 28);
		panel.add(btnExit);
		
		JButton btnConnect = new JButton("connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 if (  name.getText().equals("admin") && passwordField.getText().equals("admin")) 
			 {   new AdminMenu().setVisible(true);
			     Authentification.this.dispose();
			     
			 }
			 else if (name.getText().equals("comitee1")&& passwordField.getText().equals("comitee1"))
			 {
				 new Comitemenu("comitee1").setVisible(true);
				 Authentification.this.dispose();
			 }
			 else if (name.getText().equals("comitee2")&& passwordField.getText().equals("comitee2"))
			 {
				 new Comitemenu("comitee2").setVisible(true);
				 Authentification.this.dispose();
			 }
			 else if (name.getText().equals("comitee3")&& passwordField.getText().equals("comitee3"))
			 {
				 new Comitemenu("comitee3").setVisible(true);
				 Authentification.this.dispose();
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "please enter a valid username and password ", "Error",
							JOptionPane.ERROR_MESSAGE);
			 }
			 
				
			
			}});
		btnConnect.setBounds(301, 67, 95, 28);
		panel.add(btnConnect);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 149, 86, 20);
		panel.add(passwordField);
	}
}
