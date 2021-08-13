
public class CustomerCase {

	private String idNum;
	private String custName;
	private String custCase;
	
	CustomerCase(String idNum,String custName, String custCase){
		
		this.idNum = idNum;
		this.custName = custName;
		this.custCase = custCase;
		
	}
	
	public String toString() {
		
		return "Customer ID: " + idNum + ", customer name: " + custName + ", problem: " + custCase;
	}
	
	
	public boolean equals(Object object) {

		if (this.idNum == ((CustomerCase)object).idNum && this.custName == ((CustomerCase)object).custName && this.custCase == ((CustomerCase)object).custCase)
			return true;
		
		return false;
		
	}
	
}
