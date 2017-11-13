/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLs;

import Application.*;
import static XMLs.AdminController.currentStage;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author kaust
 */
public class StudentController implements Initializable {

    public static Student user;
    public static Stage currentStage;
    @FXML
    private Label user_name;
    @FXML
    private TextField Course_name;
    @FXML
    private ListView<String> current_course_list;
    @FXML
    private ListView<String> all_course;
    @FXML
    private Button logout;
    @FXML
    private ChoiceBox<String> room_menu;
    @FXML
    private DatePicker date;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private TextArea reason;
    @FXML
    private ListView<String> room_availability;
    @FXML
    private Button book_room;
    @FXML
    private Button add_course;
    @FXML
    private Button cancel_button;
    @FXML
    private TableView<Course> searchcoursetable;
//    @FXML
//    private TableColumn<ArrayList<Course, SimpleStringProperty> select;
    @FXML
    private TableColumn<Course, String> code;
    @FXML
    private TableColumn<Course, String> credit;
    @FXML
    private TableColumn<Course, String> coursename;
    @FXML
    private TableColumn<Course, String> instructorname;
    @FXML
    private TableColumn<Course, String> monday;
    @FXML
    private TableColumn<Course, String> tuesday;
    @FXML
    private TableColumn<Course, String> wednesday;
    @FXML
    private TableColumn<Course, String> thursday;
    @FXML
    private TableColumn<Course, String> friday;
    @FXML
    private HBox hbox1;
    @FXML
    private HBox hbox2;
    @FXML
    private HBox hbox3;
    @FXML
    private HBox hbox4;
    @FXML
    private HBox hbox5;
    @FXML
    private TableView<Booking> past_bookings;
    @FXML
    private TableColumn<Booking, String> room;
    @FXML
    private TableColumn<Booking, String> dates;
    @FXML
    private TableColumn<Booking, String> days;
    @FXML
    private TableColumn<Booking, String> datecol;
    @FXML
    private TableColumn<Booking, String> time;
    @FXML
    private TableColumn<Booking, String> reasoncol;
    @FXML
    private TableColumn<Booking, String> status;
    
    /**
     * Initializes the controller class.
     */    
    @FXML
    private void LogoutAction(ActionEvent event) throws IOException {
        System.out.println("Opening Login.fxml After Pressing Logout Button");
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        currentStage = LoginController.currentStage;
        Scene scene = new Scene(root);
        
        currentStage.setScene(scene);
//      stage.setResizable(false);
        currentStage.show();
    }
    // Search Button---> To search Available Room
    @FXML
    private void SearchButton(ActionEvent event) {
        System.out.println("Searching Available Room on this timings");
        
    }
    public void AvailableRoom() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        
    }
    @FXML
    public void add_course_button(ActionEvent event) throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Course c = searchcoursetable.getSelectionModel().getSelectedItem();
        System.out.println(c);
        if ( c == null )
        {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Error");
            a.setHeaderText("Course not selected");
            a.setResizable(false);
            String content = String.format("Please select a course from table, before clicking Add Course Button");
            a.setContentText(content);
            a.showAndWait();
        }
        else
        {
            Student u = (Student)iiitd.getUser(user.getId());
            u.addCourse(c);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Course Added");
            a.setHeaderText("Selected Course has been added to your profile.");
            a.setResizable(false);
            String content = String.format(c.toString());
            a.setContentText(content);
            a.showAndWait();
            UpdateTimeTable();
            App.serialize(iiitd);
            addItems();
        }
    }
    public void UpdateTimeTable() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Student u = (Student)iiitd.getUser(user.getId());
        TimeTable tt = u.getTimeTable();
        tt.UpdateDailyArrays();
//        ObservableList<String> elements = FXCollections.observableArrayList();
        
        Label monday = new Label("Monday");
        monday.setFont(new Font("Tahoma", 18));
        monday.setTextFill(Color.web("#3fada8"));
        monday.setMinWidth(105);
//        monday.setMaxWidth(40);
        hbox1.getChildren().add(monday);
        hbox1.setPadding(new Insets(1));
        
        Label tuesday = new Label("Tuesday");
        tuesday.setFont(new Font("Tahoma", 18));
        tuesday.setTextFill(Color.web("#3fada8"));
        tuesday.setMinWidth(105);
