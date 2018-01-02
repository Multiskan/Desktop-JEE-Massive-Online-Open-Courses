package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.esprit.mooc.client.BuisnessDeligator.ManageCourseDelegate;
import edu.esprit.mooc.domain.Entity.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea; 


public class Addcourse extends JFrame {

	private JPanel contentPane;
	private JTextField coursename;
	private JTextField linkvideo;
	ManageCourseDelegate manager = new ManageCourseDelegate();
	private JTextField linkphoto;
	private JTextField prerequis;
	static private JTextArea goal; 
	private JTextField objec;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addcourse frame = new Addcourse();
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
	public Addcourse() {
		setTitle("submit a course idea");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 76, 75, 14);
		contentPane.add(lblName);
		
		coursename = new JTextField();
		coursename.setBounds(146, 73, 144, 20);
		contentPane.add(coursename);
		coursename.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("link video");
		lblNewLabel.setBounds(20, 101, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStartAt = new JLabel("Start at");
		lblStartAt.setBounds(20, 137, 46, 14);
		contentPane.add(lblStartAt);
		
		linkvideo = new JTextField();
		linkvideo.setColumns(10);
		linkvideo.setBounds(146, 98, 144, 20);
		contentPane.add(linkvideo);
		
		JDateChooser dateStartCourse = new JDateChooser();
		dateStartCourse.setBounds(146, 131, 144, 20);
		contentPane.add(dateStartCourse);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addcourse.this.dispose();
			}
		});
		btnCancel.setBounds(296, 338, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnAddCourse = new JButton("Add");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course course = new Course();
				try {
				
				course.setNom_course(coursename.getText());
				course.setVideo(linkvideo.getText());
				course.setDate_debut(dateStartCourse.getDate());
				course.setPhoto(linkphoto.getText());
				course.setPre_requis(prerequis.getText());
				course.setObjectif(objec.getText());
				course.setStatut("pending");
				course.setDuree(3);
				course.setTrainer(null);
				manager.addCourse(course);
					
				} catch ( Exception ex) {
					ex.printStackTrace();
				}
				Addcourse.this.dispose();
			}
		});
		btnAddCourse.setBounds(180, 338, 89, 23);
		contentPane.add(btnAddCourse);
		
		JLabel lblLinkPhoto = new JLabel("link description\r\n");
		lblLinkPhoto.setBounds(20, 180, 89, 14);
		contentPane.add(lblLinkPhoto);
		
		linkphoto = new JTextField();
		linkphoto.setBounds(146, 177, 144, 20);
		contentPane.add(linkphoto);
		linkphoto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("prerequisites");
		lblNewLabel_1.setBounds(20, 229, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		prerequis = new JTextField();
		prerequis.setBounds(146, 226, 144, 20);
		contentPane.add(prerequis);
		prerequis.setColumns(10);
		
		JLabel lblObjectifs = new JLabel("objectifs");
		lblObjectifs.setBounds(20, 262, 75, 14);
		contentPane.add(lblObjectifs);
		
		objec = new JTextField();
		objec.setBounds(146, 259, 144, 20);
		contentPane.add(objec);
		objec.setColumns(10);
		
		JButton btnAddPdf = new JButton("add pdf");
		btnAddPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Addpdf().setVisible(true);
			}
		});
		btnAddPdf.setBounds(296, 176, 89, 23);
		contentPane.add(btnAddPdf);
	}
}
