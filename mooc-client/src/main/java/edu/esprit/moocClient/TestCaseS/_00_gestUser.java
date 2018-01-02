package edu.esprit.moocClient.TestCaseS;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Test;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.GestionUserSbRemote;



public class _00_gestUser {

	@Test
	public void test() {


		 
		try {
			Context ctx=new InitialContext();
			
			GestionUserSbRemote gestion=(GestionUserSbRemote) ctx.lookup("/mooc-ejb/usersb!"+GestionUserSbRemote.class.getCanonicalName());
			
			
			
			User user=new User();
			user.setEmail("jaw@live.fr");
			user.setMdp("root");
			user.setNom_user("jawaher");
			user.setPrenom_user("bouzazi");
			 gestion.persistUser(user);
			User user2=new User();
			user2.setEmail("jaw@live.fr");
			user2.setMdp("ay");
			user2.setNom_user("agg");
			user2.setPrenom_user("asc");
			gestion.persistUser(user2);
		
			
		    //gestion.send_messgae(gestion.findUserById(1), gestion.findUserById(2), "welcome everyone");
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
