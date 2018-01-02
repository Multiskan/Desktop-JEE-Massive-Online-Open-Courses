package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;

import edu.esprit.mooc.client.BuisnessDeligator.ManageUserDelegate;
import edu.esprit.mooc.domain.Entity.*;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class TrainerApproval extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Learner learner ;
	static JList list ;
   static ManageUserDelegate manager = new ManageUserDelegate();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainerApproval frame = new TrainerApproval();
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
	public TrainerApproval() {
		setTitle("TrainnerApproval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 271, 580, 33);
		contentPane.add(panel_2);
		
		JRadioButton rdbtnAcceptedRequests = new JRadioButton("accepted requests");
		rdbtnAcceptedRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loadtaccepteddemand();
				
			}
		});
		buttonGroup.add(rdbtnAcceptedRequests);
		panel_2.add(rdbtnAcceptedRequests);
		
		JRadioButton rdbtnAllRequests = new JRadioButton("all requests");
		rdbtnAllRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loadtrainerdemand();
			}
		});
		buttonGroup.add(rdbtnAllRequests);
		panel_2.add(rdbtnAllRequests);
		
		list = new JList();
		list.setBounds(5, 29, 468, 241);
		contentPane.add(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 24);
		contentPane.add(panel);
		
		JLabel lblWelcomeToTrainerapproval = new JLabel("welcome to trainerapproval dashboard ");
		panel.add(lblWelcomeToTrainerapproval);
		
		JButton btnNewButton = new JButton("view learner");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = (User)list.getSelectedValue();
				if (list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select a learner from the list!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} 
				else {
				 new ViewLearner(user).setVisible(true);
				 TrainerApproval.this.dispose();}
			}
		});
		btnNewButton.setBounds(478, 29, 107, 125);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.setBounds(483, 151, 107, 119);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new MembershipApproval().setVisible(true);
				TrainerApproval.this.dispose();
			}
		});
	}
	
	public static void Loadtrainerdemand() {
		DefaultListModel listModel = new DefaultListModel();
		java.util.List<User> lerners = manager.getuserwithrequest();
		 User user = new User() ;
		Iterator iterator = lerners.iterator();
		while (iterator.hasNext()) {

			listModel.addElement(iterator.next());
		}
		list.setModel(listModel);

	}
	public static void Loadtaccepteddemand() {
		DefaultListModel listModel = new DefaultListModel();
		java.util.List<Request> lerners = manager.getacceptedrequest();
		 
		Iterator iterator = lerners.iterator();
		while (iterator.hasNext()) {

			listModel.addElement(iterator.next());
		}
		list.setModel(listModel);

	}

}
