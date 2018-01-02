package edu.esprit.moocClient.TestCaseS;
import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.domain.Entity.SurveyQst;
import edu.esprit.mooc.services.SessionBean.GestionSurveyQstSBRemote;
import edu.esprit.mooc.services.SessionBean.GestionSurveySBRemote;

public class _01_gestSurveyQst {

	@Test
	public void test() {
		try {
			Context ctx = new InitialContext();
			GestionSurveyQstSBRemote gest = (GestionSurveyQstSBRemote) ctx.lookup("/mooc-ejb/SurveyQstSb!"+ GestionSurveyQstSBRemote.class.getCanonicalName());
			GestionSurveySBRemote gestionSurvey = (GestionSurveySBRemote) ctx.lookup("/mooc-ejb/SurveySb!"+ GestionSurveySBRemote.class.getCanonicalName());

        SurveyQst Qst = new SurveyQst();
    Survey s = gestionSurvey.findByIdSurvey(2);
        Qst.setQuestion("what type of courses would u like?");
        Qst.setNbrProposition(3);
        Qst.setSurvey(s);
     
        gest.persistSurveyQst(Qst);
        
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
