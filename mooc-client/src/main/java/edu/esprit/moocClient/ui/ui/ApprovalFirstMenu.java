package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.mooc.client.BuisnessDeligator.ManageCourseDelegate;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApprovalFirstMenu extends JFrame {
	static ApprovalFirstMenu frame ;
	private JPanel contentPane;
     static  ManageCourseDelegate manager = new ManageCourseDelegate() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new ApprovalFirstMenu();
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
	public ApprovalFirstMenu() {
		setTitle("course approval management ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("show statistics");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Statistics().setVisible(true);
				ApprovalFirstMenu.this.dispose();
		          }
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Comitemenu().setVisible(true);
				
				ApprovalFirstMenu.this.dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_2 = new JButton("show courses");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CourseDashboard().setVisible(true);
				ApprovalFirstMenu.this.dispose();
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("approve courses ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CourseApprovalMenu().setVisible(true);
				ApprovalFirstMenu.this.dispose();
			}
		});
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\wrabb\\Desktop\\image\\t\u00E9l\u00E9chargementm.jpg"));
		lblNewLabel_2.setBounds(0, 0, 206, 203);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("     ****************   welcome to course approval menu ******************* ");
		panel_3.add(lblNewLabel);
		int d = manager.countpendingcourses() ;
		JPanel panel_4 = new Textedefilant(" ****hello****  you have "+ d + " pending courses  to be approved .....");
		contentPane.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