//        monday.setMaxWidth(40);
        hbox2.getChildren().add(tuesday);
        hbox2.setPadding(new Insets(1));
        
        Label wednesday = new Label("Wednesday");
        wednesday.setFont(new Font("Tahoma", 18));
        wednesday.setTextFill(Color.web("#3fada8"));
        wednesday.setMinWidth(105);
//        monday.setMaxWidth(40);
        hbox3.getChildren().add(wednesday);
        hbox3.setPadding(new Insets(1));
        
        Label thursday = new Label("Thursday");
        thursday.setFont(new Font("Tahoma", 18));
        thursday.setTextFill(Color.web("#3fada8"));
        thursday.setMinWidth(105);
//        monday.setMaxWidth(40);
        hbox4.getChildren().add(thursday);
        hbox4.setPadding(new Insets(1));
        
        Label friday = new Label("Friday");
        friday.setFont(new Font("Tahoma", 18));
        friday.setTextFill(Color.web("#3fada8"));
        friday.setMinWidth(105);
//        monday.setMaxWidth(40);
        hbox5.getChildren().add(friday);
        hbox5.setPadding(new Insets(1));
        
        String z1 = "Monday      --> ";
        for ( int i=0; i<tt.getMonday().size(); i++ )
        {
            Label tmp = new Label(tt.getMonday().get(i));
            tmp.setFont(new Font("Tahoma",16));
            tmp.setMinWidth(200);
            tmp.setWrapText(true);
            hbox1.getChildren().add(tmp);
            z1 += tt.getMonday().get(i);
        }
        
        String z2 = "Tuesday      --> ";
        for ( int i=0; i<tt.getTuesday().size(); i++ )
        {
            Label tmp = new Label(tt.getTuesday().get(i));
            tmp.setFont(new Font("Tahoma",16));
            tmp.setMinWidth(200);
            tmp.setWrapText(true);
            hbox2.getChildren().add(tmp);
            z2 += tt.getTuesday().get(i);
        }
        
        String z3 = "Wednesday --> ";
        for ( int i=0; i<tt.getWednesday().size(); i++ )
        {
            Label tmp = new Label(tt.getWednesday().get(i));
            tmp.setFont(new Font("Tahoma",16));
            tmp.setMinWidth(200);
            tmp.setWrapText(true);
            hbox3.getChildren().add(tmp);
            z3 += tt.getWednesday().get(i);
        }
        
        String z4 = "Thursday     --> ";
        for ( int i=0; i<tt.getThursday().size(); i++ )
        {
            Label tmp = new Label(tt.getThursday().get(i));
            tmp.setFont(new Font("Tahoma",16));
            tmp.setMinWidth(200);
            tmp.setWrapText(true);
            hbox4.getChildren().add(tmp);
            z4 += tt.getThursday().get(i);
        }
        
        String z5 = "Friday          --> ";
        for ( int i=0; i<tt.getFriday().size(); i++ )
        {
            Label tmp = new Label(tt.getFriday().get(i));
            tmp.setFont(new Font("Tahoma",16));
            tmp.setMinWidth(200);
            tmp.setWrapText(true);
            hbox5.getChildren().add(tmp);
            z5 += tt.getFriday().get(i);
        }
        
