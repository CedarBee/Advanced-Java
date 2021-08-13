public class IntegerTest {
	
	 PriorityQueue<Integer> myQueue;
	 
	 public IntegerTest() {
		
		 myQueue = new  PriorityQueue<Integer>(10);

		 myQueue.add(1, 3);
		 myQueue.add(2, 5);
		 myQueue.add(3, 4);
		 myQueue.add(4, 4);
		 myQueue.add(5, 15);
		 myQueue.add(6, 4);
		 myQueue.add(7, 5);
		 myQueue.add(8, 1);
		 myQueue.add(4, 6);
		 myQueue.add(9, 3);
		 
	  	for (Integer temp : myQueue) {
	  		
	  		System.out.println(temp.toString());
	  		
	  	}
	  	
	  	System.out.println(); 
	  	
	  	System.out.println("Polled item: " + myQueue.poll().toString());
		
	  	System.out.println();
	  	
		System.out.println("contains 20: "+ myQueue.contains(20));
		 
		System.out.println();
		 
		System.out.println("size is: " + myQueue.size());
		
		System.out.println();
	 
		 myQueue.remove(4);
		 myQueue.remove(4);
		 myQueue.remove(4);
		 myQueue.remove(5);
		 
	  	for (Integer temp : myQueue) 
	  		System.out.println(temp.toString());
		 
		 System.out.println("size is: "+ myQueue.size());
		 
	 }

}
