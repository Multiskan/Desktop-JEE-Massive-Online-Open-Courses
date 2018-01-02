package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;


public class PropositionModel extends AbstractTableModel{

	List<SurveyProposition> LProp ;
	 String[] columnTab={"Id","Proposition","nbrReponse"};
	 
	 public  PropositionModel(List<SurveyProposition> listprop) {
		this.LProp=listprop;
	}
	
	@Override
	public int getColumnCount() {
		return  columnTab.length;
	}

	@Override
	public int getRowCount() {
		return LProp.size();
	}

	@Override
	public Object getValueAt(int rowIndex,int columnIndex) {
		 switch (columnIndex){
	        case 0: 
	            return LProp.get(rowIndex).getId();
	            case 1:
	            return LProp.get(rowIndex).getProposition();
	            case 2:
	            return LProp.get(rowIndex).getNbrReponse();
	            default:
		           return null;
		        
	     }

     }
	
	 public String getColumnName(int column){
	        return columnTab[column];
	    }
}
