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
import javafx.stage.Stage;

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
    private Button submit_button;
    @FXML
    private Button add_course;
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
    public void UpdateTimeTable()
    {
        
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
    
    @FXML
    public void Submit_room(ActionEvent event) throws IOException, ClassNotFoundException
    {
        Institute iiitd = App.deserialize();
        Room r = iiitd.SearchRoom(room_menu.getValue());
        System.out.println("Date Picker:- " + date.getValue().toString() );
        Booking x = new Booking(r, start.getText()+"-"+end.getText(), date.getValue().toString(), reason.getText());
        ArrayList<Course> c = iiitd.getCourses();
        int num = date.getValue().getDayOfWeek().getValue()-1;
        int month = date.getValue().getMonthValue();
        int day = date.getValue().getDayOfMonth();
        System.out.println("Num: "+num);
        boolean flag = true;
        for ( int i=0; i<c.size(); i++ )
        {
            if ( c.get(i).getRoomOnDay(num).equals(r.getRoomNo()) )
            {
                String timings = c.get(i).getTimeOnDay(num);
                String s1 = timings.substring(0, 5);
                String e1 = timings.substring(6, 11);
                // need to implement time interval overlap check
            }
        }
        // add one more for loop to check in booked room arraylist.
        
        if ( flag )
        {
            user.BookRoom(x);
            Admin.request.add(x);
        }
        App.serialize(iiitd);
        System.out.println("Total Requests: "+Admin.request.size());
        for ( int i=0; i<Admin.request.size(); i++ )
        {
            System.out.println(Admin.request.get(i));
        }
        
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
