package edu.esprit.moocClient.ui.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import edu.esprit.mooc.client.BuisnessDeligator.*;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;
import edu.esprit.mooc.services.SessionBean.GestionSurveyPropositionSBRemote;
import edu.esprit.mooc.services.SessionBean.GestionSurveyQstSBRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proposition {

	private JFrame frame;
	
	public static int  p;
	
	SurveyProposition prop = new SurveyProposition();
	Survey S=SurveyDelegater.findLastsurvey();
    SurveyQst Q = QuestionDelegator.findLastQuestion();
	 int nbprop= Q.getNbrProposition();
	 int nbqst=S.getNbrQst();
	 
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField txtProposition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Proposition window = new Proposition();
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
	public Proposition() {
		
		if (Q==null){System.out.println("la requette ne marche pas");}else{System.out.println("la requette marche ");}

		p++;
	    System.out.println("p="+p);
	    initialize();
	
	
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewProposition = new JLabel("New Proposition");
		lblNewProposition.setForeground(new Color(0, 128, 0));
		lblNewProposition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewProposition.setBounds(147, 11, 143, 23);
		frame.getContentPane().add(lblNewProposition);
		
		JLabel lblProposition = new JLabel("Proposition:");
		lblProposition.setForeground(new Color(0, 128, 0));
		lblProposition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblProposition.setBounds(10, 107, 98, 23);
		frame.getContentPane().add(lblProposition);
		
		txtProposition = new JTextField();
		txtProposition.setBounds(111, 109, 179, 20);
		frame.getContentPane().add(txtProposition);
		txtProposition.setColumns(10);
	
		JButton btnAddNextProp = new JButton("add next prop");
		btnAddNextProp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					
			       
					prop.setProposition(txtProposition.getText());
			        prop.setSurvQst(Q);
			        prop.setNbrReponse(10);
			        PropositionDelegator.persistSurvey(prop);
			        
			        if(Proposition.p<nbprop){
			    	
			        frame.setVisible(false);
			        Proposition newwindow = new Proposition();
					newwindow.frame.setVisible(true);
					
			        }
			    
			    else if (p==nbprop){
			    	if(Question.getQ()<nbqst){
			    		Proposition.p=0;
			    	 frame.setVisible(false);
			    	Question qst = new Question();
			    	qst.getFrame().setVisible(true);}
			    	else{
			    		 frame.setVisible(false);
			    		 SurveyInterface survint = new SurveyInterface();
			    		 survint.getFrame().setVisible(true);
			    		 javax.swing.JOptionPane.showMessageDialog(null,"Ajout terminé");
			    		
			    	}
			    }
//			        Question qst = new Question();
//			        SurveyInterface surv = new SurveyInterface();
			 //       int nbprop= Q.getNbrProposition();
//			      if (p<nbprop){
//			    	  
//			        frame.setVisible(false);
//					frame.setVisible(true);
//					p=p++;
//			      }
//			      else 
//			    	 // if (p==nbprop ) 
//			    	  {
//			    	 // if(qst.getMaxqst()<Integer.parseInt(surv.getTxtNbrQst().getText())){
//			    	  frame.setVisible(false);
//			    	  qst.getFrame().setVisible(true);}
////			    	  else {
////			    		  frame.setVisible(false);
////				    	  surv.getFrame().setVisible(true);
////			    	  }
//			    //  }
//					
			
				
			}
		});
		btnAddNextProp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnAddNextProp.setBounds(255, 203, 130, 23);
		frame.getContentPane().add(btnAddNextProp);
	}
	
	
}
