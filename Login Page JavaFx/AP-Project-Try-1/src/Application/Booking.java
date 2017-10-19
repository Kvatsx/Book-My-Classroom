/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.*;
/**
 *
 * @author Kaustav Vats (2016048)
 */
public class Booking implements Serializable {
    private final Room room;
    private final double Start;
    private final double End;
    private final String Date;
    
    public Booking(Room r, double s, double e, String d)
    {
        this.room = r;
        this.Start = s;
        this.End = e;
        this.Date = d;
    }
    public Room getRoom()
    {
        return this.room;
    }
    public double getStartTime()
    {
        return this.Start;
    }
    public double getEndTime()
    {
        return this.End;
    }
    public int getDay()
    {
        String day = Date.substring(0, 2);
        return Integer.parseInt(day);
    }
    public int getMonth()
    {
        String month = Date.substring(3, 5);
        return Integer.parseInt(month);
    }
    public int getYear()
    {
        String year = Date.substring(6, 10);
        return Integer.parseInt(year);
    }
}
