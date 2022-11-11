import java.util.Scanner;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-14;//1e-05; // This is the comparison error. See document for description.
		double d = 1.0;
		double c = 0.0;
		double p = 0.0;
		double m = 0.0;
		double n = 0.0;
		int s = 10000;
		// Insert first Interval into the Priority Queue
		PriorityQueue x = new PriorityQueue(s);
		Interval max = new Interval(a, b);
		x.insert(max);
		c = (max.getLength())*f(max.getEnd());
		//c = (b - a) * f(b);
		while (d > 0) {
			// Next, remove max from the Priority Queue
			max = x.remove_max();//take largest interval
			// Getting First Large interval values
			m = max.getStart(); 
			n = max.getEnd();
			
			// Next, break Large Interval in half 
			p = ((m + n)/2);
	
			// d = new area
			// c = old area
			// Calculate the Area Under the Curve
			d = c - (n - m)*f(n) + (p - m)*f(p) + (n - p)*f(n);
			//Reinsert the new halves back into the Priority Queue.
			if (Math.abs(d - c) <= error) {
				return d;
			} else {
				x.insert(new Interval(m, p));
				x.insert(new Interval(p, n));
				c = d;
			}
		}
		return d;
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
