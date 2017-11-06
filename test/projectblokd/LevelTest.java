/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Graphics;
import javax.swing.JFrame;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Youri
 */
public class LevelTest {
    Level l;
    JFrame jf;
    
    public LevelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        l = new Level(jf);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of paintComponent method, of class Level.
     */
    @Test
    public void testPaintComponent() {
        
    }

    /**
     * Test of newLevel method, of class Level.
     */
    @Test
    public void testNewLevel() {
        
    }

    /**
     * Test of getLevel method, of class Level.
     */
    @Test
    public void testGetLevel() {
        
    }

    /**
     * Test of setLevel method, of class Level.
     */
    @Test
    public void testSetLevel() {
        
    }

    /**
     * Test of getBullet method, of class Level.
     */
    @Test
    public void testGetBullet() {
       
    }

    /**
     * Test of cheaterStappen method, of class Level.
     */
    @Test
    public void testCheaterStappen() {
        l.cheaterStappen();
        assertEquals(0, l.staps);
    }

    /**
     * Test of addBullet method, of class Level.
     */
    @Test
    public void testAddBullet() {
        l.addBullet();
        assertEquals(2, l.getBullet());
    }

    /**
     * Test of fireBullet method, of class Level.
     */
    @Test
    public void testFireBullet() {
        l.fireBullet();
        assertEquals(1, l.getBullet());
    }

    /**
     * Test of findPath method, of class Level.
     */
    @Test
    public void testFindPath() {
        
    }

    /**
     * Test of resetHelper method, of class Level.
     */
    @Test
    public void testResetHelper() {
        
    }

    /**
     * Test of teleport method, of class Level.
     */
    @Test
    public void testTeleport() {
       
    }
}
