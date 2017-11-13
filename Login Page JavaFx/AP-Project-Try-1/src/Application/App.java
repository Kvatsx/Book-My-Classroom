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
    public static void serialize(Institute iiitd) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\kaust\\Documents\\NetBeansProjects\\AP-Project-Try-1\\src\\Data\\InstituteClassData.txt"));
            out.writeObject(iiitd);
        }
        finally {
            out.close();
        }
    }
    public static Institute deserialize() throws IOException, ClassNotFoundException {
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
    
    public static ArrayList<String[]> makett()
    {
        String csvFile = "C:\\Users\\kaust\\Documents\\NetBeansProjects\\AP-Project-Try-1\\src\\Data\\timetable.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        ArrayList<String[]> myArr = new ArrayList<String[]>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] courseD = line.split(cvsSplitBy);
                myArr.add(courseD);
//                System.out.println("Course Name: "+courseD[1]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return myArr;
    }
    public void UpdateRoomTimings() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        ArrayList<String[]> Arr = App.makett();
        iiitd.printRooms();
        for (int i=1; i<Arr.size(); i++) 
        {
            String[] e = Arr.get(i);
            System.out.println("Course Name: "+e[1]);
//            System.out.println(e[6]);
            if ( e[6].length() > 3 )
            {
                String[] tmp = e[6].split("\\$");
                System.out.println(tmp[0]+" "+tmp[1]);
                Room r = iiitd.SearchRoom(tmp[1]);
                r.addBooking("Always"+"\t"+"Monday"+"\t"+tmp[0]);
            }
            if ( e[7].length() > 3 )
            {
                String[] tmp = e[7].split("\\$");
                System.out.println(tmp[0]+" "+tmp[1]);
                Room r = iiitd.SearchRoom(tmp[1]);
                r.addBooking("Always"+"\t"+"Tuesday"+"\t"+tmp[0]);
            }
            if ( e[8].length() > 3 )
            {
                String[] tmp = e[8].split("\\$");
                System.out.println(tmp[0]+" "+tmp[1]);
                Room r = iiitd.SearchRoom(tmp[1]);
                r.addBooking("Always"+"\t"+"Wednesday"+"\t"+tmp[0]);
            }
            if ( e[9].length() > 3 )
            {
                String[] tmp = e[9].split("\\$");
                System.out.println(tmp[0]+" "+tmp[1]);
                Room r = iiitd.SearchRoom(tmp[1]);
                r.addBooking("Always"+"\t"+"Thursday"+"\t"+tmp[0]);
            }
            if ( e[10].length() > 3 )
            {
                String[] tmp = e[10].split("\\$");
                System.out.println(tmp[0]+" "+tmp[1]);
                Room r = iiitd.SearchRoom(tmp[1]);
                r.addBooking("Always"+"\t"+"Friday"+"\t"+tmp[0]);
            }
        }
        App.serialize(iiitd);
    }
    
    public void allCourse() throws IOException, ClassNotFoundException
    {
        System.out.println("Testing All courses");
        Institute iiitd = App.deserialize();
        String csvFile = "C:\\Users\\kaust\\Documents\\NetBeansProjects\\AP-Project-Try-1\\src\\Data\\course.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        
        ArrayList<String[]> myArr = new ArrayList<String[]>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] courseD = line.split(cvsSplitBy,-1);
                myArr.add(courseD);
//                System.out.println("String length = "+courseD.length);
                Course c = new Course(courseD[0],courseD[1],courseD[2]);
//                System.out.println(courseD[0]+" "+courseD[1]+" "+courseD[2]);
                
//                System.out.println(courseD[3]);
//                System.out.println(courseD[4]);
//                System.out.println(courseD[5]);
//                System.out.println(courseD[6]);
//                System.out.println(courseD[7]);
//                System.out.println(courseD[8]);
//                System.out.println(courseD[9]);
//                System.out.println(courseD[10]);
                
                c.addPostCondition(courseD[3]);
                c.addPostCondition(courseD[4]);
                c.addPostCondition(courseD[5]);
                c.addPostCondition(courseD[6]);
                c.addPostCondition(courseD[7]);
                c.addPostCondition(courseD[8]);
                c.addPostCondition(courseD[9]);
                c.addPostCondition(courseD[10]);
                iiitd.addCourse(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        App.serialize(iiitd);
//        return myArr;
    }
    public void makeRooms() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        iiitd.addRoom(new Room("C01",300));
        iiitd.addRoom(new Room("C02",60));
        iiitd.addRoom(new Room("C03",60));
        
        iiitd.addRoom(new Room("C11",300));
        iiitd.addRoom(new Room("C12",60));
        iiitd.addRoom(new Room("C13",60));
        
        iiitd.addRoom(new Room("C21",300));
        iiitd.addRoom(new Room("C22",60));
        iiitd.addRoom(new Room("C23",60));
        iiitd.addRoom(new Room("C24",60));
        
        App.serialize(iiitd);
    }
    
    public void addtimingsinCourses() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        
        ArrayList<String[]> Arr = App.makett();
