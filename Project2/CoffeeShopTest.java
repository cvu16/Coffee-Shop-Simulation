import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CoffeeShopTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CoffeeShopTest
{
    /**
     * Default constructor for test class CoffeeShopTest
     */
    public CoffeeShopTest()
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
    public void eventCreation()
    {
        CoffeeShop coffeeSh1 = new CoffeeShop(1, 1, 3, 5, 6, 9);
        coffeeSh1.addArrival(1, 5);
        coffeeSh1.addArrival(2, 5);
        coffeeSh1.addArrival(3, 6);
        coffeeSh1.addArrival(5, 6);
        coffeeSh1.addArrival(6, 6);
        coffeeSh1.addArrival(7, 8);
        coffeeSh1.addArrival(8, 8);
        coffeeSh1.addArrival(9, 9);
        assertTrue(coffeeSh1.eventSet.size()==8);
    }
    
    @Test
    public void findMinCashier()
    {
        CoffeeShop coffeeSh1 = new CoffeeShop(2, 1, 3, 5, 6, 9);
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        assertTrue(coffeeSh1.minCashier()==1);
    }
    
    @Test
    public void findMinCashierNull()
    {
        CoffeeShop coffeeSh1 = new CoffeeShop(3, 1, 3, 5, 6, 9);
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        assertTrue(coffeeSh1.minCashier()==2);
    }
    
    @Test
    public void calculateWaitLine()
    {
        CoffeeShop coffeeSh1 = new CoffeeShop(3, 1, 3, 5, 6, 9);
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(0).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        coffeeSh1.cashier.get(1).add(new Customer(3));
        float result = coffeeSh1.lineWait(0);
        float result1 = coffeeSh1.lineWait(1);
        assertTrue(Float.compare(coffeeSh1.lineWait(0),(float)18)==0);
        assertTrue(Float.compare(coffeeSh1.lineWait(1),(float)9)==0);
    }
    
    @Test
    public void calculateWaitLineEmpt()
    {
        CoffeeShop coffeeSh1 = new CoffeeShop(3, 1, 3, 5, 6, 9);
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        coffeeSh1.cashier.add(new ArrayDeque<Customer>(8));
        float result = coffeeSh1.lineWait(0);
        float result1 = coffeeSh1.lineWait(1);
        assertTrue(Float.compare(coffeeSh1.lineWait(0),(float)0)==0);
        assertTrue(Float.compare(coffeeSh1.lineWait(1),(float)0)==0);
    }
}

