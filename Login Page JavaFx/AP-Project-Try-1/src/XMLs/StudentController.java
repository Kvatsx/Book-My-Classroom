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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kaust
 */
public class StudentController implements Initializable {

    public static User user;
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
    private TextField capacity;
    @FXML
    private DatePicker date;
    @FXML
    private TextField start_time;
    @FXML
    private TextField end_time;
    @FXML
    private TextArea reason;
    @FXML
    private Button search_button;

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
    
    public void addItems()
    {
        ObservableList<String> elements = FXCollections.observableArrayList("Mandatory\n"
                +"Course Name: Advanced Programming\n"
                +"Course Code: CSE201\n"
                +"Instructor: Vivek Kumar\n"
                +"Credits: 4\n"
                +"Acronym: AP\n",
                "",
                "Mandatory\n"
                +"Course Name: Computer Organization\n"
                +"Course Code: CSE112\n"
                +"Instructor: Naveen Prakash(G)\n"
                +"Credits: 4\n"
                +"Acronym: CO\n",
                "");
        current_course_list.setItems(elements);
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
        user = LoginController.currentUser;
        addItems();
        try {
            ShowallCourses();
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Add items done");
        user_name.setText("Welcome "+user.getName());
    }    
    
}
