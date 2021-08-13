import java.util.Iterator;

public class QueueIterator<E> implements Iterator<E>{

	PriorityListNode<E> current;

	public QueueIterator(PriorityListNode<E> head) {

		current = head;

	}

	public boolean hasNext() {

		if (current!= null)
			return true;

		return false;

	}

	public E next(){

		 E temp = current.getData();
		
		current = current.getNext();

		return temp;

	}
	
}
	
	
