package edu.esprit.moocClient.TestCaseS;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyProposition;
import edu.esprit.mooc.domain.Entity.SurveyQst;
import edu.esprit.mooc.services.SessionBean.GestionSurveyPropositionSBRemote;
import edu.esprit.mooc.services.SessionBean.GestionSurveyQstSBRemote;


public class _02_gestSurveyProposition {

	@Test
	public void test() {

		try {
			Context ctx = new InitialContext();
			GestionSurveyPropositionSBRemote gest = (GestionSurveyPropositionSBRemote) ctx.lookup("/mooc-ejb/SurveyPropositionSb!"+ GestionSurveyPropositionSBRemote.class.getCanonicalName());
			GestionSurveyQstSBRemote ges = (GestionSurveyQstSBRemote) ctx.lookup("/mooc-ejb/SurveyQstSb!"+ GestionSurveyQstSBRemote.class.getCanonicalName());
			
			SurveyProposition prop = new SurveyProposition();
			SurveyQst Q = ges.findByIdSurveyQst(2);
	        prop.setProposition("not helpful");
	        prop.setSurvQst(Q);
	        prop.setNbrReponse(10);
	        
	        gest.persistSurveyProposition(prop);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
