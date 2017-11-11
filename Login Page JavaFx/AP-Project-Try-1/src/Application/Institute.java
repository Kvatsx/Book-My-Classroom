/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.*;
import java.util.*;
import MyExceptions.*;
/**
 *
 * @author Kaustav Vats (2016048)
 */
public class Institute implements Serializable {
    private final Admin admin;
    private ArrayList<User> users;
    private ArrayList<Course> courses;
    private ArrayList<Room> rooms;
    
    public Institute(Admin admin)
    {
        this.admin = admin;
        this.users = new ArrayList<User>();
        this.courses = new ArrayList<Course>();
        this.rooms = new ArrayList<Room>();
    }
    public Admin getAdmin()
    {
        return this.admin;
    }
    public void PrintCourses()
    {
        System.out.println("Printing all Courses");
        for (Course course : courses) {
            if ( course != null )
            {
                System.out.println(course.getCode()+" "+course.getName());
            }
        }
        System.out.println("Done");
    }
    public ArrayList<Course> getCourses()
    {
        return this.courses;
    }
    public void addUser(User e)
    {
        users.add(e);
    }
    public User getUser(int i)
    {
        return users.get(i);
    }
    public User getUser(String id)
    {
        for ( int i=0; i<users.size(); i++ )
        {
            if ( users.get(i).getId().equals(id) )
            {
                return users.get(i);
            }
        }
        System.out.println("User not Found with this id: " + id + ", Null");
        return null;
    }
    public boolean isStudent(User e)
    {
//        System.out.println(e.getClass().getName().equals("Application.Student")+" "+e.getClass().getName());
        if ( e.getClass().getName().equals("Application.Student") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isFaculty(User e)
    {
        if ( e.getClass().getName().equals("Application.Faculty") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isAdmin(User e)
    {
        if ( e.getClass().getName().equals("Application.Admin") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void ShowUser()
    {
        for ( int i=0; i<users.size(); i++ )
        {
            System.out.print(users.get(i));
            System.out.println(" "+users.get(i).getClass().getName());
        }
    }
    public void addRoom(Room e)
    {
        rooms.add(e);
    }
    public void addCourse(Course e)
    {
        courses.add(e);
    }
    public Course SearchCourse(String name)
    {
        for ( int i=0; i<courses.size(); i++ )
        {
//            System.out.println("code: "+courses.get(i).getCode()+" Parameter "+code);
            if ( courses.get(i).getName().equals(name) )
            {
                return courses.get(i);
            }
        }
        return null;
    }
    public Room SearchRoom(String roomno)
    {
        for ( int i=0; i<rooms.size(); i++ )
        {
            if ( rooms.get(i).getRoomNo().equals(roomno) )
            {
                return rooms.get(i);
            }
        }
        return null;
    }
    public int Validate_Login(String id, String pw) throws WrongCredentials
    {
        int index = -1;
        for ( int i=0; i<users.size(); i++ )
        {
            if ( users.get(i).Validate(id, pw) )
            {
                index = i;
                break;
            }
        }
        if ( index == -1 )
        {
            throw new WrongCredentials("Login failed wrong user credentials, Please enter valid Login Id & Password");
        }
        return index;
    }
    public boolean Validate_Signup(String id) throws UserAlreadyExists
    {
        boolean Flag = true;
        for ( int i=0; i<users.size(); i++ )
        {
            if ( users.get(i).getId().equals(id) )
            {
                Flag = false;
                break;
            }
        }
        if ( !Flag )
        {
            throw new UserAlreadyExists("An Account already exists with this email id.");
        }
        return Flag;
    }
    
    public static void main(String[] args) {
        
    }
}
