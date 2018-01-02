package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jboss.remoting3.spi.NetworkServerProvider;

import edu.esprit.mooc.client.BuisnessDeligator.ManageCourseDelegate;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerateChart extends JFrame {

	private JPanel contentPane;
	static ManageCourseDelegate manager = new ManageCourseDelegate();
	JComboBox<String> comboBox ;
	static PieChart demo ;
	static int p ;
	 static int a ;
	static int ac ;
	static int re ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateChart frame = new GenerateChart();
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
	public GenerateChart() {
		
		p = manager.countpendingcourses();
		 a= manager.countallcourses();
		 ac= manager.countacceptedcourses();
		re=manager.countrefusedcourses();
		setTitle("generate a chart ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblChartGeneration = new JLabel("Chart Generation ");
		lblChartGeneration.setForeground(new Color(0, 0, 153));
		lblChartGeneration.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblChartGeneration.setBounds(165, 11, 144, 26);
		panel.add(lblChartGeneration);
		
		JLabel lblPleaseSelectThe = new JLabel("please select the chart type to be generated ");
		lblPleaseSelectThe.setForeground(new Color(0, 102, 153));
		lblPleaseSelectThe.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblPleaseSelectThe.setBounds(19, 72, 290, 14);
		panel.add(lblPleaseSelectThe);
		
		JLabel lblChartType = new JLabel("Chart type :");
		lblChartType.setForeground(new Color(0, 0, 153));
		lblChartType.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblChartType.setBounds(19, 117, 82, 26);
		panel.add(lblChartType);
		
		comboBox = new JComboBox();
		comboBox.setBounds(150, 119, 111, 20);
		comboBox.addItem("Pieplot 3D");
		comboBox.addItem("barchart");
		
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(p);
				System.out.println(ac);						
				System.out.println(re);
				if(comboBox.getSelectedItem()=="Pieplot 3D")
				 {
					demo = new PieChart("statistics","Courses statistics",p,ac,re);
				 
				 }
				 else if (comboBox.getSelectedItem()=="barchart")
				 {  
					
					demo.generatebarchart("statistics","Courses statistics",p,ac,re);
				 }
				
		          demo.pack();
		          demo.setVisible(true);		
			}
		});
		btnNewButton.setBounds(80, 196, 89, 34);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Statistics().setVisible(true);
				GenerateChart.this.dispose();
			}
		});
		btnBack.setBounds(241, 196, 89, 34);
		panel.add(btnBack);
	}
}
