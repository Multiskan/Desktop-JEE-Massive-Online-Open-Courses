package edu.esprit.moocClient.ui.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import edu.esprit.mooc.client.BuisnessDeligator.*;
import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyQst;
import edu.esprit.mooc.services.SessionBean.GestionSurveyQstSBRemote;
import edu.esprit.mooc.services.SessionBean.GestionSurveySBRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Question extends javax.swing.JPanel{

	private JFrame frame;
    static	int q;
	

	public static int getQ() {
		return q;
	}

	public static void setQ(int q) {
		Question.q = q;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField txtQuestion;
	private JTextField txtNbrProp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question window = new Question();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Question() {
		q++;
		initialize();
		System.out.println("q="+ q);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Question");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(140, 11, 114, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question:");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 85, 89, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtQuestion = new JTextField();
		txtQuestion.setBounds(109, 87, 291, 20);
		frame.getContentPane().add(txtQuestion);
		txtQuestion.setColumns(10);
		
		JLabel lblNumberOfProposition = new JLabel("Number of proposition:");
		lblNumberOfProposition.setForeground(new Color(0, 128, 0));
		lblNumberOfProposition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNumberOfProposition.setBounds(10, 137, 156, 31);
		frame.getContentPane().add(lblNumberOfProposition);
		
		txtNbrProp = new JTextField();
		txtNbrProp.setBounds(195, 143, 86, 20);
		frame.getContentPane().add(txtNbrProp);
		txtNbrProp.setColumns(10);
		
		JButton btnNewButton = new JButton("add propositons");
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//**********Ajout*************
				SurveyQst Qst = new SurveyQst();
				Survey s = SurveyDelegater.findLastsurvey();
				Qst.setQuestion(txtQuestion.getText());
		        Qst.setNbrProposition(Integer.parseInt(txtNbrProp.getText()));
	            Qst.setSurvey(s);
	            QuestionDelegator.persistSurvey(Qst);

	            Proposition prop = new Proposition();
	            frame.setVisible(false);
		       prop.getFrame().setVisible(true);
	            
//		       //*************test sur nbre de question************** 
//		        SurveyInterface survey = new SurveyInterface();
//		        int nbqst = s.getNbrQst();
//		        Proposition prop = new Proposition();
//		        if (maxqst<nbqst){
//		        	 frame.setVisible(false);
//				      prop.getFrame().setVisible(true);
//				      maxqst=maxqst++;
//			      }
//			      else if (maxqst==nbqst) {
//			    	  frame.setVisible(false);
//			    	survey.getFrame().setVisible(true);
//			      }
//		        

		}
		});
		btnNewButton.setBounds(260, 212, 150, 23);
		frame.getContentPane().add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 6, 1));
		spinner.setBounds(322, 143, 29, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnConsulter = new JButton("Consulter");
		btnConsulter.setBounds(57, 212, 121, 23);
		frame.getContentPane().add(btnConsulter);
	}

	public JTextField getTxtNbrProp() {
		return txtNbrProp;
	}

	public void setTxtNbrProp(JTextField txtNbrProp) {
		this.txtNbrProp = txtNbrProp;
	}

}
