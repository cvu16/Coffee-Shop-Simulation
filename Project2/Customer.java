import java.util.*;
/**
 * Customer class
 *
 * @author EvanVu
 */
public class Customer implements Comparable<Customer>
{
    //Seconds that the Customer takes
    int waitTime;
    int lineNum;
    float profit;
    Random r = new Random(System.nanoTime());

    /**
     * Constructor for a Customer
     */
    public Customer(int t1, int t2, float p1, float p2, int lineNum)
    {
        this.profit = p1 + r.nextFloat()*(p2-p1);
        this.lineNum = lineNum;
        this.waitTime= r.nextInt(t2-t1)+t1;
    }
    
    public Customer(){
        this.waitTime=0;
    }

    public int compareTo(Customer cus){
        return this.waitTime - cus.waitTime;
    }
}