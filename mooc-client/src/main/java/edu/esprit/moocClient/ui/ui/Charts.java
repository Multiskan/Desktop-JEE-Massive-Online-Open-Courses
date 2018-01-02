package edu.esprit.moocClient.ui.ui;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;

import edu.esprit.mooc.domain.Entity.SurveyProposition;


public class Charts extends JFrame{
	
	List<SurveyProposition> listprop;
	
	 public Charts(List<SurveyProposition> listprop) 
	    {     super();
	        this.listprop=listprop;
	        DefaultPieDataset union = new DefaultPieDataset();
	        for(int i =0;i<listprop.size();i++){
	        	union.setValue(listprop.get(i).getProposition(), listprop.get(i).getNbrReponse());
	        }
//	        union.setValue("Prop1",40);
//	        union.setValue("Prop2",10);
//	        union.setValue("Prop3",25);
//	        union.setValue("Prop4",5);
//	        union.setValue("Prop5",20);
	        JFreeChart repart = 
	            ChartFactory.createPieChart3D(" learners responses",
	            union,true, true, false);
	        ChartPanel crepart = new ChartPanel(repart);
	        Plot plot = repart.getPlot();
	        ((PiePlot)plot).setSectionPaint("Proposition1", new Color(255,0,0));
	        ((PiePlot)plot).setSectionPaint("Proposition2", new Color(255,255,0));
	        ((PiePlot)plot).setSectionPaint("Proposition3", new Color(255,0,255));
	        ((PiePlot)plot).setSectionPaint("Proposition4", new Color(0,0,255));
	        ((PiePlot)plot).setSectionPaint("Proposition5", new Color(0,255,255));
	        this.setBounds(100, 100, 586, 300);
	        
	        this.add(crepart);
	    }
//public static void main(String[] args) {
//	 Charts c= new Charts();
//	c.setVisible(true);
//		
//}
}
