package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
//import org.eclipse.wb.swing.*;

import edu.esprit.mooc.client.BuisnessDeligator.ManageCourseDelegate;

import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Statistics extends JFrame {

	private JPanel contentPane;
    static ManageCourseDelegate manager = new ManageCourseDelegate();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
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
	public Statistics() {
		setTitle("statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new Textedefilant(" ......welcome to statistics dashboard......");
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("generate chart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GenerateChart().setVisible(true);
				Statistics.this.dispose();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("generate image");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ImageGeneration().setVisible(true);
				Statistics.this.dispose();
			}
		});
		panel_1.add(btnNewButton_1);
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_2 = new JButton("generate advices");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistics.this.dispose();
				new ApprovalFirstMenu().setVisible(true);
			}
		});
		panel_2.add(btnNewButton_3);
		int d = manager.countacceptedcourses();
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\wrabb\\Desktop\\image\\t\u00E9l\u00E9chargement.jpg"));
		lblNewLabel.setBounds(0, 0, 202, 201);
		panel_4.add(lblNewLabel);
	}

}
