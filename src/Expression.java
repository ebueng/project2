import java.util.*;

public class Expression {

	/*
	Example expression: Expression test = new Expression("(p=>(~p=>q))");
		Main PrintOut: 
			Operator is: =>
				  e1 is: p (Variable Expression)
				  e2 is: (~p=>q)) (Which is an expression)
	*/
	
	public String myExpression;
	
	public Expression(String s) throws IllegalArgumentException {
		myExpression = s;
	}
	
	public ExpressionNode parse() {
		return parseToTree(myExpression);
	}
	
	private class ExpressionNode {
		
		private String myOp;
		private ExpressionNode myE1;
		private ExpressionNode myE2;
		
		public ExpressionNode(String op) {
			myOp = op;
			myE1 = myE2 = null;
		}
		
		public ExpressionNode(String op, ExpressionNode e1, ExpressionNode e2) {
			myOp = op;
			myE1 = e1;
			myE2 = e2;
		}
	}
	
	public ExpressionNode parseToTree(String s) {
		if (s.length() < 3) {
			return null;
		}
		// expr is a parenthesized expression.
       	// Strip off the beginning and ending parentheses,
        // find the main/top-level operator (an occurrence of |, &, or => not nested
        // in parentheses, and construct the two subtrees.
        int nesting = 0;
        int opPos = 0;
        int implyPos = 0;
        for (int k=1; k<s.length()-1; k++) {
        	if (s.charAt(k) == '(')
        		nesting++;
        	if (s.charAt(k) == ')')
        		nesting--;
        	if (nesting == 0)
        		if (( s.charAt(k) == '=' && (s.charAt(k+1) == '>'))) 
        			implyPos = k;
        		else if ( s.charAt(k) == '|' || s.charAt(k) == '&')
        			opPos = k;
        }
        if(implyPos != 0) {
        	String e1 = s.substring (1, implyPos);
        	String e2 = s.substring (implyPos+2, s.length()-1);
        	String op = s.substring(implyPos,implyPos+2);
            System.out.println ("expression: " + s);
            System.out.println ("E1: " + e1);
            System.out.println ("operator: " + op);
            System.out.println ("E2: " + e2);
            System.out.println ( );
            return new ExpressionNode(op, parseToTree(e1), parseToTree(e2));
        } else {
        String e1 = s.substring (1, opPos);
        String e2 = s.substring (opPos+1, s.length()-1);
        String op = s.substring (opPos, opPos+1);
        System.out.println ("expression: " + s);
        System.out.println ("E1: " + e1);
        System.out.println ("operator: " + op);
        System.out.println ("E2: " + e2);
        System.out.println ( );
        return new ExpressionNode(op, parseToTree(e1), parseToTree(e2));
        }
	}
	public static void main(String[] args) {
		Expression test = new Expression("(((p=>q)=>q)=>((q=>p)=>p))");
		System.out.print(test.parse());
	}
		
}
