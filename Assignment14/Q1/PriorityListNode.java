class PriorityListNode<T> {
	
	private T data;
	private int priority;
	private PriorityListNode<T> nextNode;


	public 	PriorityListNode(T object, int priority){
			
			this(object, priority, null);
			
		}
		
		
	public	PriorityListNode(T object, int priority, PriorityListNode<T> node){
		
			data = object;
			this.priority = priority;
			nextNode = node;
		}


	T getData() {
		
		return data;
		
	}
	
	PriorityListNode<T> getNext(){
		
		return nextNode;
		
	}
	
	public void setNext(PriorityListNode<T> temp){
		
		nextNode = temp;
			
	}
	
	public int getPriority() {
		
		return priority;
		
	}


	public String toString() {
		
		return "Item is: " + data.toString();
		
	}



	
}
