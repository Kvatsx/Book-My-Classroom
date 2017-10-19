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
public class Course implements Serializable {
    private final String Name;
    private Faculty faculty;
    private ArrayList<String> Timings;
    private ArrayList<Room> rooms;
    private ArrayList<Course> PreConditions;
    private ArrayList<Course> PostConditions;
    
    public Course(String name, Faculty f)
    {
        this.Name = name;
        this.faculty = f;
        this.Timings = new ArrayList<String>(7);
        this.rooms = new ArrayList<Room>(7);
        this.PreConditions = new ArrayList<Course>();
        this.PostConditions = new ArrayList<Course>();
    }
    public String getName()
    {
        return this.Name;
    }
    public String getFaculty()
    {
        return this.faculty.getName();
    }
    // This method add Course details in its own timetable.
    public void addTiming(int day, String time, Room room)
    {
        Timings.add(day, time);
        rooms.add(day, room);
    }
    public void addPrecondition(Course c)
    {
        PreConditions.add(c);
    }
    public void addPostCondition(Course c)
    {
        PostConditions.add(c);
    }
}
