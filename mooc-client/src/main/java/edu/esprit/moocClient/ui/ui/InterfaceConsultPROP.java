package edu.esprit.moocClient.ui.ui;


import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;

import edu.esprit.mooc.client.BuisnessDeligator.*;
import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceConsultPROP {

	private JFrame frame;
	int Index;
	List<SurveyQst> Lquestion;
	List<SurveyProposition> Lproposition;
	private JTable table;
	private JButton btnDelete;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InterfaceConsultPROP window = new InterfaceConsultPROP();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public InterfaceConsultPROP(int Index, List<SurveyQst> Lquestion) {
		this.Index=Index;
		this.Lquestion=Lquestion;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 550, 215);
		frame.getContentPane().add(scrollPane);
		
		  SurveyQst q = Lquestion.get(Index);
		  Lproposition = PropositionDelegator.findPropositionByQuestion(q);

		table = new JTable();
	    table.setModel(new PropositionModel(Lproposition));

		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("Delete PROP");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=new Integer(table.getSelectedRow());
				SurveyProposition prop = Lproposition.get(index);
				PropositionDelegator.removeSurvey(prop);
				Lproposition.remove(prop);
				table.setModel(new PropositionModel(Lproposition));
			
			}
		});
		btnDelete.setBounds(341, 226, 181, 25);
		frame.getContentPane().add(btnDelete);
		
		btnNewButton = new JButton("Show Chart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Charts chart=new Charts(Lproposition);
				chart.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 227, 197, 25);
		frame.getContentPane().add(btnNewButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
