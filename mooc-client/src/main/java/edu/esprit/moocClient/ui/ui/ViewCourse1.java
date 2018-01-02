package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.mooc.client.BuisnessDeligator.ManageCourseDelegate;
import edu.esprit.mooc.domain.Entity.*;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ViewCourse1 extends JFrame {
     static ViewCourse1 frame ;
	private JPanel contentPane;
    private Course course ;
    static ManageCourseDelegate manager = new ManageCourseDelegate();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new ViewCourse1();
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
	public ViewCourse1(Course course){
		this.course = course ;
		System.out.println(course.getNom_course());
		this.setVisible(true);
		setTitle("course details ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coursename = new JLabel("");
		coursename.setForeground(new Color(0, 102, 204));
		coursename.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		coursename.setBounds(113, 28, 185, 48);
		coursename.setText(course.getNom_course());
		contentPane.add(coursename);
		
		JLabel prerequis = new JLabel("");
		prerequis.setForeground(new Color(0, 102, 204));
		prerequis.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		prerequis.setBounds(113, 119, 224, 48);
		prerequis.setText(course.getPre_requis());

		contentPane.add(prerequis);
		
		JLabel objectifs = new JLabel("");
		objectifs.setForeground(new Color(0, 102, 204));
		objectifs.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		objectifs.setBounds(113, 223, 264, 55);
		objectifs.setText(course.getObjectif());
		contentPane.add(objectifs);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CourseDashboard().setVisible(true);
				ViewCourse1.this.dispose();
			   
			}
		});
		btnBack.setBounds(238, 343, 99, 38);
		contentPane.add(btnBack);
		
		JButton btnWatchVideo = new JButton("watch video ");
		btnWatchVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Browser browser = new Browser();
			       BrowserView browserView = new BrowserView(browser);
			 
			       JFrame frame = new JFrame(" course video description ");
			       frame.getContentPane().add(browserView, BorderLayout.CENTER);
			       frame.setSize(700, 500);
			       frame.setVisible(true);
			       
			       browser.loadURL(course.getVideo());
			}
		});
		btnWatchVideo.setBounds(409, 203, 129, 38);
		contentPane.add(btnWatchVideo);
		
		JLabel lblNewLabel = new JLabel("course_name");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setBounds(0, 38, 80, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("prerequis");
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setBounds(0, 128, 67, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("goals");
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setBounds(0, 235, 67, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnOpenDescription = new JButton("open description");
		btnOpenDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LecteurPdf lecteur = null;
				try {
					lecteur = new LecteurPdf(course.getPhoto());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        //créer le JFrame
		        JFrame f = new JFrame("course description viewer");
		        f.setSize(1024,768);
		        f.setLocationRelativeTo(null);
		        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        f.setVisible(true);
		        f.getContentPane().add(lecteur);
				
				
			}
		});
		btnOpenDescription.setBounds(409, 121, 129, 38);
		contentPane.add(btnOpenDescription);
		
		JLabel lblCourseDetails = new JLabel("Course details");
		lblCourseDetails.setForeground(new Color(0, 0, 255));
		lblCourseDetails.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblCourseDetails.setBounds(238, 0, 118, 38);
		contentPane.add(lblCourseDetails);
	
	}
	
	public ViewCourse1() {
		setTitle("course details ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coursename = new JLabel("");
		coursename.setForeground(new Color(0, 102, 204));
		coursename.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		coursename.setBounds(113, 28, 185, 48);
		contentPane.add(coursename);
		
		JLabel prerequis = new JLabel("");
		prerequis.setForeground(new Color(0, 102, 204));
		prerequis.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		prerequis.setBounds(113, 119, 224, 48);
		contentPane.add(prerequis);
		
		JLabel objectifs = new JLabel("");
		objectifs.setForeground(new Color(0, 102, 204));
		objectifs.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		objectifs.setBounds(113, 223, 264, 55);
		contentPane.add(objectifs);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CourseDashboard().setVisible(true);
				ViewCourse1.this.dispose();
			   
			}
		});
		btnBack.setBounds(238, 343, 99, 38);
		contentPane.add(btnBack);
		
		JButton btnWatchVideo = new JButton("watch video ");
		btnWatchVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Browser browser = new Browser();
			       BrowserView browserView = new BrowserView(browser);
			 
			       JFrame frame = new JFrame("learn more ");
			       frame.getContentPane().add(browserView, BorderLayout.CENTER);
			       frame.setSize(700, 500);
			       frame.setVisible(true);
			       
			       browser.loadURL("https://www.google.tn/");
			}
		});
		btnWatchVideo.setBounds(409, 203, 129, 38);
		contentPane.add(btnWatchVideo);
		
		JLabel lblNewLabel = new JLabel("course_name");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setBounds(0, 38, 80, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("prerequis");
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setBounds(0, 128, 67, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("goals");
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setBounds(0, 235, 67, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnOpenDescription = new JButton("open description");
		btnOpenDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LecteurPdf lecteur = null;
				try {
					lecteur = new LecteurPdf("kk");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        //créer le JFrame
		        JFrame f = new JFrame("course description viewer");
		        f.setSize(1024,768);
		        f.setLocationRelativeTo(null);
		        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        f.setVisible(true);
		        f.getContentPane().add(lecteur);
				
				
			}
		});
		btnOpenDescription.setBounds(409, 121, 129, 38);
		contentPane.add(btnOpenDescription);
		
		JLabel lblCourseDetails = new JLabel("Course details");
		lblCourseDetails.setForeground(new Color(0, 0, 255));
		lblCourseDetails.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblCourseDetails.setBounds(238, 0, 118, 38);
		contentPane.add(lblCourseDetails);
	}
}
