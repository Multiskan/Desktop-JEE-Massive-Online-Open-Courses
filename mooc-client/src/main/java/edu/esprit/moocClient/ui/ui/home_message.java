package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.hql.spi.FilterTranslator;

import edu.esprit.mooc.client.BuisnessDeligator.GestMessageBD;
import edu.esprit.mooc.client.BuisnessDeligator.GestUserBD;
import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class home_message extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private final Action action = new SwingAction();
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_message frame = new home_message();
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
	public home_message() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(10, 9, 12, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(5, 40, 36, 14);
		panel.add(lblSubject);
		
		textField_5 = new JTextField();
		textField_5.setBounds(94, 37, 186, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(94, 68, 186, 116);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblBody = new JLabel("Body");
		lblBody.setBounds(10, 119, 24, 14);
		lblBody.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBody.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblBody);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(88, 217, 79, 23);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				Message m = new Message();
				m.setBody(textField_6.getText());
				m.setSubject(textField_5.getText());
				m.setDate_Message(dateFormat.format(date));
				GestUserBD.Send(m);
			}
		});
		panel.add(btnSend);
		
		

		
		

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
				
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 6, 186, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		
		


		
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
