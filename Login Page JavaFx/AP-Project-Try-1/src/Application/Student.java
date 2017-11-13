/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.ArrayList;

/**
 *
 * @author Kaustav Vats (2016048)
 */
public class Student extends User {
    private TimeTable mytimetable;
    private ArrayList<Booking> bookings;
    
    public Student(String name, String id, String pw)
    {
        super(name,id,pw);
        mytimetable = null;
        bookings = new ArrayList<Booking>();
    }
    
    public void addTimeTable(TimeTable tt)
    {
        this.mytimetable = tt;
    }
    public ArrayList<Booking> getbookings()
    {
        return this.bookings;
    }
    public TimeTable getTimeTable()
    {
        return this.mytimetable;
    }
    public ArrayList<Course> getCourses()
    {
        return mytimetable.getCourse();
    }
    @Override
    public void BookRoom(Booking booking)
    {
        // Need to implement.
        bookings.add(booking);
    }
    
    @Override
    public void CancelRoomBooking(String roomno, String date)
    {
        // Need to implement.
    }
    
    public void addCourse(Course c)
    {
        mytimetable.addCourse(c);
    }
    public boolean isNewCourse(Course c)
    {
        ArrayList<Course> a = mytimetable.getCourse();
        for ( int i=0; i<a.size(); i++ )
        {
            if ( a.get(i).getName().equals(c.getName()) )
            {
                return false;
            }
        }
        return true;
    }
    public void RemoveRequest(Booking e)
    {
        for ( int i=0; i<bookings.size(); i++ )
        {
            if ( bookings.get(i).getDate().equals(e.getDate()) )
            {
                if ( bookings.get(i).getTime().equals(e.getTime()) )
                {
                    if ( bookings.get(i).getRoomNo().equals(e.getRoomNo()) )
                    {
                        bookings.remove(i);
                    }
                }
            }
        }
    }
}
