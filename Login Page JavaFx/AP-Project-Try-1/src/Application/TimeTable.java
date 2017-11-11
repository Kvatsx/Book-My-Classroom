/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Kaustav Vats (2016048)
 */
public class TimeTable implements Serializable {
    private ArrayList<Course> Courses;
    
    public TimeTable()
    {
        this.Courses = new ArrayList<Course>();
    }
    public void addCourse(Course c)
    {
        Courses.add(c);
    }
    public ArrayList<Course> getCourse()
    {
        return this.Courses;
    }
    public boolean Search()
    {
        // Need to implement to search for a course on basis of time or classrooom.
        return false;
    }
}
