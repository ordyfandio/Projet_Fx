package Admin;

import Admin_login.Admin_login_fx;
import Admin_login.logindb;
import java.awt.Component;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;




public class AdminController implements Initializable {

    @FXML
    private ImageView brandingImageView;
    @FXML
    private Button submitButton;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtmatricule;
    @FXML
    private Button signupButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        File brandingFile = new File("@admin.png");
//        Image brandingImage = new Image(brandingFile.toURI().toString());
//        brandingImageView.setImage(brandingImage);
      
    }    

    @FXML
    private void SubmitButtonOnAction(ActionEvent event) throws SQLException{
        if(event.getSource()==submitButton){
            
            String name =txtname.getText();
            String password =txtpassword.getText();
            String email =txtemail.getText();
            String matricule =txtmatricule.getText();
            
            try{
           Statement s =logindb.mycon().createStatement();
           s.executeUpdate("INSERT INTO admin (name,matricule,email,password)"
                   + "VALUES('"+name+"','"+matricule+"','"+email+"','"+password+"')");
           Component parentComponent = null;
           JOptionPane.showMessageDialog(parentComponent, "Your Account Created .Login now");
           
           
       }
       catch(Exception ex){
           System.out.println(ex);
       }
       txtname.setText("");
       txtpassword.setText("");
       txtemail.setText("");
       txtmatricule.setText("");
        }
    }

    @FXML
    private void signupButtonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            new Admin_login_fx().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
