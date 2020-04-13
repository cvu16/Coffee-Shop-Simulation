import java.util.*;
/**
 * A simulation for the Coffee Shop
 *
 * @author EvanVu
 */
public class CoffeeShop
{
    private int cashierNum;
    private final int opTime = 60*18*60;
    ArrayList<ArrayDeque<Customer>> cashier;
    Random r = new Random(System.nanoTime());
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
        this.cashier = new ArrayList<ArrayDeque<Customer>>();
        for (int i=0; i<cashierNum; i++){
            this.cashier.add(new ArrayDeque<Customer>(8));
        }
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
            if(this.cashier.get(i).isEmpty()){
                result=i;
                break;
            }
            if(this.cashier.get(i).size()<temp){
                temp=this.cashier.get(i).size();
                result=i;
            }
        }
        return result;
    }

    public int lineWait(int cashierNum){
        int result=0;
        for(Customer cus:cashier.get(cashierNum)){
            result+=cus.waitTime;
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
               System.out.println("User" + nextE.cusNum + "leaves at time" + nextE.time);
           }
           else if (nextE.type=='a'){
               System.out.print("User" + nextE.cusNum + "comes at" + nextE.time);
               if (slots>0){
                   slots--;
                   int cashNo=this.minCashier();
                   int howlong=this.lineWait(cashNo);
                   profit+=p1 + r.nextFloat()*(p2-p1);
                   Customer newCus = new Customer(r.nextInt(t2-t1)+t1);
                   howlong+=newCus.waitTime;
                   cashier.get(cashNo).add(newCus);
                   System.out.println("and takes" + howlong);
                   nextE.type='d';
                   nextE.lineNum=cashNo;
                   nextE.time+=howlong;
                   eventSet.add(nextE);
               }
               else overflow++;
           }
        }
        System.out.println("Shop is closed. Number of overflows: " + overflow + ". Profit: " +
        (profit - (float)cost*cashierNum));
    }
}
    
