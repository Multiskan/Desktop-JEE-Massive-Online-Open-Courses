package edu.esprit.moocClient.ui.ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;


import edu.esprit.mooc.client.BuisnessDeligator.*;
import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SurQuestPropInterface {
	Integer index, index2, index3;
    List<Survey> listsurvey;
    List<SurveyQst> Lquestion;
    List<SurveyProposition>    Lproposition;
;
	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SurQuestPropInterface window = new SurQuestPropInterface();
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
	public SurQuestPropInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 296);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Delete Survey");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index=new Integer(table.getSelectedRow());
				Survey s = listsurvey.get(index);
		  		Lquestion= QuestionDelegator.findQuestionsByIdSurvey(s);
		  		
		  		if(Lquestion.size()==0){

				SurveyDelegater.removeSurvey(s);
				listsurvey.remove(s);
				table.setModel(new SurveyModel(listsurvey));}
		  		else{
		  		javax.swing.JOptionPane.showMessageDialog(null,"vous pouvez pas supprimer ce Survey");
		  			
		  		}
			}
		});
		btnNewButton.setBounds(292, 201, 124, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Display Questions");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			  index2=new Integer(table.getSelectedRow());
			InterfaceConsultQST consultqst= new InterfaceConsultQST(index2);
			consultqst.getFrame().setVisible(true);
			
			}
		});
		btnNewButton_1.setBounds(20, 201, 138, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 718, 172);
		frame.getContentPane().add(scrollPane);
		//***************affichage surveys***************
		table = new JTable();
		scrollPane.setViewportView(table);
		
		listsurvey = SurveyDelegater.findAllSurveys();
		table.setModel(new SurveyModel(listsurvey));
		
		JButton btnNewButton_4 = new JButton("update Survey");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_4.setBounds(533, 201, 117, 32);
		frame.getContentPane().add(btnNewButton_4);

		
		//******************************************
		
	}
}
