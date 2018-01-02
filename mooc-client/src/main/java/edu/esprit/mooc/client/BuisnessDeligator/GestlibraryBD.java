package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import edu.esprit.mooc.client.ServiceLocator.ServiceLocator;
import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.Tags;
import edu.esprit.mooc.services.SessionBean.GestiontagsSBRemote;


public class GestlibraryBD {
	
	
private static final String jndiname="/mooc-ejb/tagssb!edu.esprit.mooc.services.SessionBean.GestiontagsSBRemote";
	
	
	private static  GestiontagsSBRemote getProxy()
	{
		
	return (GestiontagsSBRemote)ServiceLocator.getInstance().getProxy(jndiname);
		
	}
	
	public static List<Tags> getAlltagscourse( String nom_tags)
	{
		return getProxy().getAllCourseTag(nom_tags);
				
	}
	
	

}
