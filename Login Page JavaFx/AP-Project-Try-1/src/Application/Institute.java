/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.*;
import java.util.*;
import MyExceptions.*;
import ap.project.pkgtry.pkg1.*;
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
    public void addUser(User e)
    {
        users.add(e);
    }
    public User getUser(int i)
    {
        return users.get(i);
    }
    public boolean isStudent(User e)
    {
        if ( e.getClass().getName().equals("Student") )
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
        if ( e.getClass().getName().equals("Faculty") )
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
        if ( e.getClass().getName().equals("Admin") )
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
