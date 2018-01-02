package edu.esprit.mooc.client.BuisnessDeligator;

import java.util.List;

import edu.esprit.mooc.domain.Entity.Course;
import edu.esprit.mooc.services.SessionBean.CourseEJBRemote;
import edu.esprit.mooc.client.ServiceLocator.ServiceLocator;


public class ManageCourseDelegate {
	
	public static CourseEJBRemote remote;
	public static final String jndi = "/mooc-ejb/CourseEJB!edu.esprit.mooc.services.SessionBean.CourseEJBRemote" ;
	
	private static CourseEJBRemote getProxy() {
		return (CourseEJBRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public Boolean addCourse(Course course) {
		return getProxy().addCourse(course);
	}

	public Boolean deleteCourse(Course course) {
		return getProxy().deletecourse(course);
	}

	public Boolean updateCourse(Course course) {
		return getProxy().updateCourse(course);
	}

	public List<Course> getAllCourses() {
		return getProxy().getAllcourses();
	}
	public List<Course> getpendingCourses() {
		return getProxy().getpendingcourses();
	}
	
	public List<Course> getacceptedCourses() {
		return getProxy().getacceptedcourses();
	}
	public List<Course> getrefusedCourses() {
		return getProxy().getrefusedcourses();
	}

	public Course findCourseById(Integer idCourse) {
		return getProxy().findCourseById(idCourse);
	}
	
	public int countpendingcourses(){
		return getProxy().countpendingcourses();
	} 	
	public int countacceptedcourses(){
		return getProxy().countacceptedcourses();
	} 
	public int countrefusedcourses(){
		return getProxy().countrefusedcourses();
	} 
	public int countallcourses(){
		return getProxy().countalldcourses();
	} 	
}
