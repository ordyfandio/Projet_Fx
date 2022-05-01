package Admin_login;


import Dashboard_admin.board;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dashboard.dashboard_fx;
//import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class Login_adminController implements Initializable {
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    @FXML
    private ImageView brandingImageViewLogin;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtmatricule;
    @FXML
    private Button submitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       
//        File brandingFile = new File("@LoginAdmin.png");
//          Image brandingImage = new Image(brandingFile.toURI().toString());
//          brandingImageViewLogin.setImage(brandingImage);
      
    }    

    @FXML
    private void SubmiTButtonOnAction(ActionEvent event) {
        
      String matricule = txtmatricule.getText();
      String password = txtpassword.getText();
        
       if(matricule.equals("")&& password.equals("")){
           JOptionPane.showMessageDialog(null,"Your Matricule and Your Password are Blancks !");
       }
       else{
           try {
              Class.forName("com.mysql.jdbc.Driver");
              con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
              
              pst = (PreparedStatement) con.prepareStatement("SELECT * FROM admin WHERE matricule=? AND password=?");
              pst.setString(1,matricule);
              pst.setString(2,password);
              rs = pst.executeQuery(); 
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Login Successful!");
               }else{
                   JOptionPane.showMessageDialog(null,"Login Failed !");
               }
               txtmatricule.setText("");
               txtpassword.setText("");
               txtmatricule.requestFocus();
          } 
          catch (ClassNotFoundException ex) {
              Logger.getLogger(logindb.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(logindb.class.getName()).log(Level.SEVERE, null, ex);
          }
           
//           this is method to link two page
        Stage stage = new Stage();
        try {
            new board().start(stage);
            
        } catch (Exception ex) {
            Logger.getLogger(Login_adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }
    
}
