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
public class Room implements Serializable {
    private final String RoomNo;
    private final int Capacity;
    private boolean Status; //Gives Status of room, if True ---> Room Booked, else Available.
    
    public Room(String room, int cap)
    {
        this.RoomNo = room;
        this.Capacity = cap;
        this.Status = false;
    }
    public void Book()
    {
        this.Status = true;
    }
    public String getRoomNo()
    {
        return this.RoomNo;
    }
    public boolean getStatus()
    {
        return this.Status;
    }
    public int getCapacity()
    {
        return this.Capacity;
    }
}
