package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import edu.esprit.mooc.client.ServiceLocator.ServiceLocator;
import edu.esprit.mooc.domain.Entity.Message;

import edu.esprit.mooc.domain.Entity.Respond;
import edu.esprit.mooc.services.SessionBean.GestionMessageSbRemote;

public class GestMessageBD {

	
private static final String jndiname="/mooc-ejb/messagesb!edu.esprit.mooc.services.SessionBean.GestionMessageSbRemote";
	
	
	private static  GestionMessageSbRemote getProxy()
	{
		
	return (GestionMessageSbRemote)ServiceLocator.getInstance().getProxy(jndiname);
		
	}
	
	
	public static List<Message> getAllMessage( int id_reciever)
	{
		return getProxy().getAllMessage(id_reciever);
				
	}
	
	public static List<Message> getAllsendMessage( int id_sender)
	{
		return getProxy().getAllsendMessage(id_sender);
				
	}
	
	
	public static int getAllnumberMessage( int id_receiver)
	{
		return getProxy().getAllnumberMessage(id_receiver).size();
	}
	
	
	public static void removeMessage(int id)
	{
		Message msg = new Message();
		msg=getProxy().findMessageById(id);
		getProxy().removeMessage(msg);
	}
	
	
	public static void Respond(Respond res)
	{
		Message message=getProxy().findMessageById(1);
		
		
		getProxy().RespondMessage(message, res);
		
		
	}
	
	
}
