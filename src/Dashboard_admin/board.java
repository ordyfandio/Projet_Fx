package Dashboard_admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class board extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("Board.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("logo_academy.png"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Administration Form");
        stage.setScene(scene);
        stage.show();
    }
}
