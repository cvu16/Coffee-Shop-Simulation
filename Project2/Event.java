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
    int cusNum;
    int time;
    char type;
    
    public Event(){
        this(0,0,'a');
    }
    
    public Event(int cusNum, int time, char type){
        this.cusNum=cusNum;
        this.time=time;
        this.type=type;
    }
    
    public int compareTo( Event rhs )
        {
            return time - rhs.time;
        }
}
