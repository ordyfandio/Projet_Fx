package Projet_fx;

//import java.awt.Image;
//import java.awt.Label;
//import java.awt.TextField;
//import Projet_fx.login.login;
//import Projet_fx.login.login_fx;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.DatePicker;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.StringConverter;
import javafx.scene.DepthTest;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javax.management.remote.JMXConnectorFactory;
import javafx.scene.input.MouseEvent;
import login.login;
import login.login_fx;

public class Projet_fxController implements Initializable {
    projet_fx fxconnect = new projet_fx();
    Connection con = fxconnect.con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    @FXML
    private javafx.scene.control.Label message;
//    private String pathname;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockimageview;
    @FXML
    private Button SubmiTButton;
    private Button cancelButton;
    @FXML
    private Button CancelButtonView;
    @FXML
    private RadioButton txtmale;
    @FXML
    private RadioButton txtfemele;
    @FXML
    private TextField txtregion;
    @FXML
    private TextField txtplacebirth;
    @FXML
    private TextField txtdivision;
    @FXML
    private ComboBox txtstatus;
    @FXML
    private DatePicker txtdate =new DatePicker();
    private Date date = new Date();
    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtparentname;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtnationality;


//    public  projet_fx(){
//        Connection con = fxconnect.con;
//    }
    
    @FXML
    public void SubmitButtonOnAction(ActionEvent event) throws SQLException {
        
        if(event.getSource()==SubmiTButton){
                
       String username =txtusername.getText();
       String surname =txtname.getText();
       String password=txtpassword.getText();
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
       String placebirth = txtplacebirth.getText();
       String parent =txtparentname.getText();
       String address =txtaddress.getText();
       String region =txtregion.getText();
       String division = txtdivision.getText();
       String nationality = txtnationality.getText();
       String status = (String) txtstatus.getSelectionModel().getSelectedItem();
       
       
       String toggleName =((RadioButton) toggleGroup.getSelectedToggle()).getText();

       try{
           Statement s =login.mycon().createStatement();
           s.executeUpdate("INSERT INTO student (id,username,surname,password,gender,datebirth,placebirth,parent,address,region,division,nationality,status)"
                   + "VALUES(id,'"+username+"','"+surname+"','"+password+"','"+toggleName+"','"+date+"','"+placebirth+"','"+parent+"','"+address+"','"+region+"','"+division+"','"+nationality+"','"+status+"')");
           Component parentComponent = null;
           JOptionPane.showMessageDialog(parentComponent, "Your Account Created .Login now");
           
           
       }
       catch(Exception ex){
           System.out.println(ex);
       }
       
       txtusername.setText("");
       txtname.setText("");
       txtmale.setSelected(true);       
       txtpassword.setText("");
//       txtdate.setPromptText("dd-mm-yyyy");
       txtplacebirth.setText("");
       txtparentname.setText("");
       txtaddress.setText("");
       txtregion.setText("");
       txtdivision.setText("");
       txtnationality.setText("");
//       txtstatus.setItems(list);
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
    public void CancelButtonOnAction(ActionEvent event) {
//        Stage stage = (Stage) cancelButton.getScene().getWindow();
//        stage.close();
        JFrame frame = new JFrame("Exit");
        if(JOptionPane.YES_NO_OPTION== JOptionPane.showConfirmDialog(frame, "Comfirm if you want exit",
                "Student Registration",JOptionPane.YES_NO_OPTION)){
            System.exit(0);
            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("@../../../testfx/src/testfx/registration.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("@../../../testfx/src/testfx/securite.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockimageview.setImage(lockImage);
        ObservableList<String> list = FXCollections.observableArrayList("Single","Maried","Divorce");
        txtstatus.setItems(list);
    }
    


    public Projet_fxController() {
        
    }
   


//    @FXML
//    private void labelMouseClicked(MouseEvent event) {
//        new login().setVisible();   
//    }    

    @FXML
    private void labelMouseClicked(MouseEvent event){
       Stage stage = new Stage();
        try {
            new login_fx().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Projet_fxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}