//        elements.add(z1);
//        elements.add(z2);
//        elements.add(z3);
//        elements.add(z4);
//        elements.add(z5);
//        mytimetable.setItems(elements);
    }
    public void UpdateTable(String newValue) throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Student u = (Student)iiitd.getUser(user.getId());
        ObservableList<Course> elements = FXCollections.observableArrayList();
        ArrayList<Course> c = iiitd.getCourses();
        if ( newValue.equals("") )
        {
            for ( int i=0; i<c.size(); i++ )
            {
                if ( u.isNewCourse(c.get(i)) )
                {
                    elements.add(c.get(i));  
                }
                ArrayList<String> newPC = c.get(i).getPostCondition();
//                System.out.println(newPC);
            }
        }
        else
        {
//            System.out.println("NewValue "+newValue);
            for ( int i=0; i<c.size(); i++ )
            {
                boolean Flag = false;
                ArrayList<String> newPC = c.get(i).getPostCondition();
                
                for ( int j=0; j<newPC.size(); j++ )
                {
                    String[] s = newPC.get(j).split(" ");
                    for ( int k=0; k<s.length; k++ )
                    {
                        if ( s[k].toLowerCase().equals(newValue) )
                        {
                            System.out.println(s[k].toLowerCase()+" "+newValue);
                            Flag = true;
                            break;
                        }
                    }
                    if ( Flag )
                    {
                        break;
                    }
                }
                if ( Flag & u.isNewCourse(c.get(i)))
                {
                    elements.add(c.get(i));
                }
            }
            System.out.println("All Items Added");
        }
        code.setCellValueFactory(new PropertyValueFactory<Course, String>("Code"));
        credit.setCellValueFactory(new PropertyValueFactory<Course, String>("Credit"));
        coursename.setCellValueFactory(new PropertyValueFactory<Course, String>("Name"));
        instructorname.setCellValueFactory(new PropertyValueFactory<Course, String>("faculty"));
        monday.setCellValueFactory(new PropertyValueFactory<Course, String>("Monday"));
        tuesday.setCellValueFactory(new PropertyValueFactory<Course, String>("Tuesday"));
        wednesday.setCellValueFactory(new PropertyValueFactory<Course, String>("Wednesday"));
        thursday.setCellValueFactory(new PropertyValueFactory<Course, String>("Thursday"));
        friday.setCellValueFactory(new PropertyValueFactory<Course, String>("Friday"));
        searchcoursetable.setItems(elements);
    }
    // My Courses
    public void addItems() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Student u = (Student)iiitd.getUser(user.getId());
        ObservableList<String> elements = FXCollections.observableArrayList();
        for ( int i=0; i<u.getCourses().size(); i++ )
        {
//            System.out.println(user.getCourses().get(i));
            elements.add(u.getCourses().get(i).toString());
        }
        current_course_list.setItems(elements);
    }
    // BookRoom
    @FXML
    public void Submit_room(ActionEvent event) throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Room r = iiitd.SearchRoom(room_menu.getValue());
        Student u = (Student)iiitd.getUser(user.getId());
//        System.out.println("Date Picker:- " + date.getValue().toString() );
        
        int num = date.getValue().getDayOfWeek().getValue()-1;
        int month = date.getValue().getMonthValue();
        int day = date.getValue().getDayOfMonth();
