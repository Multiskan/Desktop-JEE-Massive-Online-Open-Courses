package edu.esprit.mooc.services.SessionBean;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.mooc.domain.Entity.Course;

@Remote
public interface CourseEJBRemote {
	
	public Boolean addCourse(Course course) ;   
 	 public Boolean deletecourse(Course course) ;
    public Boolean updateCourse(Course course);
	 public List<Course> getAllcourses(); 
    public Course findCourseById(Integer idCourse);
    public List<Course> getpendingcourses();
    public List<Course> getacceptedcourses();
    public List<Course> getrefusedcourses();
    public int countpendingcourses();
    public int countalldcourses();
    public int countrefusedcourses();
    public int countacceptedcourses();
}
