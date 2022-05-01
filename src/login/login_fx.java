package login;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class login_fx extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("logo_academy.png"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Login Form");
        stage.setScene(scene);
        stage.show();
    }

//    public void SetVisible(boolean b) {
//       
//    }
//
//    public void setVisible(boolean b) {
//        
//    }
}
