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
    private Room room;
    private String time;
    private String Date;
    
    public Booking(Room r, String t, String d)
    {
        this.room = r;
        this.time = t;
        this.Date = d;
    }
    public Room getRoom()
    {
        return this.room;
    }
    public String getTime()
    {
        return this.time;
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
