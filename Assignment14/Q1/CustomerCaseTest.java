
public class CustomerCaseTest {

	 PriorityQueue<CustomerCase> myQueue;
	 
	 public CustomerCaseTest() {

		 myQueue = new PriorityQueue<CustomerCase>(10);

		 myQueue.add(new CustomerCase("123", "John Doe", "Computer crashes"), 3);
		 myQueue.add(new CustomerCase("456", "Mark Doe", "Black screen"), 1);
		 myQueue.add(new CustomerCase("789", "Sue Doe", "Computer crashes"), 4);
		 myQueue.add(new CustomerCase("123", "John Doe", "Black Screen"), 8);
		 myQueue.add(new CustomerCase("333", "Ben Doe", "Corrupt disk"), 15);
		 myQueue.add(new CustomerCase("444", "Guy Doe", "Corrupt disk"), 4);
		 myQueue.add(new CustomerCase("123", "John Doe", "Computer crashes"), 5);


		 for (CustomerCase temp : myQueue) {

			 System.out.println(temp.toString());

		 }

		 System.out.println();

		 if (myQueue.remove(new CustomerCase("444", "Guy Doe", "Corrupt disk")))
			 System.out.println("Removed item succesfully");

		 System.out.println();

		 for (CustomerCase temp : myQueue) {

			 System.out.println(temp.toString());

		 }

		 System.out.println();

		 System.out.println("Polled item: " + myQueue.poll().toString());

		 System.out.println();

		 for (CustomerCase temp : myQueue) {

			 System.out.println(temp.toString());

		 }

	 }
}
