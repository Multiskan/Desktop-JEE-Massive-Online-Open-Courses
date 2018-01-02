package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyQst;
import edu.esprit.mooc.client.BuisnessDeligator.*;
import edu.esprit.mooc.client.ServiceLocator.ServiceLocator;
import edu.esprit.mooc.services.SessionBean.GestionSurveyQstSBRemote;

public class QuestionDelegator {
	
		private static final String jndi="/mooc-ejb/SurveyQstSb!edu.esprit.mooc.services.SessionBean.GestionSurveyQstSBRemote";

		private static GestionSurveyQstSBRemote getProxy(){
			GestionSurveyQstSBRemote remote=null;
			 if(remote==null){
		     remote=(GestionSurveyQstSBRemote) ServiceLocator.getInstance().getProxy(jndi);
			 }
			 return remote;
			

	}
		public static void persistSurvey(SurveyQst qst)
		{
			getProxy().persistSurveyQst(qst);
		}
		public static void updateSurvey(SurveyQst qst)
		{
			getProxy().updateSurveyQst(qst);
		}
		public static void removeSurvey(SurveyQst qst)
		{
			getProxy().removeSurveyQst(qst);
		}
		public static SurveyQst findByIdSurveyQst(Integer id)
		{
			return getProxy().findByIdSurveyQst(id);
		}
		public static List<SurveyQst> findQuestionsByIdSurvey(Survey s){
			 return getProxy().findQuestionsByIdSurvey(s);
		 }
		 public static List<SurveyQst> findAllQuestion(){
			 return getProxy().findAllQuestion();
			 
		 }
		 public static SurveyQst findLastQuestion(){
			 return getProxy().findLastQst();
			 
		 }
		
	}

