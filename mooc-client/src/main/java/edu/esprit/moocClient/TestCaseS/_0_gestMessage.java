package edu.esprit.moocClient.TestCaseS;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Test;

import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.GestionMessageSbRemote;
import edu.esprit.mooc.services.SessionBean.GestionUserSbRemote;

public class _0_gestMessage {

	@Test
	public void test() {



		 
		try {
			Context ctx=new InitialContext();
			
			GestionMessageSbRemote gestion=(GestionMessageSbRemote) ctx.lookup("/mooc-ejb/messagesb!"+GestionMessageSbRemote.class.getCanonicalName());
			GestionUserSbRemote ges=(GestionUserSbRemote) ctx.lookup("/mooc-ejb/usersb!"+GestionUserSbRemote.class.getCanonicalName());
			
		
			
			
		//	gestion.persistMessage(message);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
		
		
	}

