

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CashiersTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CashiersTest
{
    /**
     * Default constructor for test class CashiersTest
     */
    public CashiersTest()
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
    public void add()
    {
        Cashiers cashiers1 = new Cashiers(2);
        assertEquals(true, cashiers1.addToCashier(new Customer(2,3,2,3,0)));
        assertEquals(1, cashiers1.findEmpty());
    }

    @Test
    public void findEmpty()
    {
        Cashiers cashiers1 = new Cashiers(3);
        assertEquals(true, cashiers1.addToCashier(new Customer(1,2,2,3,0)));
        assertEquals(1, cashiers1.findEmpty());
        assertEquals(true, cashiers1.addToCashier(new Customer(3,4,3,4,1)));
        assertEquals(2, cashiers1.findEmpty());
    }

    @Test
    public void remove()
    {
        Cashiers cashiers1 = new Cashiers(1);
        assertEquals(true, cashiers1.addToCashier(new Customer(1,2,3,4,0)));
        assertEquals(null, cashiers1.removeCus(new Customer(1,2,3,4,0)));
    }

    @Test
    public void removeFromWait()
    {
        Cashiers cashiers1 = new Cashiers(1);
        Customer wait = new Customer(2,3,3,4,-1);
        cashiers1.addToWaitLine(wait);
        assertEquals(true, cashiers1.addToCashier(new Customer(1,2,3,4,0)));
        assertEquals(wait, cashiers1.removeCus(new Customer(1,2,3,4,0)));
    }
}




