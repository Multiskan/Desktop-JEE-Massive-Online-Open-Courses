package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.mooc.client.BuisnessDeligator.ManageUserDelegate;
import edu.esprit.mooc.domain.Entity.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLearner extends JFrame {

	private JPanel contentPane;
      User user = new User ();
      Trainer trainer = new Trainer() ;
      ManageUserDelegate manager = new ManageUserDelegate();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLearner frame = new ViewLearner();
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
	
	public ViewLearner(User user ){
		this.user = user ;
		setTitle("ViewLearner");
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
		
		JLabel lblWelcomeToThe = new JLabel("welcome to the learner interface ");
		lblWelcomeToThe.setBounds(70, 11, 214, 14);
		panel.add(lblWelcomeToThe);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setBounds(10, 78, 70, 14);
		panel.add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setBounds(10, 129, 46, 14);
		panel.add(lblPrenom);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(10, 185, 46, 14);
		panel.add(lblEmail);
		
		JLabel nom = new JLabel("");
		nom.setBounds(70, 66, 108, 26);
		nom.setText(user.getNom_user());
		panel.add(nom);
		
		JLabel prenom = new JLabel("");
		prenom.setBounds(70, 117, 108, 26);
		prenom.setText(user.getPrenom_user());
		
		panel.add(prenom);
		
		JLabel email = new JLabel("");
		email.setBounds(70, 173, 108, 26);
		email.setText(user.getEmail());
		panel.add(email);
		JButton btnViewResume = new JButton("view resume");
		btnViewResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecteurPdf lecteur = null;
				try {
					lecteur = new LecteurPdf(user.getResume());
				  } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        //créer le JFrame
		        JFrame f = new JFrame("learner resume viewer");
		        f.setSize(1024,768);
		        f.setLocationRelativeTo(null);
		        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        f.setVisible(true);
		        f.getContentPane().add(lecteur);
			}
		});
		btnViewResume.setBounds(246, 74, 155, 23);
		panel.add(btnViewResume);
		
		JButton btnNewButton = new JButton("approve as a trainer ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
				
				JOptionPane.showMessageDialog(null, " user role changed to trainer ", "info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(246, 147, 155, 23);
		panel.add(btnNewButton);
		
		
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainerApproval().setVisible(true);
				ViewLearner.this.dispose();
			}
		});
		btnBack.setBounds(246, 208, 155, 23);
		panel.add(btnBack);
	}
	
	
	
	 
	public ViewLearner() {
		setTitle("ViewLearner");
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
		
		JLabel lblWelcomeToThe = new JLabel("welcome to the learner interface ");
		lblWelcomeToThe.setBounds(70, 11, 214, 14);
		panel.add(lblWelcomeToThe);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setBounds(10, 78, 70, 14);
		panel.add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setBounds(10, 129, 46, 14);
		panel.add(lblPrenom);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(10, 185, 46, 14);
		panel.add(lblEmail);
		
		JLabel nom = new JLabel("");
		nom.setBounds(70, 66, 108, 26);
		panel.add(nom);
		
		JLabel prenom = new JLabel("");
		prenom.setBounds(70, 117, 108, 26);
		panel.add(prenom);
		
		JLabel email = new JLabel("");
		email.setBounds(70, 173, 108, 26);
		panel.add(email);
		
		JButton btnViewResume = new JButton("view resume");
		btnViewResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecteurPdf lecteur = null;
				try {
					lecteur = new LecteurPdf(user.getResume());
				  } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        //créer le JFrame
		        JFrame f = new JFrame("learner resume viewer");
		        f.setSize(1024,768);
		        f.setLocationRelativeTo(null);
		        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        f.setVisible(true);
		        f.getContentPane().add(lecteur);
			}
		});
		btnViewResume.setBounds(246, 74, 155, 23);
		panel.add(btnViewResume);
		
		JButton btnNewButton = new JButton("approve as a trainer ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = (Trainer) user ;
				JOptionPane.showMessageDialog(null, " user role changed to trainer ", "info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(246, 147, 155, 23);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainerApproval().setVisible(true);
				ViewLearner.this.dispose();
			}
		});
		btnBack.setBounds(246, 208, 155, 23);
		panel.add(btnBack);
	}

}
