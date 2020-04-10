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
    int lineNum;
    int cusNum;
    
    public Event(){
        this(-1,-1,'a',-1);
    }
    
    public Event(int cusNum, int time, char type, int lineNum){
        this.cusNum=cusNum;
        this.time=time;
        this.type=type;
        this.lineNum=lineNum;
    }
    
    public int compareTo( Event rhs )
        {
            return time - rhs.time;
        }
}
