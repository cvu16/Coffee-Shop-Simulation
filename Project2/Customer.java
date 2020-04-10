import java.util.*;
/**
 * Customer class
 *
 * @author EvanVu
 */
public class Customer implements Comparable<Customer>
{
    //Seconds after arrival that the Customer arrives
    int arrivalTime;

    /**
     * Constructor for a Customer
     */
    public Customer(int arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public int compareTo(Customer cmp){
        return this.arrivalTime - cmp.arrivalTime;
    }
}
