/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.control.DatePicker;
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
public class DashboardControllerIT {
    
    public DashboardControllerIT() {
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
     * Test of initialize method, of class DashboardController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle resourceBundle = null;
        DashboardController instance = new DashboardController();
        instance.initialize(url, resourceBundle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTxtdate method, of class DashboardController.
     */
    @Test
    public void testGetTxtdate() {
        System.out.println("getTxtdate");
        DashboardController instance = new DashboardController();
        DatePicker expResult = null;
        DatePicker result = instance.getTxtdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class DashboardController.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        DashboardController instance = new DashboardController();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTxtDate method, of class DashboardController.
     */
    @Test
    public void testSetTxtDate() {
        System.out.println("setTxtDate");
        Date date = null;
        DashboardController instance = new DashboardController();
        instance.setTxtDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTxtdate method, of class DashboardController.
     */
    @Test
    public void testSetTxtdate() {
        System.out.println("setTxtdate");
        DatePicker txtdate = null;
        DashboardController instance = new DashboardController();
        instance.setTxtdate(txtdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
