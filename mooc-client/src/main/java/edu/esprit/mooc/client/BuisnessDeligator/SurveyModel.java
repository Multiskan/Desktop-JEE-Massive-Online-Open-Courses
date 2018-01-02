package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.esprit.mooc.domain.Entity.Survey;


public class SurveyModel extends AbstractTableModel {
	List<Survey> Lsurvey ;
	 String[] columnTab={"Id","Surveyname","nbreQst"};
	 
	 public SurveyModel(List<Survey> lSurvey){
	       this.Lsurvey=lSurvey;
	    }

	@Override
	public int getColumnCount() {
		
		return  columnTab.length;
	}

	@Override
	public int getRowCount() {
		
		return Lsurvey.size();
	}

	@Override
	 public Object getValueAt(int rowIndex,int columnIndex){
        switch (columnIndex){
            case 0: 
                return Lsurvey.get(rowIndex).getId();
                case 1:
                return Lsurvey.get(rowIndex).getNomSurvey();
                case 2:
                return Lsurvey.get(rowIndex).getNbrQst();
                
                            
               
                default:
                        return null;
        }
        }
	
	
        public String getColumnName(int column){
            return columnTab[column];
        }
}
