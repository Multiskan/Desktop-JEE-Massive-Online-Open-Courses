package edu.esprit.moocClient.ui.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.services.SessionBean.GestionSurveySBRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class SurveyInterface extends javax.swing.JPanel{

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField txtSurveyName;
	private JTextField txtNbrQst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SurveyInterface window = new SurveyInterface();
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
	public SurveyInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		frame.setBounds(100, 100, 448, 296);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Survey");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(161, 11, 141, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SurveyName:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 73, 120, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtSurveyName = new JTextField();
		txtSurveyName.setBounds(180, 73, 133, 20);
		frame.getContentPane().add(txtSurveyName);
		txtSurveyName.setColumns(10);
		
		JLabel lblNbrOfQuestion = new JLabel("number of questions:");
		lblNbrOfQuestion.setBackground(new Color(0, 255, 255));
		lblNbrOfQuestion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNbrOfQuestion.setForeground(Color.BLACK);
		lblNbrOfQuestion.setBounds(10, 118, 146, 26);
		frame.getContentPane().add(lblNbrOfQuestion);
		
		txtNbrQst = new JTextField();
		txtNbrQst.setBounds(180, 122, 133, 20);
		frame.getContentPane().add(txtNbrQst);
		txtNbrQst.setColumns(10);
		
		JButton btnNewButton = new JButton("add questions");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Question Q =new Question();
				 frame.setVisible(false);
				//	Q.setVisible(true);	
				 Q.getFrame().setVisible(true);
				
				
				try {
					Context ctx = new InitialContext();
					GestionSurveySBRemote gest = (GestionSurveySBRemote) ctx.lookup("/Moocs.ejb/SurveySb!"+ GestionSurveySBRemote.class.getCanonicalName());

		//***********ajout**************		
		        Survey su = new Survey();
		        su.setNbrQst(Integer.parseInt(txtNbrQst.getText()));
		        su.setNomSurvey(txtSurveyName.getText());
		        
		        gest.persistSurvey(su);		
		       

				} catch (NamingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(140, 200, 133, 23);
		frame.getContentPane().add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(346, 122, 29, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnConsulter = new JButton("Consulter");
		btnConsulter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SurQuestPropInterface consult= new SurQuestPropInterface();
				consult.getFrame().setVisible(true);
			}
		});
		btnConsulter.setBounds(10, 200, 120, 23);
		frame.getContentPane().add(btnConsulter);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Comitemenu consult= new Comitemenu();
				consult.setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(283, 200, 133, 23);
		frame.getContentPane().add(btnBack);
	}

	public JTextField getTxtNbrQst() {
		return txtNbrQst;
	}

	public void setTxtNbrQst(JTextField txtNbrQst) {
		this.txtNbrQst = txtNbrQst;
	}
}
