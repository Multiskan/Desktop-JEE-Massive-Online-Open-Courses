package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Request;



import edu.esprit.mooc.domain.Entity.Message;
import edu.esprit.mooc.domain.Entity.User;

@Remote
public interface UserEJBRemote {
	
		//dayna
		public Boolean adduser(User user);
		public Boolean deleteuser(User user);
	 	public Boolean updateuser(User user);
	 	public List<User> getAlluser();
	 	public int countallusers();
	 	public User finduserById(Integer iduser);
	 	public List<User> getuserwithreqest();
		 public List<Request> getacceptedreqest();
		 public int countallrequests();
		 public int countacceptedreq();
	 
	 
	 	
	

}