//        System.out.println("Make Time Table called and Worked fine.");
        
//        iiitd.PrintCourses();
        
        for ( int i=1; i<Arr.size(); i++ )
        {
            String[] Brr = Arr.get(i);
//            elements.add(i-1, Brr[0]+"\n"+"Course Name: "+Brr[1]+"\n"+"Course Code: "+Brr[2]+"\n"+"Instructor: "+Brr[3]+"\n"+"Credits: "+Brr[4]+"\n"+"Acronym: "+Brr[5]+"\n"+"Monday Time: "+Brr[6]+"\n"+"Tuesday Time: "+Brr[7]+"\n"+"Wednesday Time: "+Brr[8]+"\n"+"Thursday Time: "+Brr[9]+"\n"+"Friday Time: "+Brr[10]+"\n"+"\n");
//            System.out.println(Brr[1]);
            Course c = iiitd.SearchCourse(Brr[1]);
//            System.out.println("Type of Courses "+Brr[0]);
            c.setType(Brr[0]);
            c.setAcronym(Brr[5]);
            c.setCredit(Brr[4]);
//            System.out.println("Brr[2] "+Brr[2]);
//            System.out.println("Course Mil gaya "+c.getCode());
            if ( Brr[6].length() > 4 )
            {
                String[] tmp = Brr[6].split("\\$");
//                Room mon = iiitd.SearchRoom(tmp[1]);
                c.addTiming(0, tmp[0], tmp[1]);
//                System.out.println(tmp[0]);
            }
            if ( Brr[7].length() > 4 )
            {
                String[] tmp = Brr[7].split("\\$");
//                Room tue = iiitd.SearchRoom(tmp[1]);
                c.addTiming(1, tmp[0], tmp[1]);
            }
            if ( Brr[8].length() > 4 )
            {
                String[] tmp = Brr[8].split("\\$");
//                Room wed = iiitd.SearchRoom(tmp[1]);
                c.addTiming(2, tmp[0], tmp[1]);
            }
            if ( Brr[9].length() > 4 )
            {
                String[] tmp = Brr[9].split("\\$");
//                Room thur = iiitd.SearchRoom(tmp[1]);
                c.addTiming(3, tmp[0], tmp[1]);
            }
            if ( Brr[10].length() > 4 )
            {
                String[] tmp = Brr[10].split("\\$");
//                Room fri = iiitd.SearchRoom(tmp[1]);
                c.addTiming(4, tmp[0], tmp[1]);
            }
            
//            iiitd.addCourse(c);
        }
        App.serialize(iiitd);
    }
    public void makeStudent() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Student student = (Student)iiitd.getUser("s@iiitd.ac.in");
        TimeTable tt = new TimeTable();
        tt.addCourse(iiitd.SearchCourse("Advanced Programming"));
        tt.addCourse(iiitd.SearchCourse("Discrete Mathematics"));
        tt.addCourse(iiitd.SearchCourse("Computer Organization"));
        tt.addCourse(iiitd.SearchCourse("Maths-III"));
        tt.addCourse(iiitd.SearchCourse("Introduction to Psychology"));
        student.addTimeTable(tt);
        App.serialize(iiitd);
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("My App Main method called");
        App app = new App();
        Admin admin = new Admin("Kaustav Vats", "kaustav@iiitd.ac.in","vats");
        Institute IIITD = new Institute(admin);
        IIITD.addUser(admin);
        IIITD.addUser(new Student("Ishaan","ishaan@iiitd.ac.in","ishaanbassi"));
        IIITD.addUser(new Faculty("Bhand","abhi@iiitd.ac.in","bhand"));
        IIITD.addUser(new Student("Student Testing","s@iiitd.ac.in","s"));
        IIITD.addUser(new Faculty("Faculty Testing","f@iiitd.ac.in","f"));
        IIITD.addUser(new Admin("Admin Testing","a@iiitd.ac.in","a"));
        app.serialize(IIITD);
        System.out.println("Serialize Done on 13/11/17 09:26PM");
        app.makeRooms();
        app.allCourse();
        app.addtimingsinCourses();
        app.makeStudent();
        app.UpdateRoomTimings();
    }
}
