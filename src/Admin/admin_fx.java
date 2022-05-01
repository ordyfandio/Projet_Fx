package Admin;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class admin_fx extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("logo_academy.png"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Administration Form");
        stage.setScene(scene);
        stage.show();
    }
    public admin_fx(){
        Connect();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private void Connect() {
        System.out.println("Starting the connection to the database");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connect to mysql");
            try{
                con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
                System.out.println("Connection to the database userdb");
            }catch(SQLException ex){
                Logger.getLogger(admin_fx.class.getName()).log(Level.SEVERE,null, ex);
                 System.out.println("unable to connect the database");
            }
        }catch(ClassNotFoundException ex){
             Logger.getLogger(admin_fx.class.getName()).log(Level.SEVERE,null, ex);
             System.out.println("unable the connection to the mysql database");
        }
    }
    
}
