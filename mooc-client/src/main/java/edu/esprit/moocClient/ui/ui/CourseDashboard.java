package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;

import edu.esprit.mooc.client.BuisnessDeligator.ManageCourseDelegate;
import edu.esprit.mooc.domain.Entity.*;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;

public class CourseDashboard extends JFrame {

	private JPanel contentPane;
	static CourseDashboard frame;
	static ManageCourseDelegate manager = new ManageCourseDelegate();
	static JList list = new JList();
	private final ButtonGroup buttonGroup = new ButtonGroup();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CourseDashboard();
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
	public CourseDashboard() {
		setTitle("courses dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnViewCourse = new JButton("view course ");
		btnViewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Course course = (Course) list.getSelectedValue();
				if (list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select a course from the list!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} 
				else {

					new ViewCourse1(course).setVisible(true);
					CourseDashboard.this.dispose();

				}

			}
		});
		panel_1.add(btnViewCourse);

		JButton btnNewButton_3 = new JButton("learn more ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Course course = (Course) list.getSelectedValue();
				if (list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select a course from the list!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} 
				else {

				Browser browser = new Browser();
			       BrowserView browserView = new BrowserView(browser);
			 
			       JFrame frame = new JFrame("learn more");
			       frame.getContentPane().add(browserView, BorderLayout.CENTER);
			       frame.setSize(700, 500);
			       frame.setVisible(true);
			       
			       browser.loadURL("https://www.google.tn/#q="+course.getNom_course());
	    
				}
				
				
			}
		});
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("back");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ApprovalFirstMenu().setVisible(true);
				CourseDashboard.this.dispose();
				
			}
		});
		panel_1.add(btnNewButton_5);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);

		JRadioButton rdbtnall = new JRadioButton("all courses");
		rdbtnall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnall.isSelected()) {
					LoadAllCourses();
				}
			}
		});
		buttonGroup.add(rdbtnall);

		panel_2.add(rdbtnall);

		JRadioButton rdbtnpending = new JRadioButton("pending courses");
		rdbtnpending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnpending.isSelected()) {
					LoadpendingCourses();
				}
			}
		});
		buttonGroup.add(rdbtnpending);
		panel_2.add(rdbtnpending);

		JRadioButton rdbtnapproved = new JRadioButton("approved courses");
		rdbtnapproved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnapproved.isSelected()) {
					LoadacceptedCourses();
				}
			}
		});
		buttonGroup.add(rdbtnapproved);
		panel_2.add(rdbtnapproved);

		JRadioButton rdbtnrefused = new JRadioButton("refused courses ");
		rdbtnrefused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnrefused.isSelected()) {
					LoadrefusedCourses();
				}
			}
		});
		buttonGroup.add(rdbtnrefused);
		panel_2.add(rdbtnrefused);

		panel.add(list, BorderLayout.CENTER);

	}

	public static void LoadAllCourses() {
		DefaultListModel listModel = new DefaultListModel();
		java.util.List<Course> listCourses = manager.getAllCourses();
		Course course = new Course();
		Iterator iterator = listCourses.iterator();
		while (iterator.hasNext()) {

			listModel.addElement(iterator.next());
		}
		list.setModel(listModel);

	}

	public static void LoadpendingCourses() {
		DefaultListModel listModel = new DefaultListModel();
		java.util.List<Course> listCourses = manager.getpendingCourses();
		Course course = new Course();
		Iterator iterator = listCourses.iterator();
		while (iterator.hasNext()) {

			listModel.addElement(iterator.next());
		}
		list.setModel(listModel);

	}

	public static void LoadacceptedCourses() {
		DefaultListModel listModel = new DefaultListModel();
		java.util.List<Course> listCourses = manager.getacceptedCourses();
		Course course = new Course();
		Iterator iterator = listCourses.iterator();
		while (iterator.hasNext()) {

			listModel.addElement(iterator.next());
		}
		list.setModel(listModel);

	}

	public static void LoadrefusedCourses() {
		DefaultListModel listModel = new DefaultListModel();
		java.util.List<Course> listCourses = manager.getrefusedCourses();
		Course course = new Course();
		Iterator iterator = listCourses.iterator();
		while (iterator.hasNext()) {

			listModel.addElement(iterator.next());
		}
		list.setModel(listModel);

	}

}