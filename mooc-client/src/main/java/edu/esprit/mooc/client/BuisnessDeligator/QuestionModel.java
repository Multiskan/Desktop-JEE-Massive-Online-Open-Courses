package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import javax.swing.table.AbstractTableModel;


import edu.esprit.mooc.domain.Entity.SurveyQst;



public class QuestionModel extends AbstractTableModel {
	List<SurveyQst> LQuestion ;
	 String[] columnTab={"Id","Question","nbreProposition"};
	 
	 public QuestionModel(List<SurveyQst> lQuest){
	       this.LQuestion=lQuest;
	    }
	@Override
	public int getColumnCount() {
		return  columnTab.length;
		
	}

	@Override
	public int getRowCount() {
		return LQuestion.size();
	}

	@Override
	public Object getValueAt(int rowIndex,int columnIndex) {
	    switch (columnIndex){
        case 0: 
            return LQuestion.get(rowIndex).getId();
            case 1:
            return LQuestion.get(rowIndex).getQuestion();
            case 2:
            return LQuestion.get(rowIndex).getNbrProposition();
            default:
                    return null;
    }
    }


    public String getColumnName(int column){
        return columnTab[column];
    }
}
