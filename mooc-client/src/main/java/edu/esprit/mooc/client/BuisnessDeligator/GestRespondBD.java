package edu.esprit.mooc.client.BuisnessDeligator;

import edu.esprit.mooc.client.ServiceLocator.ServiceLocator;
import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.GestionRespondSbRemote;


public class GestRespondBD {
	
	
	
private static final String jndiname="/mooc-ejb/respondsb!edu.esprit.mooc.services.SessionBean.GestionRespondSbRemote";
	
	
	private static  GestionRespondSbRemote getProxy()
	{
		
	return (GestionRespondSbRemote)ServiceLocator.getInstance().getProxy(jndiname);
		
	}
	
	
	
	
	

}
