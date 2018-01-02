package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;


import edu.esprit.mooc.domain.Entity.Request;
import edu.esprit.mooc.domain.Entity.User;
import edu.esprit.mooc.services.SessionBean.UserEJBRemote;
import edu.esprit.mooc.client.ServiceLocator.ServiceLocator;


public class ManageUserDelegate {
	public static UserEJBRemote remote;
	public static final String jndi = "/mooc-ejb/UserEJB!edu.esprit.mooc.services.SessionBean.UserEJBRemote" ;
	                          
	private static UserEJBRemote getProxy() {
		return (UserEJBRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public Boolean adduser(User user) {
		return getProxy().adduser(user);
	}

	public Boolean deleteuser(User user) {
		return getProxy().deleteuser(user);
	}

	public Boolean updateuser(User user) {
		return getProxy().updateuser(user);
	}

	public List<User> getAlluser(){
		return getProxy().getAlluser();
	}
	
	

	public User findusereById(Integer iduser) {
		return getProxy().finduserById(iduser);
	}
	
	public int countallusers(){
		return getProxy().countallusers();
	}
	public List<User>getuserwithrequest(){
		return getProxy().getuserwithreqest();
	}
	public List<Request>getacceptedrequest(){
		return getProxy().getacceptedreqest();
	}
	public int countallreq(){
		return getProxy().countallrequests();
	}
	public int countacceptedreq(){
		return getProxy().countacceptedreq();
	}
}
