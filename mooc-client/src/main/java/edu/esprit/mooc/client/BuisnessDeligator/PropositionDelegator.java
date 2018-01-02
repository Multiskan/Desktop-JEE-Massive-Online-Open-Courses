package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;
import edu.esprit.mooc.client.ServiceLocator.*;
import edu.esprit.mooc.services.SessionBean.GestionSurveyPropositionSBRemote;

public class PropositionDelegator {
		
			private static final String jndi="/mooc-ejb/SurveyPropositionSb!edu.esprit.mooc.services.SessionBean.GestionSurveyPropositionSBRemote";

			private static GestionSurveyPropositionSBRemote getProxy(){
				GestionSurveyPropositionSBRemote remote=null;
				 if(remote==null){
			     remote=(GestionSurveyPropositionSBRemote) ServiceLocator.getInstance().getProxy(jndi);
				 }
				 return remote;
				

		}
			public static void persistSurvey(SurveyProposition prop)
			{
				getProxy().persistSurveyProposition(prop);
			}
			public static void updateSurvey(SurveyProposition prop)
			{
				getProxy().updateSurveyProposition(prop);
			}
			public static void removeSurvey(SurveyProposition prop)
			{
				getProxy().removeSurveyProposition(prop);
			}
			public static SurveyProposition findByIdSurveyProposition(Integer id)
			{
				return getProxy().findByIdSurveyProposition(id);
			}
			public static Integer ChartNbrePropbyQst()
			{
				return getProxy().ChartNbrePropbyQst();
			}
			public static List<SurveyProposition> findPropositionByQuestion(SurveyQst q)
			{
				return getProxy().findPropositionByIDQuestion(q);
			}
			
			public static List<SurveyProposition> findAllProposition()
			{
				return getProxy().findAllProposition();
			}
		}


