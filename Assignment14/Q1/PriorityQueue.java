import java.util.Iterator;

public class PriorityQueue<T> implements Iterable<T> {
	
	
	protected PriorityListNode<T> firstNode;
	protected String name;
	protected int lowPriority;
	protected int size = 0;
	

	public Iterator<T> iterator() { 
        
		return (Iterator<T>) new QueueIterator<T>(firstNode); 
    
	} 
	
        	
    	public PriorityListNode<T> getHead() {
    		
    		return firstNode;

    	}
 
    	   
	public PriorityQueue(int lowPriority) {
		
		this.lowPriority =  lowPriority;
		firstNode = null;

	}
	

	public boolean contains(T object) {
		
		PriorityListNode<T> temp = firstNode;
		while (temp!=null) {
			if (temp.getData().equals(object))
				return true;
			temp = temp.getNext();
		}
		
		return false;
		
	}
	
	public boolean remove(T object) {
		
		if (isEmpty())
			return false;
		
		if (firstNode.getData().equals(object)) {
			firstNode = firstNode.getNext();
			size--;
			return true;
		}
		
		PriorityListNode<T> current = firstNode;
		PriorityListNode<T> prev = firstNode;
		while (current!=null) {
			if (current.getData().equals(object)) {
				prev.setNext(current.getNext());
				size--;
				return true;
			}
			prev = current;	
			current = current.getNext();
		}
		
		return false;
	}
	
	public void add(T addItem, int priority) {
		
		if (isEmpty())
			firstNode   = new PriorityListNode<T>(addItem, priority);
		else
		{
			
			PriorityListNode<T> current = firstNode;
			PriorityListNode<T> prev = firstNode;
			
			while (current.getNext() != null && current.getPriority() <= priority) {
						prev = current;
						current = current.getNext();
			}
			
			if (priority > lowPriority)
				priority = lowPriority;
			
			PriorityListNode<T> temp = new PriorityListNode<T>(addItem, priority);
			
			if (current == firstNode) {
				if (current.getPriority() > priority) {
					temp.setNext(firstNode);	
					firstNode = temp;
				}
				else {
					temp.setNext(firstNode.getNext());	
					firstNode.setNext(temp);
				}
			}
				
			else if (current.getNext() == null) {
				if (current.getPriority() > priority) {
					temp.setNext(current);
					prev.setNext(temp);
				}
				else {
					current.setNext(temp);					
				}
			}
			else  {
				prev.setNext(temp);
				temp.setNext(current);
			}
		}
		size++;
	}
	
	
	public int size() {
		
		return this.size;
		
	}
	
	
	public T poll() {
		
		if (isEmpty())
			return null;
				
		T temp = firstNode.getData();
		firstNode = firstNode.getNext();
		size--;
		return temp;
		
	}
	
	
	public boolean isEmpty() {
		
		return firstNode == null;
	
	}
	
	
	public void print() {
		
		if (isEmpty()) {
			System.out.printf("Empty ");
			return;
		}
		
		PriorityListNode<T> current = firstNode;
		
		while (current != null) {
			System.out.printf("%s, priority %d \n", current.toString(), current.getPriority());
			current = current.getNext();
		}
		
		System.out.println();
	}
	
}