//        System.out.println("Num: "+num);
//        System.out.println("month "+month);
//        System.out.println("day "+day);
        String lasvegas = "";
        if ( num == 0 )
        {
            lasvegas = "Monday";
        }
        if ( num == 1 )
        {
            lasvegas = "Tuesday";
        }
        if ( num == 2 )
        {
            lasvegas = "Wednesday";
        }
        if ( num == 3 )
        {
            lasvegas = "Thursday";
        }
        if ( num == 4 )
        {
            lasvegas = "Friday";
        }
        if ( num == 5 )
        {
            lasvegas = "Saturday";
        }
        if ( num == 6 )
        {
            lasvegas = "Sunday";
        }
        Booking x = new Booking(r, start.getText()+"-"+end.getText(), date.getValue().toString(), lasvegas, reason.getText());
        
        boolean flag = true;
        ArrayList<String> bookings = r.getBookings();
        System.out.println("Bookings Size "+bookings.size());
        for (String booking : bookings) 
        {
            String[] help = booking.split("\t");
//            System.out.println(help[0]+" "+help[1]+" "+help[2]);
//            if ( help[0].equals("Always") )
//            {
//               
//            }
            if ( help[0].equals("Always") || help[0].equals(date.getValue().toString()) )
            {
                if ( help[1].equals(lasvegas) )
                {
                    if (r.isOverlap(help[2],start.getText()+"-"+end.getText()))
                    {
                        System.out.println("Time Comparison: "+help[2]+" 2nd Time "+start.getText()+"-"+end.getText());
                        flag = false;
                    }
                }
            }
        }
        if ( flag )
        {
            u.BookRoom(x);
            r.addBooking(date.getValue().toString()+"\t"+lasvegas+"\t"+start.getText()+"-"+end.getText());
            iiitd.getAdmin().addRequest(x);
        }
        else
        {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Room Booked");
            a.setHeaderText("Room Already booked for this time");
            a.setResizable(false);
            String content = String.format("Please select a different time or different room."+"\n"+x);
            a.setContentText(content);
            a.showAndWait();
        }
        App.serialize(iiitd);
        UpdatePastBookings();
        UpdateAvailableRoom();
        System.out.println("Total Requests: ");
        iiitd.getAdmin().printRequests();
        
    }
    public void UpdateAvailableRoom() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        ObservableList<String> elements = FXCollections.observableArrayList();
        ArrayList<Room> all_rooms = iiitd.getRooms();
        for (Room rm : all_rooms) 
        {
            ArrayList<String> Monday = new ArrayList<String>();
            ArrayList<String> Tuesday = new ArrayList<String>();
            ArrayList<String> Wednesday = new ArrayList<String>();
            ArrayList<String> Thursday = new ArrayList<String>();
            ArrayList<String> Friday = new ArrayList<String>();
            ArrayList<String> Saturday = new ArrayList<String>();
            ArrayList<String> Sunday = new ArrayList<String>();
            
            ArrayList<String> all_bookings = rm.getBookings();
            for ( String book : all_bookings )
            {
                String[] tmp = book.split("\t");
                if ( tmp[1].equals("Monday") )
                {
                    Monday.add("("+tmp[0]+") "+tmp[2]);
                }
                else if ( tmp[1].equals("Tuesday") )
                {
                    Tuesday.add("("+tmp[0]+") "+tmp[2]);
                }
                else if ( tmp[1].equals("Wednesday") )
                {
                    Wednesday.add("("+tmp[0]+") "+tmp[2]);
                }
                else if ( tmp[1].equals("Thursday") )
                {
                    Thursday.add("("+tmp[0]+") "+tmp[2]);
                }
                else if ( tmp[1].equals("Friday") )
                {
                    Friday.add("("+tmp[0]+") "+tmp[2]);
                }
                else if ( tmp[1].equals("Saturday") )
                {
                    Saturday.add("("+tmp[0]+") "+tmp[2]);
                }
                else if ( tmp[1].equals("Sunday") )
                {
                    Sunday.add("("+tmp[0]+") "+tmp[2]);
                }
            }
            Collections.sort(Monday, new TimeCompare());
            Collections.sort(Tuesday, new TimeCompare());
            Collections.sort(Wednesday, new TimeCompare());
            Collections.sort(Thursday, new TimeCompare());
            Collections.sort(Friday, new TimeCompare());
            Collections.sort(Saturday, new TimeCompare());
            Collections.sort(Friday, new TimeCompare());
            String data = rm.getRoomNo()+"\n"+"SUNDAY:"+"\t";
            for ( String s : Sunday )
            {
                data += s +", ";
            }
            data += "\n"+"MONDAY:"+"\t";
            for ( String s : Monday )
            {
                data += s +", ";
            }
            data += "\n"+"TUESDAY:"+"\t";
            for ( String s : Tuesday )
            {
                data += s +", ";
            }
            data += "\n"+"WEDNESDAY:"+"\t";
            for ( String s : Wednesday )
            {
                data += s +", ";
            }
            data += "\n"+"THURSDAY:"+"\t";
            for ( String s : Thursday )
            {
                data += s +", ";
            }
            data += "\n"+"FRIDAY:"+"\t";
            for ( String s : Friday )
            {
                data += s +", ";
            }
            data += "\n"+"SATURDAY:"+"\t";
            for ( String s : Saturday )
            {
                data += s +", ";
            }
            elements.add(data);
        }
        room_availability.setItems(elements);
    }
    
    public void UpdatePastBookings() throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Student u = (Student)iiitd.getUser(user.getId());
        ArrayList<Booking> b = u.getbookings();
        ObservableList<Booking> elements = FXCollections.observableArrayList();
        for (Booking b1 : b) 
        {
            elements.add(b1);
        }
        room.setCellValueFactory(new PropertyValueFactory<Booking, String>("RoomNo"));
        datecol.setCellValueFactory(new PropertyValueFactory<Booking, String>("Date"));
        days.setCellValueFactory(new PropertyValueFactory<Booking, String>("Day"));
        time.setCellValueFactory(new PropertyValueFactory<Booking, String>("Time"));
        reasoncol.setCellValueFactory(new PropertyValueFactory<Booking, String>("Reason"));
        status.setCellValueFactory(new PropertyValueFactory<Booking, String>("Status"));
        past_bookings.setItems(elements);
    }
    @FXML
    public void Remove_button(ActionEvent event) throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Student s = (Student)iiitd.getUser(user.getId());
        Booking b = past_bookings.getSelectionModel().getSelectedItem();
        iiitd.getAdmin().RemoveRequest(b);
        s.RemoveRequest(b);
        App.serialize(iiitd);
        UpdatePastBookings();
        UpdateAvailableRoom();
    }
    public void ShowallCourses() throws IOException, ClassNotFoundException
    {
        ObservableList<String> elements = FXCollections.observableArrayList();
        Institute iiitd = App.deserialize();
        ArrayList<Course> a = iiitd.getCourses();
        for( int i=0; i<a.size(); i++ )
        {
            elements.add(i, a.get(i).toString());
        }
        all_course.setItems(elements);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user = (Student)LoginController.currentUser;
        room_menu.setValue("C01");
        room_menu.getItems().addAll("C01", "C02", "C03", "C11", "C12", "C13", "C21", "C22", "C23","C24");
        try {
            addItems();
            ShowallCourses();
            UpdateTable("");
            UpdateTimeTable();
            UpdatePastBookings();
            UpdateAvailableRoom();
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Add items done");
        user_name.setText("Welcome "+user.getName());
        String[] suggest = {"CSE112,Computer Organization","Computer Organization",
            "CSE121,Discrete Mathematics","Discrete Mathematics",
            "CSE201,Advanced Programming","Advanced Programming",
            "HSS202,Perspectives of Knowledge","Perspectives of Knowledge",
            "HSS204,Introduction to Psychology","Introduction to Psychology",
            "HSS211,Theatre Appreciation","Theatre Appreciation",
            "HSS222,Philosophy of Literature","Philosophy of Literature",
            "MTH203,Maths-III,Sarthok Sircar","Maths-III",
            "ECE250,Signal & Systems","Signal & Systems",
            "MTH2xx,Real Analysis I","Real Analysis I",
            "MTH2xx,Number Theory","Number Theory",
            "HSS2ES,Key Concepts in Economic Sociology","Key Concepts in Economic Sociology",
            "HSS2xx,Introduction to Digital Ethnography","Introduction to Digital Ethnography",
            "HSS2xx,Introduction to Media In Society : A Public Sphere Approach","Introduction to Media In Society : A Public Sphere Approach",
            "HSS2xx,Introduction to Social Informatics ","Introduction to Social Informatics ",
            "HSS223A,Introduction to Poetry","Introduction to Poetry",
            "ECE270,Embeded Logic Design","Embeded Logic Design",
            "ECE215,Circuit Theory and Devices","Circuit Theory and Devices",
            "MTH2xx,Discrete Mathematics","Discrete Mathematics",
            "CSE2xx,Computer Architecture and Operating Systems","Computer Architecture and Operating Systems",
            "HSS208,Theory and Practice of Engineering Ethics","Theory and Practice of Engineering Ethics",
        };
        
        Course_name.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
            try {
                UpdateTable(newValue.toLowerCase());
            } catch (IOException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}
class TimeCompare implements Comparator<String>{
    @Override
    public int compare(String e1, String e2) {
        String time1 = e1.substring(e1.length()-11, e1.length());
        String time2 = e2.substring(e2.length()-11, e2.length());
//        System.out.println(time1+" "+time2);
        if ( time1.substring(0, 2).compareTo(time2.substring(0, 2)) == 0 )
        {
            return time1.substring(3, 5).compareTo(time2.substring(3, 5));
        }
        return time1.substring(0, 2).compareTo(time2.substring(0, 2));
    }
}