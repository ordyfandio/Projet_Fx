/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ordy_Fandio
 */
public class Login_fxControllerIT {
    
    public Login_fxControllerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of CancelButtonOnAction method, of class Login_fxController.
     */
    @Test
    public void testCancelButtonOnAction() {
        System.out.println("CancelButtonOnAction");
        ActionEvent event = null;
        Login_fxController instance = new Login_fxController();
        instance.CancelButtonOnAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SubmiTButtonOnAction method, of class Login_fxController.
     */
    @Test
    public void testSubmiTButtonOnAction() {
        System.out.println("SubmiTButtonOnAction");
        ActionEvent event = null;
        Login_fxController instance = new Login_fxController();
        instance.SubmiTButtonOnAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class Login_fxController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle resourceBundle = null;
        Login_fxController instance = new Login_fxController();
        instance.initialize(url, resourceBundle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of labelMouseClicked method, of class Login_fxController.
     */
    @Test
    public void testLabelMouseClicked() {
        System.out.println("labelMouseClicked");
        MouseEvent event = null;
        Login_fxController instance = new Login_fxController();
        instance.labelMouseClicked(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
