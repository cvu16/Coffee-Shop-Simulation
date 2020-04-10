import java.util.*;
import java.io.*;
/**
 * Main class to read input into the CoffeeShop simulator
 * Author Evan Vu
 */
public class Main
{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));
        int cusNum=0;
        float p1 = sc.nextFloat();
        float p2 = sc.nextFloat();
        int cost = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        CoffeeShop shop = new CoffeeShop(4,t1,t2,cost,p1,p2);
        while (sc.hasNext()){
            cusNum++;
            String newTime = sc.nextLine();
            String[] time = newTime.split(":");
            int eventTime = (Integer.parseInt(time[0])-6)*3600+Integer.parseInt(time[1])*60 +
            Integer.parseInt(time[2]);
            shop.addArrival(cusNum, eventTime);
        }
        shop.runSim();
    }
}
