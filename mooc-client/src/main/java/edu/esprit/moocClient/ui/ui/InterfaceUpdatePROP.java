package edu.esprit.moocClient.ui.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceUpdatePROP {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceUpdatePROP window = new InterfaceUpdatePROP();
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
	public InterfaceUpdatePROP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Proposition");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(56, 63, 88, 23);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(184, 56, 184, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(121, 144, 177, 30);
		frame.getContentPane().add(btnOk);
	}
}
