package edu.esprit.mooc.client.BuisnessDeligator;
import java.util.List;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.client.BuisnessDeligator.*;
import edu.esprit.mooc.client.ServiceLocator.ServiceLocator;
import edu.esprit.mooc.services.SessionBean.GestionSurveySBRemote;




public class SurveyDelegater {
	private static final String jndi="/mooc-ejb/SurveySb!edu.esprit.mooc.services.SessionBean.GestionSurveySBRemote";

	private static GestionSurveySBRemote getProxy(){
		GestionSurveySBRemote remote=null;
		 if(remote==null){
	     remote=(GestionSurveySBRemote) ServiceLocator.getInstance().getProxy(jndi);
		 }
		 return remote;
		

}
	public static void persistSurvey(Survey s)
	{
		getProxy().persistSurvey( s);
	}
	public static void updateSurvey(Survey s)
	{
		getProxy().updateSurvey( s);
	}
	public static void removeSurvey(Survey s)
	{
		getProxy().removeSurvey( s);
	}
	public static Survey findByIdSurvey(Integer id)
	{
		return getProxy().findByIdSurvey(id);
	}
	public static List<Survey> findAllSurveys()
	{
		return getProxy().findAllSurveys();
	}
	
	public static Survey findLastsurvey()
	{
		return getProxy().findLatesSurvey();
	}
	
}
