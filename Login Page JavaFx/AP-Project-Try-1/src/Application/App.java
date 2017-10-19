/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.*;
import java.io.*;
/**
 *
 * @author Kaustav Vats (2016048)
 */
public class App {
    
    public App()
    {
        // Empty Contructor.
    }
    public void serialize(Institute iiitd) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\kaust\\Documents\\NetBeansProjects\\AP-Project-Try-1\\src\\Data\\InstituteClassData.txt"));
            out.writeObject(iiitd);
        }
        finally {
            out.close();
        }
    }
    public Institute deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("C:\\Users\\kaust\\Documents\\NetBeansProjects\\AP-Project-Try-1\\src\\Data\\InstituteClassData.txt"));
            Institute iiitd = (Institute) in.readObject();
            return iiitd;
        }
        finally {
            in.close();
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        App app = new App();
        Admin admin = new Admin("Kaustav Vats", "kaustav@iiitd.ac.in","vats");
        Institute IIITD = new Institute(admin);
        IIITD.addUser(admin);
        IIITD.addUser(new Student("Ishaan","ishaan@iiitd.ac.in","ishaanbassi"));
        IIITD.addUser(new Faculty("Bhand","abhi@iiitd.ac.in","bhand"));
        app.serialize(IIITD);
    }
}
