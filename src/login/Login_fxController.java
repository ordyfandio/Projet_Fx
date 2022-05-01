package login;


import Projet_fx.Projet_fxController;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login_fxController implements Initializable {
    
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    public Login_fxController(){
//       initComponents(); 
       
//       con = login.mycon();
    }
     
    @FXML
    private ImageView brandingImageViewLogin;
    @FXML
    private Button CancelButtonView;

    @FXML
    private Button SubmiTButton;

    @FXML
    private TextField txtname;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    void CancelButtonOnAction(ActionEvent event) {
      
        JFrame frame = new JFrame("Exit");
        if(JOptionPane.YES_NO_OPTION== JOptionPane.showConfirmDialog(frame, "Comfirm if you want exit",
                "Login Registration",JOptionPane.YES_NO_OPTION)){
            System.exit(0);
            
        }
    }

    @FXML
    void SubmiTButtonOnAction(ActionEvent event) {
      String name = txtname.getText();
      String password = txtpassword.getText();
      
       if(name.equals("") && password.equals("")){
            JOptionPane.showMessageDialog(null,"Your Name and Your Password are Blancks !");
        }else{
          try {
              Class.forName("com.mysql.jdbc.Driver");
              con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
              
              pst = (PreparedStatement) con.prepareStatement("SELECT * FROM student WHERE name=? AND password=?");
              pst.setString(1,name);
              pst.setString(2,password);
              rs = pst.executeQuery(); 
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Login Successful!");
               }else{
                   JOptionPane.showMessageDialog(null,"Login Failed !");
                   
               }
               txtname.setText("");
               txtpassword.setText("");
               txtname.requestFocus();
          } 
          catch (ClassNotFoundException ex) {
              Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
          }
            
        }
      
    }

    
    
    @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {
          File brandingFile = new File("@login.png");
          Image brandingImage = new Image(brandingFile.toURI().toString());
          brandingImageViewLogin.setImage(brandingImage);

      
    }    

//    private void initComponents() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    @FXML
    void labelMouseClicked(MouseEvent event){
       
    }
}
