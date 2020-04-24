

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CoffeeShopSimTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CoffeeShopSimTest
{
    /**
     * Default constructor for test class CoffeeShopSimTest
     */
    public CoffeeShopSimTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void addArrival()
    {
        CoffeeShopSim coffeeSh2 = new CoffeeShopSim(1, 1, 2, 3, 4, 5);
        coffeeSh2.addArrival(3);
        assertTrue(coffeeSh2.eventSet.size()==1);
        assertTrue(coffeeSh2.eventSet.peek().time==3);
    }
    
    @Test
    public void addCustomer()
    {
        CoffeeShopSim coffeeSh2 = new CoffeeShopSim(1, 1, 2, 3, 4, 5);
        coffeeSh2.addArrival(3);
        coffeeSh2.arrival(coffeeSh2.eventSet.remove(),1);
        assertTrue(coffeeSh2.cashiers.cashierLine.get(0).waitTime==1);
    }
    
    @Test
    public void remCustomer()
    {
        CoffeeShopSim coffeeSh2 = new CoffeeShopSim(1, 1, 2, 3, 4, 5);
        coffeeSh2.addArrival(3);
        coffeeSh2.arrival(coffeeSh2.eventSet.peek(),1);
        coffeeSh2.departure(coffeeSh2.eventSet.remove(),1);
        assertTrue(coffeeSh2.cashiers.cashierLine.get(0).waitTime==0);
    }
}

