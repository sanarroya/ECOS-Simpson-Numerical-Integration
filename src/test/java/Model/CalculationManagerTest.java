/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SantiagoAvila
 */
public class CalculationManagerTest {
    
    public CalculationManagerTest() {
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
     * Test of tDistribution method, of class CalculationManager.
     */
    @Test
    public void testTDistribution() {
        System.out.println("tDistribution");
        IntegralInfo integralInfo = null;
        double expResult = 0.0;
        double result = CalculationManager.tDistribution(integralInfo);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gammaFunction method, of class CalculationManager.
     */
    @Test
    public void testGammaFunction() {
        System.out.println("gammaFunction");
        double value = 0.0;
        CalculationManager instance = new CalculationManager();
        double expResult = 0.0;
        double result = instance.gammaFunction(value);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
