/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.Serializable;

/**
 *
 * @author Kaustav Vats (2016048)
 */
public abstract class User implements Serializable {
    private final String Name;
    private final String Id;
    private final String Password;
    
    public User(String name, String id, String pw)
    {
        this.Name = name;
        this.Id = id;
        this.Password = pw;
    }
    public String getName()
    {
        return this.Name;
    }
    public String getId()
    {
        return this.Id;
    }
    @Override
    public String toString()
    {
        return this.Name+" "+this.Id;
    }
    public boolean Validate(String id, String pw)
    {
        if ( this.Id.equals(id) )
        {
            if ( this.Password.equals(pw) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    public boolean ViewRoomAvailable(int cap, double start, double end, String date)
    {
        // Need to implement.
        return false;
    }
    public abstract void BookRoom(Booking booking);
    
    public abstract void CancelRoomBooking(String roomno, String date);
}
