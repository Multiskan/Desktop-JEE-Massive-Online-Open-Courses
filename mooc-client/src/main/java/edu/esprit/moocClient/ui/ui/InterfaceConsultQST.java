package edu.esprit.moocClient.ui.ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import edu.esprit.mooc.client.BuisnessDeligator.*;
import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceConsultQST {

	private JFrame frame;
	private JTable table;
	int Index , index2 , index3;
	 List<SurveyQst> Lquestion;
	 List<SurveyProposition> Lproposition;
	 private JButton btnNewButton;
	 private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceConsultQST window = new InterfaceConsultQST(3);
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
	public InterfaceConsultQST(int Index) {
		this.Index=Index;
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 215);
		frame.getContentPane().add(scrollPane);
		  Survey s = SurveyDelegater.findAllSurveys().get(Index);  
		  Lquestion=QuestionDelegator.findQuestionsByIdSurvey(s);
		table = new JTable();
		scrollPane.setViewportView(table);
		  table.setModel(new QuestionModel(Lquestion));
		  
		  btnNewButton = new JButton("Display Prop");
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		index2=new Integer(table.getSelectedRow());
		  		InterfaceConsultPROP consultprop = new InterfaceConsultPROP(index2,Lquestion);
		  		consultprop.getFrame().setVisible(true);
		  	}
		  });
		  btnNewButton.setBounds(259, 226, 152, 25);
		  frame.getContentPane().add(btnNewButton);
		  
		  btnNewButton_1 = new JButton("Delete QST");
		  btnNewButton_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		index3= new Integer(table.getSelectedRow());
		  		SurveyQst q = Lquestion.get(index3);
		  		Lproposition = PropositionDelegator.findPropositionByQuestion(q);
		  		
		  		if (Lproposition.size()==0){
		  			
		  			QuestionDelegator.removeSurvey(q);
		  			
					Lquestion.remove(q);
					table.setModel(new QuestionModel(Lquestion));				
		  		}
		  		else {
		  			javax.swing.JOptionPane.showMessageDialog(null,"vous pouvez pas supprimer ce question");
		  		}
		  	}
		  });
		  btnNewButton_1.setBounds(22, 223, 165, 30);
		  frame.getContentPane().add(btnNewButton_1);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
