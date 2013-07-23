import java.util.*;

public class Proof {
	
	LineNumber currentline = new LineNumber();

	public Proof (TheoremSet theorems) {
	}

	public LineNumber nextLineNumber ( ) {
		currentline.next();
		return currentline;
	}

	public void extendProof (String x) throws IllegalLineException, IllegalInferenceException {
	}

	public String toString ( ) {
		return "";
	}

	public boolean isComplete ( ) {
		return true;
	}
}