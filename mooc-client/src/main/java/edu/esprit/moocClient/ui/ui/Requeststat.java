package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class Requeststat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	 public Requeststat(String applicationTitle, String chartTitle,double pending,double accepted ) {
	        super(applicationTitle);
	        // This will create the dataset 
	        PieDataset dataset = createDataset(pending,accepted);
	        // based on the dataset we create the chart
	        JFreeChart chart = createChart(dataset, chartTitle);
	        // we put the chart into a panel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        // default size
	        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	        // add it to our application
	        setContentPane(chartPanel);

	    }
	
	 
	 private  PieDataset createDataset(double pending ,double accepted  ) {
	        DefaultPieDataset result = new DefaultPieDataset();
	        result.setValue("waiting requests"+pending, pending);
	        result.setValue("accepted requests "+accepted, accepted);
	      
	       
	        return result;
	        
	    }
	 
	 
	 private JFreeChart createChart(PieDataset dataset, String title) {
         
	        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
	            dataset,                // data
	            true,                   // include legend
	            true,
	            false);

	        PiePlot3D plot = (PiePlot3D) chart.getPlot();
	        plot.setStartAngle(290);
	        plot.setDirection(Rotation.CLOCKWISE);
	        plot.setForegroundAlpha(0.5f);
	        return chart;
	        
	        
	    }
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requeststat frame = new Requeststat();
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
	public Requeststat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
