import java.util.*;
/**
 * A simulation for the Coffee Shop
 *
 * @author EvanVu
 */
public class CoffeeShop
{
    private int cashierNum;
    private final int opTime = 60*3*60;
    private ArrayList<ArrayDeque<Customer>> cashier;
    Random r;
    PriorityQueue<Event> eventSet = new PriorityQueue<Event>();
    private float p1;
    private float p2;
    private float cost;
    private int t1;
    private int t2;
    private int overflow;
    
    public CoffeeShop(int cashierNum, int t1, int t2, float cost,
    float p1, float p2){
        this.cashierNum = cashierNum;
        this.cashier = new ArrayList<ArrayDeque<Customer>>(cashierNum);
        this.t1 = t1;
        this.t2 = t2;
        this.cost = cost;
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void addArrival(int cusNum, int time){
        this.eventSet.add(new Event(cusNum,time,'a',-1));
    }
    
    public int minCashier(){
        int result=-1;
        int temp=9;
        for(int i=0; i<cashierNum;i++){
            if(this.cashier.get(i).size()<temp){
                temp=this.cashier.get(i).size();
                result=i;
            }
        }
        return result;
    }

    public int lineWait(int cashierNum){
        int result=0;
        int i=0;
        for(Customer cus:cashier.get(i)){
            result+=cus.waitTime;
            i++;
        }
        return result;
    }
    
    public void runSim(){
        int overflow=0;
        float profit=0;
        int slots=this.cashierNum*8;
        Event nextE = null;
        while (!eventSet.isEmpty()){
           nextE = eventSet.remove();
           if (nextE.time > opTime && nextE.type == 'a') break;
           if (nextE.type == 'd'){
               slots++;
               cashier.get(nextE.lineNum).remove();
               System.out.println("User" + nextE.cusNum + "hangs up at time" + nextE.time);
           }
           else {
               System.out.print("User" + nextE.cusNum + "came at" + nextE.time);
               if (slots>0){
                   slots--;
                   int cashNo=this.minCashier();
                   int howlong=this.lineWait(cashNo);
                   profit+=r.nextFloat()*(p2-p1);
                   Customer newCus = new Customer(r.nextInt(t2-t1)+t1);
                   howlong+=newCus.waitTime;
                   cashier.get(cashNo).add(newCus);
                   System.out.println("and takes" + howlong);
                   nextE.type='d';
                   nextE.lineNum=cashNo;
                   eventSet.add(nextE);
               }
               else overflow++; System.out.println("Full shop");
           }
        }
        System.out.println("Shop is closed. Number of overflows: " + overflow + ". Profit: " +
        (profit - (float)cost*cashierNum));
    }
}
    
