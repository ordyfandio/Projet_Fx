package dashboard;

//import java.awt.Image;
import Admin.AdminController;
import Admin.admin_fx;
import Admin_login.Admin_login_fx;
import Projet_fx.projet_fx;
import com.sun.javafx.scene.layout.region.Margins;
import java.awt.Component;
import java.io.File;
import java.net.URL;
import java.sql.Statement;
import static java.time.Clock.system;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.util.Collections.list;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import login.login;
import utils.dateUtil;


public class DashboardController implements Initializable {
    
    @FXML
    private ImageView dashboardImage;
    @FXML
    private Button ShareCourse;
    @FXML
    private Button ButtonDisconnect;
    @FXML
    private Button admitbutton;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtsurname;
    @FXML
    private TextField txtplace;
    @FXML
    private TextField txtparent;
    @FXML
    private RadioButton txtmale;
    @FXML
    private RadioButton txtfemele;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtdivision;
    @FXML
    private TextField txtregion;
    @FXML
    private ComboBox txtstatus;
    @FXML
    private TextField txtnationality;
    @FXML
    private Button submitbutton;
    @FXML
    private DatePicker txtdate =new DatePicker();
    private Date date = new Date();
    @FXML
    private Button validationbutton;
    @FXML
    private TextField txtmaths_ol;
    @FXML
    private TextField txtphysics_ol;
    @FXML
    private TextField txtchemistry_ol;
    @FXML
    private TextField txtcomputer_ol;
    @FXML
    private TextField txtmaths_al;
    @FXML
    private TextField txtphysics_al;
    @FXML
    private TextField txtchemistry_al;
    @FXML
    private TextField txtcomputer_al;
    @FXML
    private TextField txtfrench_ol;
    @FXML
    private TextField txtenglish_ol;
    @FXML
    private TextField txtfrench_al;
    @FXML
    private TextField txtenglish_al;
    @FXML
    private ComboBox txtengineer;
    @FXML
    private ComboBox txttechnique;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ObservableList<String> list = FXCollections.observableArrayList("Single","Maried","Divorce");
       txtstatus.setItems(list);
       ObservableList<String> listEng = FXCollections.observableArrayList("Civil Engineering","Rural Engineering","Town Plannig","Land Surveying");
       txtengineer.setItems(listEng);
       ObservableList<String> listTech = FXCollections.observableArrayList("Basic Technical Cycle","Ordinary Technical Cycle","Higher Technical Cycle");
       txttechnique.setItems(listTech);
    }    


    @FXML
    private void ShareCourseOnAction(ActionEvent event) {
    }

    @FXML
    private void admitbuttonOnAction(ActionEvent event) {
         Stage stage = new Stage();
        try {
            new admin_fx().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void submitbuttonOnAction(ActionEvent event) {
        
        if(event.getSource()==submitbutton){
         
       String name =txtname.getText();
       String surname =txtsurname.getText();
       ToggleGroup toggleGroup =new ToggleGroup();
       txtmale.setToggleGroup(toggleGroup);
       txtfemele.setToggleGroup(toggleGroup);
       DatePicker datePicker =new DatePicker();
       int years = 0;
       String year=Integer.toString(years);
       int months = 0;
       String month=Integer.toString(months);
       int days=0;
       String day=Integer.toString(days);
       LocalDate date = txtdate.getValue();
       String placebirth = txtplace.getText();
       String parent =txtparent.getText();
       String address =txtaddress.getText();
       String region =txtregion.getText();
       String division = txtdivision.getText();
       String nationality = txtnationality.getText();
       String status = (String) txtstatus.getSelectionModel().getSelectedItem();
       String toggleName =((RadioButton) toggleGroup.getSelectedToggle()).getText();
       
       try{
           Statement s =login.mycon().createStatement();
           s.executeUpdate("INSERT INTO dashboard (id,name,surname,sex,datebirth,placebirth,parent,address,region,division,nationality,status)"
                   + "VALUES(id,'"+name+"','"+surname+"','"+toggleName+"','"+date+"','"+placebirth+"','"+parent+"','"+address+"','"+region+"','"+division+"','"+nationality+"','"+status+"')");
           Component parentComponent = null;
           JOptionPane.showMessageDialog(parentComponent, "Your Account Created "); 
       }
       catch(Exception ex){
           System.out.println(ex);
       }
        txtname.setText("");
       txtsurname.setText("");
       txtmale.setSelected(true);       
       txtdate.setPromptText("yyyy-mm-dd");
       txtplace.setText("");
       txtparent.setText("");
       txtaddress.setText("");
       txtregion.setText("");
       txtdivision.setText("");
       txtnationality.setText("");
       
//           DashboardController.Date(dateUtil.convert(txtdate.getValue().toString()));
        }
    }

    public DatePicker getTxtdate() {
        return txtdate;
    }

    public Date getDate() {
        return date;
    }

    public void setTxtDate(Date date) {
        this.date = date;
    }
    
   
    public void setTxtdate(DatePicker txtdate) {
        this.txtdate = txtdate;
    }
    
    @FXML
    private void selectStatus(ActionEvent event) {
        
    }

    @FXML
    private void validationbuttonOnAction(ActionEvent event) {
        if(event.getSource()==validationbutton){
            
            String maths_ol =txtmaths_ol.getText();
            String physics_ol =txtphysics_ol.getText();
            String chemistry_ol =txtchemistry_ol.getText();
            String computer_ol =txtcomputer_ol.getText();
            String maths_al =txtmaths_al.getText();
            String physics_al =txtphysics_al.getText();
            String chemistry_al =txtchemistry_al.getText();
            String computer_al =txtcomputer_al.getText();
            String engineer = (String) txtengineer.getSelectionModel().getSelectedItem();
            String technique = (String) txttechnique.getSelectionModel().getSelectedItem();
            
            
           try{
           Statement s =login.mycon().createStatement();
           s.executeUpdate("INSERT INTO cours (id,maths_ol,physics_ol,chemistry_ol,computer_ol,maths_al,physics_al,chemistry_al,computer_al,technical,engineer)"
                   + "VALUES(id,'"+maths_ol+"','"+physics_ol+"','"+chemistry_ol+"','"+computer_ol+"','"+maths_al+"','"+physics_al+"','"+chemistry_al+"','"+computer_al+"','"+technique+"','"+engineer+"')");
           Component parentComponent = null;
           JOptionPane.showMessageDialog(parentComponent, "Your information have been Saved "); 
         }
          catch(Exception ex){
           System.out.println(ex);
         }
           txtmaths_ol.setText("");
           txtphysics_ol.setText("");
           txtchemistry_ol.setText("");
           txtcomputer_ol.setText("");
           txtmaths_al.setText("");
           txtphysics_al.setText("");
           txtchemistry_al.setText("");
           txtcomputer_al.setText("");
        }
    }

    @FXML
    private void ButtonDisconnectOnAction(ActionEvent event) {
        if(event.getSource()==ButtonDisconnect){
//            JOptionPane.showMessageDialog(null,"Are you sure!");
//            System.exit(0);
           JFrame frame = new JFrame("Exit");
           if(JOptionPane.YES_NO_OPTION== JOptionPane.showConfirmDialog(frame, "Comfirm if you want disconnect ?",
                "Student Registration",JOptionPane.YES_NO_OPTION)){
            
//              Stage stage = new Stage();
//              try {
//                 new projet_fx().start(stage);
//            
//              } catch (Exception ex) {
//               Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
//              }
              System.exit(0);
           }
        }
    }
    
}
