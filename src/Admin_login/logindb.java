package Admin_login;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
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
import javax.swing.JOptionPane;
import javafx.scene.image.Image;


public class logindb {
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    public static Connection mycon(){
        
         Connection con = null ;
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","");
;           
        }
        catch(Exception ex){
        }
        
        return con;
    }
    
    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtmatricule;
    @FXML
    private Button SubmiTButton;
    @FXML
    private ImageView brandingImageViewLogin;
    
    @FXML
    private void SubmiTButtonOnAction(ActionEvent event){
        
        if(event.getSource()==SubmiTButton){
      String matricule =txtmatricule.getText();
      String password = txtpassword.getText();
      
        if(matricule.equals("") && password.equals("")){
            JOptionPane.showMessageDialog(null,"Your Matricule and Your Password are Blancks !");
        }else{
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
            
        }
    }
        
    }
}
