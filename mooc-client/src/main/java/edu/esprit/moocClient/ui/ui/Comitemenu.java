package edu.esprit.moocClient.ui.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comitemenu extends JFrame {

	private JPanel contentPane;
    private String nomcomite ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comitemenu frame = new Comitemenu();
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
	
	 public Comitemenu(String nomcomite){
		 this.nomcomite=nomcomite;
		 setTitle("comitte membre menu ");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 434, 270);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ddd");
			lblNewLabel.setBounds(130, 11, 188, 14);
			panel.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("course dashbord approval");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ApprovalFirstMenu().setVisible(true);
					Comitemenu.this.dispose();
				}
			});
			btnNewButton.setBounds(118, 43, 200, 23);
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Membership  dashbord approval ");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MembershipApproval().setVisible(true);
					Comitemenu.this.dispose();
				}
			});
			btnNewButton_1.setBounds(118, 77, 200, 23);
			panel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("surveys management ");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SurveyInterface consult= new SurveyInterface();
					consult.getFrame().setVisible(true ) ;
					Comitemenu.this.dispose();
					
				}
			});
			btnNewButton_2.setBounds(118, 168, 200, 23);
			panel.add(btnNewButton_2);
			
			JButton btnExit = new JButton("exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Authentification().setVisible(true);
					Comitemenu.this.dispose();
								}
			});
			btnExit.setBounds(118, 216, 200, 23);
			panel.add(btnExit);
			
			JButton button_1 = new JButton("Messages management");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			button_1.setBounds(118, 123, 200, 23);
			panel.add(button_1);
		
	 }
	
	
	public Comitemenu() {
		setTitle("comitte membre menu ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ddd");
		lblNewLabel.setBounds(130, 11, 188, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("course dashbord approval");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ApprovalFirstMenu().setVisible(true);
				Comitemenu.this.dispose();
			}
		});
		btnNewButton.setBounds(118, 43, 200, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Membership  dashbord approval ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MembershipApproval().setVisible(true);
				Comitemenu.this.dispose();
			}
		});
		btnNewButton_1.setBounds(118, 77, 200, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("surveys management ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SurveyInterface consult= new SurveyInterface();
				consult.getFrame().setVisible(true ) ;
				Comitemenu.this.dispose();
				
			}
		});
		btnNewButton_2.setBounds(118, 168, 200, 23);
		panel.add(btnNewButton_2);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Authentification().setVisible(true);
				Comitemenu.this.dispose();
							}
		});
		btnExit.setBounds(118, 216, 200, 23);
		panel.add(btnExit);
		
		JButton button_1 = new JButton("Messages management");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List_Message ls = new List_Message();
				ls.setVisible(true);
    Comitemenu.this.setVisible(false);
			}
		});
		button_1.setBounds(118, 123, 200, 23);
		panel.add(button_1);
	}
}
