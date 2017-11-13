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
    public ArrayList<Booking> bookings = new ArrayList<Booking>();
    public ArrayList<Booking> request = new ArrayList<Booking>();
    
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
    public void addRequest(Booking e)
    {
        request.add(e);
    }
    public void RemoveRequest(Booking e)
    {
        for ( int i=0; i<request.size(); i++ )
        {
            if ( request.get(i).getDate().equals(e.getDate()) )
            {
                if ( request.get(i).getTime().equals(e.getTime()) )
                {
                    if ( request.get(i).getRoomNo().equals(e.getRoomNo()) )
                    {
                        request.remove(i);
                    }
                }
            }
        }
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
    public void printRequests()
    {
        for ( int i=0; i<request.size(); i++ )
        {
            System.out.println(request.get(i));
        }
    }
}
