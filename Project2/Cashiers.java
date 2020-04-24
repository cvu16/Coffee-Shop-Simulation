import java.util.*;

public class Cashiers{
    ArrayDeque<Customer> waitLine;
    ArrayList<Customer> cashierLine;
    int cashierNum;
    int waitCap;
    
    public Cashiers(int cashierNum){
        this.cashierNum=cashierNum;
        this.cashierLine=new ArrayList<Customer>(cashierNum);
        for(int i=0;i<cashierNum;i++){
            cashierLine.add(new Customer());
        }
        this.waitCap=cashierNum*8;
        this.waitLine=new ArrayDeque<Customer>();
    }
    
    /**
     * Add a new Customer to the Cashiers
     */
    public boolean addToCashier(Customer cus){
        //If there is an empty cashier set that cashier
        if(cus.lineNum!=-1){
            cashierLine.set(cus.lineNum, cus);
            return true;
        }
        else return false;
    }
    
    public boolean addToWaitLine(Customer cus){
        //If there is no empty cashier add to the wait line
            //if the wait line is still open
        if (cus.lineNum==-1 && waitLine.size()<waitCap){
            waitLine.add(cus);
            return true;
        }
            //if the wait line exceeds capacity
        else return false;
    }
    
    /**
     * Set the cashier to null or the first customer in the wait line
     */
    public Customer removeCus(Customer cus){
        if(!waitLine.isEmpty()){
            Customer newCus = waitLine.removeFirst();
            newCus.lineNum=cus.lineNum;
            cashierLine.set(cus.lineNum,newCus);
            return newCus;
        }
        else if (waitLine.isEmpty()){
            cashierLine.set(cus.lineNum,new Customer());
        }
        return null;
    }
    
    /**
     * Find an empty cashier
     */
    public int findEmpty(){
        for(Customer cus:cashierLine){
            if (cus.waitTime==0){
                return cashierLine.indexOf(cus);
            }
        }
        return -1;
    }
}