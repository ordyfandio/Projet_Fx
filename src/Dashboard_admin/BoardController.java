package Dashboard_admin;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BoardController implements Initializable {
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
      @FXML
    private TableView<boardTable> table;
    @FXML
    private TableColumn<boardTable, String> txtaddress;
    @FXML
    private TableColumn<boardTable, String> txtdatebirth;
    @FXML
    private TableColumn<boardTable, String> txtdivision;
    @FXML
    private TableColumn<boardTable, String> txtname;
    @FXML
    private TableColumn<boardTable, String> txtparent;
    @FXML
    private TableColumn<boardTable, String> txtplace;
    @FXML
    private TableColumn<boardTable, String> txtregion;
    @FXML
    private TableColumn<boardTable, String> txtsex;
    @FXML
    private TableColumn<boardTable, String> txtstatus;
    @FXML
    private TableColumn<boardTable, String> txtsurname;
    @FXML
    private TableColumn<boardTable, String> txtnationality;

    
    ObservableList<boardTable> oblist = FXCollections.observableArrayList();
    
    @FXML
    private TableView<table> table_n;
    @FXML
    private TableColumn<table, String> txtmaths_ol;
    @FXML
    private TableColumn<table, String> txtphysics_ol;
    @FXML
    private TableColumn<table, String> txtchemistry_ol;
    @FXML
    private TableColumn<table, String> txtcomputer_ol;
    @FXML
    private TableColumn<table, String> txtmaths_al;
    @FXML
    private TableColumn<table, String> txtphysics_al;
    @FXML
    private TableColumn<table, String> txtchemistry_al;
    @FXML
    private TableColumn<table, String> txtcomputer_al;
    @FXML
    private TableColumn<table, String> txttechnical;
    @FXML
    private TableColumn<table, String> txtengineer;
    
    ObservableList<table> list = FXCollections.observableArrayList();
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
            
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM dashboard");
            rs = pst.executeQuery();
            while(rs.next()){
                 oblist.add(new boardTable(rs.getString("name"),rs.getString("surname"),rs.getString("sex"),rs.getString("datebirth"),rs.getString("placebirth"),rs.getString("parent"),rs.getString("address"),rs.getString("division"),rs.getString("region"),rs.getString("nationality"),rs.getString("status")));
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
            
             pst = (PreparedStatement) con.prepareStatement("SELECT * FROM cours");
             rs = pst.executeQuery();
             while(rs.next()){
                 list.add(new table(rs.getString("maths_ol"),rs.getString("physics_ol"),rs.getString("chemistry_ol"),rs.getString("computer_ol"),rs.getString("maths_al"),rs.getString("physics_al"),rs.getString("chemistry_al"),rs.getString("computer_al"),rs.getString("technical"),rs.getString("engineer")));
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        txtmaths_ol.setCellValueFactory(new PropertyValueFactory<>("txtmaths_ol"));
        txtphysics_ol.setCellValueFactory(new PropertyValueFactory<>("txtphysics_ol"));
        txtchemistry_ol.setCellValueFactory(new PropertyValueFactory<>("txtchemistry_ol"));
        txtcomputer_ol.setCellValueFactory(new PropertyValueFactory<>("txtcomputer_ol"));
        txtmaths_al.setCellValueFactory(new PropertyValueFactory<>("txtmaths_al"));
        txtphysics_al.setCellValueFactory(new PropertyValueFactory<>("txtphysics_al"));
        txtchemistry_al.setCellValueFactory(new PropertyValueFactory<>("txtchemistry_al"));
        txtcomputer_al.setCellValueFactory(new PropertyValueFactory<>("txtcomputer_al"));
        txttechnical.setCellValueFactory(new PropertyValueFactory<>("txttechnical"));
        txtengineer.setCellValueFactory(new PropertyValueFactory<>("txtengineer"));
        table_n.setItems(list);
        
        txtname.setCellValueFactory(new PropertyValueFactory<>("txtname"));
        txtsurname.setCellValueFactory(new PropertyValueFactory<>("txtsurname"));
        txtsex.setCellValueFactory(new PropertyValueFactory<>("txtsex"));
        txtdatebirth.setCellValueFactory(new PropertyValueFactory<>("txtdatebirth"));
        txtplace.setCellValueFactory(new PropertyValueFactory<>("txtplace"));
        txtparent.setCellValueFactory(new PropertyValueFactory<>("txtparent"));
        txtaddress.setCellValueFactory(new PropertyValueFactory<>("txtaddress"));
        txtdivision.setCellValueFactory(new PropertyValueFactory<>("txtdivision"));
        txtregion.setCellValueFactory(new PropertyValueFactory<>("txtregion"));
        txtnationality.setCellValueFactory(new PropertyValueFactory<>("txtnationality"));
        txtstatus.setCellValueFactory(new PropertyValueFactory<>("txtstatus"));
        
        table.setItems(oblist);
    }    
    
}
