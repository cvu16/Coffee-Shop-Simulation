import java.util.*;
/**
 * Event class that implements Comparable
 * to arrange by the time of occurrence
 *
 * @author EvanVu
 * Adapted from Mark Allan Weiss
 */
public class Event implements Comparable<Event>
{
    int time;
    char type;
    Customer cus;
    
    public Event(){
        this(null,-1,'a');
    }
    
    public Event(Customer cus, int time, char type){
        this.cus=cus;
        this.time=time;
        this.type=type;
    }
    
    public int compareTo( Event rhs )
        {
            return time - rhs.time;
        }
}