import java.util.*;
public class CoffeeShopSim{
    private int cashierNum;
    private final int opTime = 60*18*60;
    Cashiers cashiers;
    PriorityQueue<Event> eventSet = new PriorityQueue<Event>();
    private float p1;
    private float p2;
    private float cost;
    private int t1;
    private int t2;
    private int overflow=0;
    float profit=0;
    private int waitTotal=0;
    
    
    public CoffeeShopSim(int cashierNum, int t1, int t2, float cost,
    float p1, float p2){
        this.cashierNum = cashierNum;
        this.cashiers = new Cashiers(cashierNum);
        this.t1 = t1;
        this.t2 = t2;
        this.cost = cost;
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void addArrival(int time){
        this.eventSet.add(new Event(null,time,'a'));
    }
    
    public void departure(Event nextE, int count){
        if(nextE.cus.lineNum==-1){
            throw new IllegalArgumentException("-1");
        }
        int newTime = nextE.time;
        Customer cusFromWait = cashiers.removeCus(nextE.cus);
        if(cusFromWait==null) return;
        newTime+=cusFromWait.waitTime;
        eventSet.add(new Event(cusFromWait,newTime,'d'));
    }
    
    public void arrival(Event nextE,int count){
        nextE.cus=new Customer(t1,t2,p1,p2,cashiers.findEmpty());
        if (nextE.cus.lineNum==-1){
            cashiers.addToWaitLine(nextE.cus);
            return;
        }
        else{
            cashiers.addToCashier(nextE.cus);
            nextE.time+=nextE.cus.waitTime;
            nextE.type='d';
            eventSet.add(nextE);
            return;
        }
    }
        
    
    public void runSim(){
        int count=0;
        int slots=this.cashierNum*8 + this.cashierNum;
        Event nextE = null;
        while(!eventSet.isEmpty()){
            nextE=eventSet.remove();
            if (nextE.time>opTime && nextE.type=='a') break;
            if (nextE.type=='d'){
                slots++;
                this.departure(nextE, count);
            }
            else if (nextE.type=='a'){
                if(slots>0){
                    slots--;
                    this.arrival(nextE, count);
                    profit+=nextE.cus.profit;
                    waitTotal+=nextE.cus.waitTime;
                    count++;
                }
                else overflow++;
            }
        }
        System.out.println("Shop is closed. Average wait " +(float)waitTotal/count+". Number of overflows: " + overflow + ". Profit: " +
        (profit - (float)cost*cashierNum));
    }
}