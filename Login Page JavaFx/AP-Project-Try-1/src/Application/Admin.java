/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author Kaustav Vats (2016048)
 */
public class Admin extends User{
    
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
}
