
import java.util.*;
public class QueueFrontier implements Frontier{

    private LinkedList<Location> queue;
    private int size;

    public QueueFrontier() {
	queue = new LinkedList<Location>();
	size = 0;
    }

    public void add(Location l) {
	queue.add(l);
	size ++;
    }

    public Location next() {
	size --;
	return queue.remove();
    }

    public int getSize() {
	return size;
    }
    
}