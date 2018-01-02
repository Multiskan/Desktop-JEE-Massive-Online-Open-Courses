package edu.esprit.moocClient.TestCaseS;

import static org.junit.Assert.*;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.engine.query.spi.*;
import org.hibernate.hql.internal.*;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.hibernate.jpa.*;

import org.junit.Test;

import edu.esprit.mooc.domain.Entity.Survey;
import edu.esprit.mooc.services.SessionBean.GestionSurveySBRemote;

public class _00_gestSurvey {

	@Test
	public void test() {
		
		try {
			Context ctx = new InitialContext();
			GestionSurveySBRemote gest = (GestionSurveySBRemote) ctx.lookup("/mooc-ejb/SurveySb!"+ GestionSurveySBRemote.class.getCanonicalName());

//***********ajout**************		
//        Survey s = new Survey();
//        s.setNbrQst(2);
//        s.setNomSurvey("coursesSurvey");
//        
//        gest.persistSurvey(s);
			
//***********modification**********			
//			Survey s = gest.findByIdSurvey(1);
//			s.setNbrQst("7");
//			gest.updateSurvey(s);
			
//***********delete************		
//			Survey s = gest.findByIdSurvey(1);
//			gest.removeSurvey(s);
			
//************Affichage***************			
//		Survey s = gest.findByIdSurvey(1);
//		System.out.println(s.getId()+" " + s.getNbrQst()+" "+s.getNomSurvey() );

//************test qui renvoie dernier survey***********
//		try{	
//		Survey s =gest.findLatesSurvey();
//		System.out.println(s);
//		
//		}catch (QuerySyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
//*************fin test**********	
			
//*****************affichage d'une list******

			
			
			
			
//			if(Lsurvey!=null){
//				System.out.println("OK find");
//			}
//			else
//				System.out.println("liste vide");

		

		
			   
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
