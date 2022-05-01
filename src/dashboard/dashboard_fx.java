package dashboard;

import static java.awt.SystemColor.window;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class dashboard_fx extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Image icon= new Image(getClass().getResourceAsStream("logo_academy.png"));
        stage.getIcons().add(icon);
        Scene scene=new Scene(root);
        stage.setTitle("Dashboard Interface");
        stage.setScene(scene);
        stage.show();
    }
}
