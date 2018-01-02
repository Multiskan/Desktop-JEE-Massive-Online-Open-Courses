package edu.esprit.moocClient.ui.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JFrame {

	private JPanel contentPane;

	 private static final long serialVersionUID = 1L;

	  public PieChart(String applicationTitle, String chartTitle,double pending,double accepted , double refused) {
	        super(applicationTitle);
	        // This will create the dataset 
	        PieDataset dataset = createDataset(pending,accepted,refused);
	        // based on the dataset we create the chart
	        JFreeChart chart = createChart(dataset, chartTitle);
	        // we put the chart into a panel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        // default size
	        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	        // add it to our application
	        setContentPane(chartPanel);

	    }
	    
	    
	/**
	     * Creates a sample dataset 
	     */

	    public PieDataset createDataset(double pending ,double accepted , double refused ) {
	        DefaultPieDataset result = new DefaultPieDataset();
	        result.setValue("pending courses "+pending, pending);
	        result.setValue("accepted courses "+accepted, accepted);
	        result.setValue("refused courses "+refused, refused);
	       
	        return result;
	        
	    }
	    
	    
	/**
	     * Creates a chart
	     */

	   public JFreeChart createChart(PieDataset dataset, String title) {
	         
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
	    
	    public JFreeChart createbarchart(CategoryDataset dataset, String title){
	    	JFreeChart chart = ChartFactory.createBarChart(title, "",    
	    	         "number",            
	    	         (CategoryDataset) dataset,          
	    	         PlotOrientation.VERTICAL,           
	    	         true, true, false);
	    	
	    	return chart ;
	    }
	    
	    public void generatebarchart(String applicationTitle, String chartTitle,double pending,double accepted , double refused){
	    	
	    	
	    	 // This will create the dataset 
	        CategoryDataset dataset = createDatasetbar( pending,accepted ,  refused);
	        // based on the dataset we create the chart
	        JFreeChart chart = createbarchart(dataset, chartTitle);
	        // we put the chart into a panel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        // default size
	        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	        // add it to our application
	        setContentPane(chartPanel);
	    	
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	  public  CategoryDataset createDatasetbar(double pending,double accepted , double refused )
	    {
	       final String pendingd  = "pending courses";        
	       final String acceptedd = "accepted courses ";        
	       final String refsedd = "refused courses";        
	       final String speed = "courses statut";        
	        
	       final DefaultCategoryDataset dataset = 
	       new DefaultCategoryDataset( );  

	       dataset.addValue( pending,pendingd , speed );        
	           

	       dataset.addValue( accepted, acceptedd, speed );        
	      

	       dataset.addValue( refused , refsedd , speed );        
	                  

	       return dataset; 
	    }
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					//PieChart demo = new PieChart("statistics","Courses statistics",30,30,40);
					PieChart demo =new PieChart();
					demo.generatebarchart("statistics", "courses number statistics",30,30,40);
					   demo.pack();
			          demo.setVisible(true);
			         
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PieChart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
