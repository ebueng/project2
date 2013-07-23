public class LineNumber {
	
	private int current;
	private LineNumber myRest;
	
	public LineNumber() {
		current = 1;
		myRest = null;
	}
	
	public LineNumber(LineNumber rest) {
		current = 1;
		myRest = rest;
	}
	
	//show = addSubLineNumber
	//co = removeSubLineNumber
	
	public void next() {
		current++;
	}
	
	public void addSubLineNumber() {
		myRest = new LineNumber(null);
	}
	
	public void removeSubLineNumber() {
		current++;
		myRest = null;
	}
	
	public String toString() {
		if(myRest == null) {
			return "" + current;
		}
		return "" + current + "." + myRest.toString();
	}
	
	public static void main(String[] args) {	
	
	LineNumber test = new LineNumber();
	System.out.println(test.toString());
	test.addSubLineNumber();
	test.myRest.next();
	System.out.println(test.toString());
	test.myRest.addSubLineNumber();
	System.out.println(test.toString());
	test.myRest.removeSubLineNumber();
	System.out.println(test.toString());
	}
}