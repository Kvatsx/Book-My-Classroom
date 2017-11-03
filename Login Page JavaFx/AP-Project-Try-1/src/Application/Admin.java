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
public class Admin extends User{
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    public Admin(String name, String id, String pw)
    {
        super(name,id,pw);
    }
    @Override
    public void BookRoom(Booking booking)
    {
        // Need to implement.
    }
    
    @Override
    public void CancelRoomBooking(String roomno, String date)
    {
        // Need to implement.
    }
    public void addBooking(Booking e)
    {
        bookings.add(e);
    }
    public boolean SearchBooking(String r, String d, String t)
    {
//        for
        return true;
    }
}
