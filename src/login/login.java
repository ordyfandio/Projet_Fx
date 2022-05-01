package login;

import Admin_login.Login_adminController;
import Projet_fx.projet_fx;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import dashboard.dashboard_fx;
import java.awt.Component;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import java.sql.Connection;

public class login {
//    projet_fx fxconnect = new projet_fx();
    Connection con;

    ResultSet rs;
    PreparedStatement pst;
    public static Connection mycon(){
        
        Connection con = null ;
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","");
           
        }
        catch(Exception ex){
        }
        
        return con;
    }
    
    @FXML
    private PasswordField txtpassword;
  
    @FXML
    private Button CancelButtonView;
    @FXML
    private Button SubmiTButton;
    @FXML
    private ImageView brandingImageViewLogin;
    @FXML
    private TextField txtusername;
    @FXML
    private Text invalid_name;
    @FXML
    private Text invalid_password;



    @FXML
    private void CancelButtonOnAction(ActionEvent event) {
         JFrame frame = new JFrame("Exit");
        if(JOptionPane.YES_NO_OPTION== JOptionPane.showConfirmDialog(frame, "Comfirm if you want exit",
                "Login Form",JOptionPane.YES_NO_OPTION)){
            System.exit(0);
            
        }
    }


    @FXML
    private void SubmiTButtonOnAction(ActionEvent event) {
        if(event.getSource()==SubmiTButton){
      String username =txtusername.getText();
      String password = txtpassword.getText();
      
        if(username.equals("") && password.equals("")){
            JOptionPane.showMessageDialog(null,"Your Name and Your Password are Blancks !");
        }else{
          try {
              Class.forName("com.mysql.jdbc.Driver");
              con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
              
              pst = (PreparedStatement) con.prepareStatement("SELECT * FROM student WHERE username=? AND password=?");
              pst.setString(1,username);
              pst.setString(2,password);
              rs = pst.executeQuery();
               if(rs.next()){
                   JOptionPane.showMessageDialog(null,"Login Successful!");
//                   this is the code link two page
                   Stage stage = new Stage();
                   try {
                    new dashboard_fx().start(stage);
            
                   } catch (Exception ex) {
                     Logger.getLogger(Login_fxController.class.getName()).log(Level.SEVERE, null, ex);
                  }
               }else{
                   JOptionPane.showMessageDialog(null,"Login Failed !");
                   txtusername.setText("");
                   txtpassword.setText("");
                   txtusername.requestFocus();
               }
          } 
          catch (ClassNotFoundException ex) {
              Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
          }
           
       } 
        }
      
     
      
    }
    }

