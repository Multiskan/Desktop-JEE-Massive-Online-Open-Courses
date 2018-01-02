package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

import edu.esprit.mooc.client.BuisnessDeligator.ManageCourseDelegate;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ImageGeneration extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField name;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	static ManageCourseDelegate manager = new ManageCourseDelegate();
	static PieChart demo = new PieChart() ;
	static int p ;
	 static int a ;
	static int ac ;
	static int re ;
	JComboBox comboBox ;
	  File pieChart  ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageGeneration frame = new ImageGeneration();
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
	public ImageGeneration() {
		p = manager.countpendingcourses();
		 a= manager.countallcourses();
		 ac= manager.countacceptedcourses();
		re=manager.countrefusedcourses();
		setTitle("chart generation");
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
		
		JLabel lblImageType = new JLabel("image type");
		lblImageType.setBounds(8, 151, 71, 28);
		panel.add(lblImageType);
		
		JRadioButton jpegg = new JRadioButton("JPEG");
		buttonGroup_1.add(jpegg);
		jpegg.setBounds(95, 149, 109, 23);
		panel.add(jpegg);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("PNG");
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(226, 148, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_1 = new JButton("save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem()=="PIeplot 3d")
				 {  System.out.println(p+ac+re);
					PieDataset dataset = demo.createDataset(p, ac, re);
					JFreeChart chart = demo.createChart(dataset, "Courses statistics");
					int width = 560; /* Width of the image */
				    int height = 370; /* Height of the image */ 
				    if (jpegg.isSelected())
				    {
				    	 pieChart = new File( name.getText()+".jpeg");
				    	
				    }
				    else if (rdbtnNewRadioButton_1.isSelected()){
				    	pieChart = new File( name.getText()+".png" );
				    }
				    
				    try {
						ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				 }
				else if (comboBox.getSelectedItem()=="barchart"){
					System.out.println(p+ac+re);
					CategoryDataset dataset = demo.createDatasetbar(p, ac, re); 
					
					JFreeChart chart =  demo.createbarchart(dataset, "courses statistics");
					int width = 560; /* Width of the image */
				    int height = 370; /* Height of the image */ 
				    if (jpegg.isSelected())
				    {
				    	 pieChart = new File( name.getText()+".jpeg");
				    	
				    }
				    else if (rdbtnNewRadioButton_1.isSelected()){
				    	pieChart = new File( name.getText()+".png" );
				    }
				    
				    try {
						ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		btnNewButton_1.setBounds(88, 206, 89, 37);
		panel.add(btnNewButton_1);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Statistics().setVisible(true);
				ImageGeneration.this.dispose();
				
			}
		});
		btnBack.setBounds(222, 204, 89, 37);
		panel.add(btnBack);
		
		JLabel lblImageName = new JLabel("image name");
		lblImageName.setBounds(8, 48, 90, 14);
		panel.add(lblImageName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(95, 45, 194, 20);
		panel.add(name);
		
		JLabel lblChartType = new JLabel("chart type ");
		lblChartType.setBounds(10, 105, 74, 23);
		panel.add(lblChartType);
		
		comboBox = new JComboBox();
		comboBox.setBounds(101, 105, 89, 20);
		panel.add(comboBox);
		comboBox.addItem("PIeplot 3d");
		comboBox.addItem("barchart");
	}
}
