package Projet_fx;

//import com.mysql.jdbc.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.sun.jdi.connect.spi.Connection;
import com.mysql.jdbc.PreparedStatement;
//import com.sun.javafx.logging.PlatformLogger;
//import com.sun.javafx.logging.PlatformLogger.Level;
//import java.lang.System.Logger;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;


public class projet_fx extends Application{
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("projet_fx.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("logo_academy.png"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Registration Form");
        stage.setScene(scene);
        stage.show();
    }
//    public projet_fx(){
//        Connect();
//    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public void Connect(){
        System.out.println("Starting the connection to the database");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connect to mysql");
            try{
                con = (com.sun.jdi.connect.spi.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
                System.out.println("Connection to the database userdb");
            }catch(SQLException ex){
                Logger.getLogger(projet_fx.class.getName()).log(Level.SEVERE,null, ex);
                 System.out.println("unable to connect the database");
            }
        }catch(ClassNotFoundException ex){
             Logger.getLogger(projet_fx.class.getName()).log(Level.SEVERE,null, ex);
             System.out.println("unable the connection to the mysql database");
        }
    }
}
