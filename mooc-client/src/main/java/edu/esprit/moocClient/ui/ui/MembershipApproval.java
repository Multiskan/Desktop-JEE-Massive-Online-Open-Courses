package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.mooc.client.BuisnessDeligator.ManageUserDelegate;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MembershipApproval extends JFrame {

	private JPanel contentPane;
    static ManageUserDelegate manager = new ManageUserDelegate();
    PieChart demo ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembershipApproval frame = new MembershipApproval();
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
	public MembershipApproval() {
		setTitle("Membership Approval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Welcome to Membeship Approval   ");
		lblNewLabel.setForeground(new Color(102, 0, 255));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.ITALIC, 14));
		lblNewLabel.setBounds(112, 11, 260, 26);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("trainer approval");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TrainerApproval().setVisible(true);
				MembershipApproval.this.dispose();
				
				
			}
		});
		btnNewButton.setBounds(107, 66, 223, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("commiteemembre approval");
		btnNewButton_1.setBounds(107, 116, 223, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("back ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Comitemenu().setVisible(true);
				MembershipApproval.this.dispose();
			}
		});
		btnNewButton_3.setBounds(107, 227, 223, 23);
		panel.add(btnNewButton_3);
		
		JButton btnStatistics = new JButton("statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a= manager.countallreq();
				int b = manager.countacceptedreq();
				int c = a -b ;
				Requeststat demo = new Requeststat("statistics","requests reviews", c, b);
				demo.pack();
		          demo.setVisible(true);
			}
		});
		btnStatistics.setBounds(112, 177, 223, 23);
		panel.add(btnStatistics);
	}
}
