import java.util.*;
/**
 * A simulation for the Coffee Shop
 *
 * @author EvanVu
 */
public class CoffeeShop
{
    private int cashierNum;
    private final int opTimeInSec = 60*3*60;
    private ArrayDeque<Customer>[] cashier;
    Random r;
    PriorityQueue<Event> eventSet = new PriorityQueue<Event>();
    private int p1;
    private int p2;
    private float cost;
    private int t1;
    private int t2;
    private int overflow;
    
    public CoffeeShop(int cashierNum, int t1, int t2, int cost,
    int p1, int p2){
        this.cashierNum = cashierNum;
        this.cashier = new ArrayDeque[cashierNum];
        this.t1 = t1;
        this.t2 = t2;
        this.cost = cost;
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void nextEvent(){
        
    }
    
    public void checkCashier(){
        
    }
    
    
    public void runSim(){
        int overflow=0;
        
        while (!eventSet.isEmpty()){
            
        
    }
    
    
}